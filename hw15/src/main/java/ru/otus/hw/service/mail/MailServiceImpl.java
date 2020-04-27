package ru.otus.hw.service.mail;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.DigitalPass;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
@Service
public class MailServiceImpl implements MailService {
    @Override
    public DigitalPass sendMail(DigitalPass digitalPass) {
        if (digitalPass.getForIssue()) {
            //System.out.println("send mail to " + digitalPass.getMail() + " with digital pass:\n" + digitalPass.toString());
        }
        return digitalPass;
    }
}
