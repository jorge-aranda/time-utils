
package es.jaranda.commons.timeutils.examples.timerangeexample.application.usecase.impl;

import es.jaranda.commons.timeutils.examples.timerangeexample.application.usecase.RetrieveCurrentDateTimeUseCase;
import es.jaranda.commons.timeutils.examples.timerangeexample.domain.service.InstantService;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;

// TODO make unit test
@Component
public class RetrieveCurrentDateTimeUseCaseImpl
        implements RetrieveCurrentDateTimeUseCase {

    private final InstantService instantService;

    public RetrieveCurrentDateTimeUseCaseImpl(final InstantService instantService) {
        this.instantService = instantService;
    }

    @Override
    public OffsetDateTime apply(final ZoneId zoneId) {
        return instantService.now().atZone(zoneId).toOffsetDateTime();
    }

}
