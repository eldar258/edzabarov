package ru.job4j.benchmark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 22.07.2018
 */
public class VacanciesRecorder {
    private final Queue<Vacancy> vacancies = new LinkedList<>();
    private static final Logger LOG = LoggerFactory.getLogger(VacanciesRecorder.class);
    private volatile boolean finish = false;
    private final Date defaultDate;

    public VacanciesRecorder() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0);
        defaultDate = calendar.getTime();
    }

    public void start(Properties config, Properties request) {
        Properties app = new Properties();

        Thread adder = new Thread(new Runnable() {
            @Override
            public void run() {
                try (ConnectVacancySQL vacancySQL = new ConnectVacancySQL(config, request)) {
                    vacancySQL.open();
                    Date lastDate = vacancySQL.searchLastDate();
                    if (lastDate == null) {
                        lastDate = defaultDate;
                    }
                    vacancySQL.switchAutoCommit();
                    while (true) {
                        while (!vacancies.isEmpty()) {
                            Vacancy vacancy = vacancies.poll();
                            if (vacancy.getDate().getTime() > lastDate.getTime()) {
                                vacancySQL.addVacancy(vacancy);
                            } else {
                                finish = true;
                                break;
                            }
                        }
                        vacancySQL.commit();
                        try {
                            synchronized (vacancies) {
                                vacancies.wait();
                            }
                        } catch (InterruptedException ignored) {
                            return;
                        }
                    }
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        });

        Thread parser = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                SearchHTML searchHTML = new SearchHTML();
                while (!finish) {
                    try {
                        searchHTML.connectUrl(String.format(config.getProperty("url"), i));
                        Queue<Vacancy> newVacancies = searchHTML.search();
                        if (vacancies.addAll(newVacancies)) {
                            i++;
                            synchronized (vacancies) {
                                vacancies.notifyAll();
                            }
                        } else {
                            finish = true;
                        }
                    } catch (Exception e) {
                        LOG.error(e.getMessage(), e);
                        finish = true;
                    }
                }
                adder.interrupt();
            }
        });

        parser.start();
        adder.start();
        try {
            parser.join();
            adder.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
