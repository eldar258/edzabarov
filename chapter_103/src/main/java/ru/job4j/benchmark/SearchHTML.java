package ru.job4j.benchmark;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

/**
 * Class ru.job4j.benchmark.
 *
 * @author edzabarov
 * @since 19.07.2018
 */
public class SearchHTML {

    private static final Logger LOG = LoggerFactory.getLogger(SearchHTML.class);
    private Document document;
    private static final String TODAY = "сегодня";
    private static final String YESTERDAY = "вчера";
    private static final DateFormat CONVERT = new SimpleDateFormat("dd MMM yy, HH:mm", new Locale("ru"));
    private static final DateFormat CONVERT_ONLY_DAY = new SimpleDateFormat("dd MMM yy", new Locale("ru"));
    private static final long TWENTY_FOUR_HOURS = (60 * 60 * 24 * 1000);

    public void connectUrl(String url) throws IOException {
        this.document = Jsoup.connect(url).timeout(10000).get();
    }

    public Queue<Vacancy> search() {
        Elements elements = document.select("#logTable > tbody");
        elements = elements.select("tr");
        Queue<Vacancy> result = new LinkedList<>();

        for (Element el : elements) {
            Element element = el.child(0).child(0);
            String url = element.attr("href");
            Date date = formatStringToDate(searchOnlyDate(url));
            Vacancy vacancy = new Vacancy(url, element.ownText(), new Timestamp(date.getTime()));
            result.add(vacancy);
        }
        return result;
    }

    public String searchOnlyDate(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).timeout(10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(url);
        Elements elements = document.select(
                "td[colspan=2][class=msgFooter]");
        Element element = elements.get(0);
        String date = element.ownText();
        return date.substring(0, date.length() - 13);
    }

    private Date formatStringToDate(String stringDate) {
        char temp = stringDate.charAt(0);
        stringDate = temp == 'с' ? formatStringWrongDateToString(stringDate, SearchHTML.TODAY, 0)
                : temp == 'в' ? formatStringWrongDateToString(stringDate, SearchHTML.YESTERDAY, SearchHTML.TWENTY_FOUR_HOURS)
                : stringDate;
        Date result = null;
        try {
             result = SearchHTML.CONVERT.parse(stringDate);
        } catch (ParseException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    private String formatStringWrongDateToString(String today, String wrongWord, long difference) {
        String time = today.substring(wrongWord.length(), today.length());
        Date day = new Date(System.currentTimeMillis() - difference);
        String dayString = SearchHTML.CONVERT_ONLY_DAY.format(day);
        return dayString + time;
    }
}
