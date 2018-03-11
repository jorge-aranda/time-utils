
package es.jaranda.commons.timeutils.examples.timerangeexample.api.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CurrentDateTimeResponse {
    private final String currentDateTime;

    private final String currentLocalDate;
    private final String currentLocalTime;

    private final Long currentMillis;
}
