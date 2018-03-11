
package es.jaranda.commons.timeutils.examples.timerangeexample.api.mapper;

import es.jaranda.commons.timeutils.examples.timerangeexample.api.model.CurrentDateTimeResponse;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Optional;

@Component
public class CurrentDateTimeResponseMapper {

    public CurrentDateTimeResponse map(final OffsetDateTime offsetDateTime) {
        return Optional.ofNullable(offsetDateTime)
                .map(this::internalMap)
                .orElse(null);
    }

    private CurrentDateTimeResponse internalMap(
            final OffsetDateTime offsetDateTime) {
        return CurrentDateTimeResponse.builder()
                .currentDateTime(offsetDateTime)
                .currentLocalDate(offsetDateTime.toLocalDate())
                .currentLocalTime(offsetDateTime.toLocalTime())
                .currentMillis(offsetDateTime.toInstant().toEpochMilli())
            .build();
    }

}
