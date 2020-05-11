package ru.otus.hw.dto;

import lombok.Data;
import ru.otus.hw.service.DigitalPassType;

import java.util.Date;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
@Data
public class DigitalPass {
    String uuid;
    DigitalPassType type;
    String fullName;
    String passport;
    Date fromDate;
    Date toDate;
    String mail;
    Boolean forIssue;

    public DigitalPass(DigitalPassType type, String fullName, String passport, String mail) {
        this.type = type;
        this.fullName = fullName;
        this.passport = passport;
        this.mail = mail;
        this.forIssue = true;
    }
}
