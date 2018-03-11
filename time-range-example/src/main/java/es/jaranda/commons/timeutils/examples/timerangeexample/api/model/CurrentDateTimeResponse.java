
package es.jaranda.commons.timeutils.examples.timerangeexample.api.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Builder
@Data
public class CurrentDateTimeResponse {
    private final OffsetDateTime currentDateTime;

    private final LocalDate currentLocalDate;
    private final LocalTime currentLocalTime;

    private final Long currentMillis;
}
