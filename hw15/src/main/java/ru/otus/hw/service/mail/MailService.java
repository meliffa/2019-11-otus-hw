package ru.otus.hw.service.mail;

import ru.otus.hw.dto.DigitalPass;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
public interface MailService {
    DigitalPass sendMail(DigitalPass digitalPass);
}
