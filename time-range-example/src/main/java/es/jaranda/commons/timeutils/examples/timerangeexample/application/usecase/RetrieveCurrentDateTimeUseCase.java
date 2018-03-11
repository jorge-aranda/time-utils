
package es.jaranda.commons.timeutils.examples.timerangeexample.application.usecase;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.function.Function;

public interface RetrieveCurrentDateTimeUseCase
        extends Function<ZoneId, OffsetDateTime> {

}
