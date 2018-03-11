
package es.jaranda.commons.timeutils.examples.timerangeexample.api.mapper;

import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public class ZoneIdMapper {

    public ZoneId map(final String timeZone) {
        return timeZone != null ? ZoneId.of(timeZone) : ZoneId.systemDefault();
    }

}
