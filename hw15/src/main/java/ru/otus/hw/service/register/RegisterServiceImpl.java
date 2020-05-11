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
        digitalPass.setUuid(UUID.randomUUID().toString());
        return digitalPass;
    }
}
