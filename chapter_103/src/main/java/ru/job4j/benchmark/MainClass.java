package ru.job4j.benchmark;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    public static void main(String[] args) {
        Properties app = new Properties();
        try {
            app.load(new FileReader(new File(args[0])));
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            try {
                app.load(app.getClass().getResourceAsStream("/parser/properties/app.properties"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        new MainClass().start(app);
    }

    public void start(Properties app) {
        this.app = app;
        go();

        JobDetail j = JobBuilder.newJob(MainClass.class).build();

        Trigger t = TriggerBuilder.newTrigger().withIdentity("trigger1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(app.getProperty("cron.time"))).build();

        try {
            Scheduler s = StdSchedulerFactory.getDefaultScheduler();
            s.start();
            s.scheduleJob(j, t);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        go();
    }

    public void go() {
        Properties request = new Properties();
        Properties config = new Properties();
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

        VacanciesRecorder vacanciesRecorder = new VacanciesRecorder();
        vacanciesRecorder.start(config, request);
    }
}
