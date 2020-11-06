package ru.job4j.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CinemaTest {

    Cinema cinema = new Cinema3D();

    @Test
    public void testFind() {
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        Assert.assertEquals(sessions, Arrays.asList(new Session3D()));
    }
    @Test
    public void testBuy() {
        Account account = new AccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Assert.assertEquals(ticket, new Ticket3D());
    }
    @Test
    public void testAdd() {
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        Session result = sessions.iterator().next();
        Assert.assertEquals(result, new Session3D());
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalPlaceWhenThrowException() {
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        cinema.buy(new AccountCinema(), -1, Integer.MAX_VALUE, date);
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalDateThenThrowException() {
        Calendar date = Calendar.getInstance();
        int pastYear = LocalDateTime.now().minusYears(2).getYear();
        date.set(pastYear, Calendar.NOVEMBER, 10, 23, 0);
        cinema.buy(new AccountCinema(), 1, 1, date);
    }
}