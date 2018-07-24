package ru.job4j.benchmark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 22.07.2018
 */
public class VacanciesRecorder {
    private static final Logger LOG = LoggerFactory.getLogger(VacanciesRecorder.class);
    private final Date defaultDate;
    private Properties config;
    private Properties request;

    public VacanciesRecorder() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0);
        defaultDate = calendar.getTime();
    }

    public void start(Properties config, Properties request) {
        Properties app = new Properties();
        this.config = config;
        this.request = request;
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.produce();
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer.consume();
            }
        });
        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private class ProducerConsumer {
        private final Queue<Vacancy> vacancies = new LinkedList<>();
        private volatile boolean finishProducer = false;
        private volatile boolean finishConsumer = false;


        public void produce() {
            int i = 0;
            SearchHTML searchHTML = new SearchHTML();
            Queue<Vacancy> newVacancies = new LinkedList<>();
            do {
                i++;
                try {
                    searchHTML.connectUrl(String.format(config.getProperty("url"), i));
                    newVacancies = searchHTML.search();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                    break;
                }
                if (!vacancies.addAll(newVacancies)) {
                    finishProducer = true;
                }
                synchronized (vacancies) {
                    vacancies.notifyAll();
                }
            } while (!finishProducer && !finishConsumer);
            synchronized (vacancies) {
                vacancies.notifyAll();
            }
        }

        public void consume() {
            try (ConnectVacancySQL vacancySQL = new ConnectVacancySQL(config, request)) {
                vacancySQL.open();
                Date lastDate = vacancySQL.searchLastDate();
                if (lastDate == null) {
                    lastDate = defaultDate;
                }
                vacancySQL.switchAutoCommit();
                while (!(finishConsumer || vacancies.isEmpty() && finishProducer)) {
                    while (vacancies.isEmpty()) synchronized (vacancies) {
                        vacancies.wait();
                    }
                    while (!vacancies.isEmpty()) {
                        Vacancy vacancy = vacancies.poll();
                        if (vacancy.getDate().getTime() > lastDate.getTime()) {
                            vacancySQL.addVacancy(vacancy);
                        } else {
                            finishProducer = true;
                            finishConsumer = true;
                            break;
                        }
                    }
                    vacancySQL.commit();
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
