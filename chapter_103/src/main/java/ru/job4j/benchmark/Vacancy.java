package ru.job4j.benchmark;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 20.07.2018
 */
public class Vacancy {
    private String url;
    private String text;
    private Timestamp date;

    public Vacancy(String url, String text, Timestamp date) {
        this.url = url;
        this.text = text;
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = new Timestamp(date.getTime());
    }
}
