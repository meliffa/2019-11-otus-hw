package ru.otus.hw.service.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.DigitalPass;
import ru.otus.hw.dto.Mail;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
@Service
public class MailServiceImpl implements MailService {

    @Value("${hw15.mailFrom}")
    String mailFrom;

    @Value("${hw15.mailSubject}")
    String mailSubject;

    @Override
    public DigitalPass sendMail(DigitalPass digitalPass) {
        Mail mail = new Mail(mailFrom, digitalPass.getMail(), mailSubject, digitalPass.toString());
        return digitalPass;
    }
}
