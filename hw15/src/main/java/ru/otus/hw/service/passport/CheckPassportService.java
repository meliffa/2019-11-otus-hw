package ru.otus.hw.service.passport;

import ru.otus.hw.dto.DigitalPass;

/**
 * Created by Inna Spodarik on 27.04.2020.
 */
public interface CheckPassportService {
    DigitalPass checkPassport(DigitalPass citizenDigitalPassReq);
}
