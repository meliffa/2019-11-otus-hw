package ru.otus.hw.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.dto.DigitalPass;
import ru.otus.hw.integration.DigitalPassGateway;
import ru.otus.hw.service.DigitalPassType;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
@ShellComponent
@RequiredArgsConstructor
public class IntegrationShellCommander {
    public static final String FULL_NAME = "Тестовый Тест Тестович";
    public static final String MAIL = "test@test.ru";
    public static final String PASSPORT = "1234567890";

    private final DigitalPassGateway digitalPassGateway;

    private DigitalPass digitalPassMedicalReq =
            new DigitalPass(DigitalPassType.MEDICAL, FULL_NAME, PASSPORT, MAIL);

    private DigitalPass digitalPassWorkerReq =
            new DigitalPass(DigitalPassType.WORKER, FULL_NAME, PASSPORT, MAIL);

    private DigitalPass digitalPassPrivateReq =
            new DigitalPass(DigitalPassType.PRIVATE, FULL_NAME, PASSPORT, MAIL);


    @ShellMethod(key = {"g", "gdp"}, value = "Get digital pass")
    public void getDigitalPass() {
        digitalPassGateway.process(digitalPassMedicalReq);
        digitalPassGateway.process(digitalPassWorkerReq);
        digitalPassGateway.process(digitalPassPrivateReq);
    }
}
