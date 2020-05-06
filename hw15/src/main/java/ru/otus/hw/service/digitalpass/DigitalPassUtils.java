package ru.otus.hw.service.digitalpass;

import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import ru.otus.hw.dto.DigitalPass;
import ru.otus.hw.service.DigitalPassType;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
public class DigitalPassUtils {
    private static Random random = new Random();
    public static final String FULL_NAME = "Тестовый Тест Тестович";
    public static final String MAIL = "test@test.ru";
    public static final String PASSPORT = "1234567890";

    public static Date getToDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    public static void issueDigitalPass(DigitalPass digitalPass) {
        System.out.println("===============================================================");
        System.out.println("issue citizen digital pass: " + digitalPass);
    }

    public static void refuseDigitalPass(DigitalPass digitalPass) {
        System.err.println("===============================================================");
        System.err.println("refuse citizen digital pass: " + digitalPass);
    }

    public static MessageSource<DigitalPass> randomDigitalPassSource() {
        return () -> {
            Integer i = random.nextInt(3);
            DigitalPassType digitalPassType = DigitalPassType.values()[i];
            DigitalPass digitalPass =
                    new DigitalPass(digitalPassType, FULL_NAME, PASSPORT, MAIL);
            return MessageBuilder.withPayload(digitalPass).build();
        };
    }
}
