package ru.otus.hw.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.*;
import org.springframework.integration.support.MessageBuilder;
import ru.otus.hw.dto.DigitalPass;
import ru.otus.hw.service.DigitalPassType;
import ru.otus.hw.service.digitalpass.DigitalPassService;
import ru.otus.hw.service.digitalpass.DigitalPassUtils;
import ru.otus.hw.service.mail.MailService;
import ru.otus.hw.service.passport.CheckPassportService;
import ru.otus.hw.service.register.RegisterService;
import java.util.Random;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
@Configuration
@RequiredArgsConstructor
@EnableIntegration
public class DigitalPassIntegrationConfig {
    public static final String GET_DIGITAL_PASS_METHOD = "getDigitalPass";
    public static final String SEND_MAIL_METHOD = "sendMail";
    public static final String CHECK_PASSPORT_METHOD = "checkPassport";
    public static final String REGISTER_METHOD = "registerDigitalPass";

    private final CheckPassportService checkPassportService;
    private final DigitalPassService digitalPassService;
    private final RegisterService registerService;
    private final MailService mailService;

    @Bean
    public IntegrationFlow digitalPassFlow() {
        return IntegrationFlows.from(
                    DigitalPassUtils.randomDigitalPassSource(),
                    spec -> spec.poller(Pollers.fixedDelay(1000).maxMessagesPerPoll(1))
                )
                .handle(checkPassportService, CHECK_PASSPORT_METHOD)
                .filter(DigitalPass.class, digitalPass -> digitalPass.getForIssue(),
                        endpointSpec -> endpointSpec.discardFlow(discardedPayload()))
                .handle(digitalPassService, GET_DIGITAL_PASS_METHOD)
                .filter(DigitalPass.class, digitalPass -> digitalPass.getForIssue(),
                        endpointSpec -> endpointSpec.discardFlow(discardedPayload()))
                .handle(registerService, REGISTER_METHOD)
                .handle(mailService, SEND_MAIL_METHOD)
                .handle(message -> DigitalPassUtils.issueDigitalPass((DigitalPass) message.getPayload()))
                .get();
    }

    @Bean
    public IntegrationFlow discardedPayload() {
        return flow -> flow
                .handle(message -> DigitalPassUtils.refuseDigitalPass((DigitalPass) message.getPayload()));
    }
}
