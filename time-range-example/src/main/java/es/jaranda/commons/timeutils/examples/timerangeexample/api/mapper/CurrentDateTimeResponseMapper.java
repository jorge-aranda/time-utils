
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

        return new CurrentDateTimeResponse(
                offsetDateTime.toString(),
                offsetDateTime.toLocalDate().toString(),
                offsetDateTime.toLocalTime().toString(),
                offsetDateTime.toInstant().toEpochMilli()
        );
    }

}
