package ru.otus.hw.service.register;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.DigitalPass;

import java.util.UUID;

/**
 * Created by Inna Spodarik on 27.04.2020.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Override
    public DigitalPass registerDigitalPass(DigitalPass digitalPass) {
        System.out.println("===============================================================");
        if (digitalPass.getForIssue()) {
            digitalPass.setUuid(UUID.randomUUID().toString());
            System.out.println("issue citizen digital pass: " + digitalPass);
        } else {
            System.out.println("refuse citizen digital pass: " + digitalPass);
        }
        return digitalPass;
    }
}
