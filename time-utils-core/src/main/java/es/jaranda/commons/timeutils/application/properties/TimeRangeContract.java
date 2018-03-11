
package es.jaranda.commons.timeutils.application.properties;

import es.jaranda.commons.timeutils.validations.annotation.TimeZoneFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public interface TimeRangeContract {
    @NotNull
    @Min(0)
    @Max(23)
    Integer getStartHourOfTimeRange();

    @NotNull
    @Min(0)
    @Max(23)
    Integer getEndHourOfTimeRange();

    @NotNull
    @TimeZoneFormat
    String getAppliedTimeZoneForTimeRange();
}
