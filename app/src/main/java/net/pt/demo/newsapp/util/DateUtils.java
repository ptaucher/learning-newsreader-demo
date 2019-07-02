package net.pt.demo.newsapp.util;

import com.google.firebase.crash.FirebaseCrash;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

    public static String formatNewsApiDate(String inputDate) {
        final DateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        final DateFormat outputDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");
        try {
            return outputDateFormat.format(inputDateFormat.parse(inputDate));
        } catch (ParseException ex) {
            FirebaseCrash.report(ex);
            return inputDate;
        }
    }
}
