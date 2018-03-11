
package es.jaranda.commons.timeutils.examples.timerangeexample.api.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.zone.ZoneRulesException;

@RestControllerAdvice
public class ControllersConfiguration {

    @ExceptionHandler(ZoneRulesException.class)
    public void handleZoneRulesException(final Exception exception,
                                         final HttpServletResponse response)
            throws IOException {

        response.sendError(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()
        );
    }

}
