package ru.otus.hw.service.digitalpass;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.DigitalPass;
import ru.otus.hw.service.DigitalPassType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Inna Spodarik on 22.04.2020.
 */
@Service
public class DigitalPassServiceImpl implements DigitalPassService {
    private static Random random = new Random();

    @Override
    public DigitalPass getDigitalPass(DigitalPass digitalPass) {
        if (digitalPass.getForIssue() && digitalPass.getType() != null) {
            DigitalPassType type = digitalPass.getType();

            switch (type) {
                case MEDICAL:
                    return getMedicalDigitalPass(digitalPass);
                case WORKER:
                    return getWorkerDigitalPass(digitalPass);
                case PRIVATE:
                    return getPrivateDigitalPass(digitalPass);
                default:
                    digitalPass.setForIssue(false);
                    return digitalPass;
            }
        }
        return digitalPass;
    }

    private DigitalPass getMedicalDigitalPass(DigitalPass digitalPass) {
        if (digitalPass.getFromDate() == null) digitalPass.setFromDate(new Date());
        digitalPass.setFromDate(DateUtils.truncate(digitalPass.getFromDate(), java.util.Calendar.DAY_OF_MONTH));
        digitalPass.setToDate(DigitalPassUtils.getToDate(new Date()));
        return digitalPass;
    }

    private DigitalPass getWorkerDigitalPass(DigitalPass digitalPass) {
        if (digitalPass.getFromDate() == null) digitalPass.setFromDate(new Date());
        digitalPass.setFromDate(
                DateUtils.truncate(
                        new Date(),
                        Calendar.DAY_OF_MONTH
                )
        );
        digitalPass.setToDate(
                DigitalPassUtils.getToDate(
                        new GregorianCalendar(2020, Calendar.MAY, 31).getTime()
                )
        );
        return digitalPass;
    }

    public DigitalPass getPrivateDigitalPass(DigitalPass digitalPass) {
        Integer i = random.nextInt(3);
        if (i > 1) {
            if (digitalPass.getFromDate() == null) digitalPass.setFromDate(new Date());
            digitalPass.setFromDate(DateUtils.truncate(digitalPass.getFromDate(), java.util.Calendar.DAY_OF_MONTH));
            digitalPass.setToDate(DigitalPassUtils.getToDate(new Date()));
        } else {
            digitalPass.setForIssue(false);
        }
        return digitalPass;
    }
}
