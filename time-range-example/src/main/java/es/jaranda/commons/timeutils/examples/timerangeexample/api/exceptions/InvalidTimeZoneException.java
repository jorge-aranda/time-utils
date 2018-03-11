
package es.jaranda.commons.timeutils.examples.timerangeexample.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.zone.ZoneRulesException;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class InvalidTimeZoneException extends ZoneRulesException {

    public InvalidTimeZoneException(final Throwable cause) {
        super(cause.getMessage(), cause);
    }

}
