
package es.jaranda.commons.timeutils.examples.timerangeexample.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.FORBIDDEN,
                reason="Outside of authorized time range")
public class OutsizeOfTimeRangeException extends RuntimeException { }
