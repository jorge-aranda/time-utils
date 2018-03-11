
package es.jaranda.commons.timeutils.examples.timerangeexample.api.controller;

import es.jaranda.commons.timeutils.examples.timerangeexample.api.exceptions.OutsizeOfTimeRangeException;
import es.jaranda.commons.timeutils.examples.timerangeexample.api.mapper.CurrentDateTimeResponseMapper;
import es.jaranda.commons.timeutils.examples.timerangeexample.api.mapper.ZoneIdMapper;
import es.jaranda.commons.timeutils.examples.timerangeexample.api.model.CurrentDateTimeResponse;
import es.jaranda.commons.timeutils.examples.timerangeexample.application.rule.IsAuthorizedRule;
import es.jaranda.commons.timeutils.examples.timerangeexample.application.usecase.RetrieveCurrentDateTimeUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/current-date-time")
@RestController
public class DateTimeController {

    public DateTimeController(final RetrieveCurrentDateTimeUseCase
                                      retrieveCurrentDateTimeUseCase,
                              final IsAuthorizedRule isAuthorizedRule,
                              final ZoneIdMapper zoneIdMapper,
                              final CurrentDateTimeResponseMapper
                                      currentDateTimeResponseMapper) {
        this.retrieveCurrentDateTimeUseCase = retrieveCurrentDateTimeUseCase;
        this.isAuthorizedRule = isAuthorizedRule;
        this.zoneIdMapper = zoneIdMapper;
        this.currentDateTimeResponseMapper = currentDateTimeResponseMapper;
    }

    private final RetrieveCurrentDateTimeUseCase retrieveCurrentDateTimeUseCase;
    private final IsAuthorizedRule isAuthorizedRule;
    private final ZoneIdMapper zoneIdMapper;
    private final CurrentDateTimeResponseMapper currentDateTimeResponseMapper;

    @GetMapping
    public CurrentDateTimeResponse currentDateTimeResponse(
            @RequestParam(required = false) final String timeZone) {

        return Optional.of(zoneIdMapper.map(timeZone))
                .map(retrieveCurrentDateTimeUseCase)
                .filter(isAuthorizedRule)
                .map(currentDateTimeResponseMapper::map)
                .orElseThrow(OutsizeOfTimeRangeException::new);

    }

}
