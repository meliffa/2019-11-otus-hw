package ru.otus.hw.service.digitalpass;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
public class DigitalPassUtils {

    public static Date getToDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }
}
