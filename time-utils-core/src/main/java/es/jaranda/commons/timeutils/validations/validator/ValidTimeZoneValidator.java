
package es.jaranda.commons.timeutils.validations.validator;

import es.jaranda.commons.timeutils.validations.annotation.TimeZoneFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.ZoneId;

public class ValidTimeZoneValidator
       implements ConstraintValidator<TimeZoneFormat, String> {

    @Override
    public void initialize(final TimeZoneFormat constraintAnnotation) {}

    @Override
    public boolean isValid(final String value,
                           final ConstraintValidatorContext context) {
        return value == null || ZoneId.getAvailableZoneIds().contains(value);
    }
}
