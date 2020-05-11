package ru.otus.hw.service.passport;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.DigitalPass;

/**
 * Created by Inna Spodarik on 27.04.2020.
 */
@Service
public class CheckPassportServiceImpl implements CheckPassportService {

    @Override
    public DigitalPass checkPassport(DigitalPass digitalPass) {
        String passport = digitalPass.getPassport();
        if (passport.length() == 10 && passport.matches("\\d+")) {
            digitalPass.setForIssue(true);
        } else {
            digitalPass.setForIssue(false);
        }
        return digitalPass;
    }
}
