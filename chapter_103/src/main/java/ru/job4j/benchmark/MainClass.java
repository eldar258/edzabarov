package ru.job4j.benchmark;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 22.07.2018
 */
public class MainClass implements Job {
    private static final Logger LOG = LoggerFactory.getLogger(MainClass.class);
    private Properties app;
    private Properties config;
    private Properties request;
    VacanciesRecorder vacanciesRecorder;

    public static void main(String[] args) {
        Properties app = new Properties();

        File file = new File(args.length != 0 ? args[0] : "");
        try {
            if (file.exists()) app.load(new FileReader(file));
            else {
                LOG.warn("File not exist", file.toPath());
                app.load(app.getClass().getResourceAsStream("/parser/properties/app.properties"));
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        new MainClass().start(app);
    }

    public void start(Properties app) {
        this.app = app;
        this.vacanciesRecorder = new VacanciesRecorder();
        initProperties();
        vacanciesRecorder.start(config, request);
        startScheduler();
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        vacanciesRecorder.start(config, request);
    }

    private void startScheduler() {
        JobDetail jobDetail = JobBuilder.newJob(MainClass.class).build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(app.getProperty("cron.time"))).build();

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private void initProperties() {
        request = new Properties();
        config = new Properties();
        try {
            request.load(request.getClass().getResourceAsStream("/parser/properties/request.properties"));
            config.load(config.getClass().getResourceAsStream("/parser/properties/config.properties"));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }

        try {
            Class.forName(app.getProperty("jdbc.driver"));
        } catch (ClassNotFoundException e) {
            LOG.error(e.getMessage(), e);
            return;
        }

        config.setProperty("host", app.getProperty("jdbc.url"));
        config.setProperty("user", app.getProperty("jdbc.username"));
        config.setProperty("password", app.getProperty("jdbc.password"));
    }
}
