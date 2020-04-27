package ru.otus.hw.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.hw.dto.DigitalPass;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
@MessagingGateway
public interface DigitalPassGateway {

    @Gateway(requestChannel = "digitalPassReqChannel", replyChannel = "outputChannel")
    DigitalPass process(DigitalPass digitalPass);

}
