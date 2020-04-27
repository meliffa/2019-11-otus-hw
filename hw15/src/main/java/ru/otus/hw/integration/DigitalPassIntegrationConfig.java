package ru.otus.hw.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import ru.otus.hw.service.digitalpass.DigitalPassService;
import ru.otus.hw.service.mail.MailService;
import ru.otus.hw.service.passport.CheckPassportService;
import ru.otus.hw.service.register.RegisterService;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
@Configuration
@RequiredArgsConstructor
public class DigitalPassIntegrationConfig {

    public static final String GET_DIGITAL_PASS_METHOD = "getDigitalPass";
    public static final String SEND_MAIL_METHOD = "sendMail";
    public static final String CHECK_PASSPORT_METHOD = "checkPassport";
    public static final String REGISTER_METHOD = "registerDigitalPass";
    public static final String DIGITAL_PASS_REQ_CHANNEL = "digitalPassReqChannel";
    public static final String OUTPUT_CHANNEL = "outputChannel";

    private final CheckPassportService checkPassportService;
    private final DigitalPassService digitalPassService;
    private final RegisterService registerService;
    private final MailService mailService;

    @Bean
    public DirectChannel outputChannel() {
        return new DirectChannel();
    }

    @Bean
    public PublishSubscribeChannel digitalPassReqChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers
                .fixedRate(60)
                .maxMessagesPerPoll(1)
                .get();
    }

    @Bean
    public IntegrationFlow digitalPassFlow() {
        return IntegrationFlows.from(DIGITAL_PASS_REQ_CHANNEL)
                .handle(checkPassportService, CHECK_PASSPORT_METHOD)
                .handle(digitalPassService, GET_DIGITAL_PASS_METHOD)
                .handle(registerService, REGISTER_METHOD)
                .handle(mailService, SEND_MAIL_METHOD)
                .channel(OUTPUT_CHANNEL)
                .get();
    }

}
