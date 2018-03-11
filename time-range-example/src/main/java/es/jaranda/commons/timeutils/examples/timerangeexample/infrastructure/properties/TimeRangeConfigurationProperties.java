
package es.jaranda.commons.timeutils.examples.timerangeexample.infrastructure.properties;

import es.jaranda.commons.timeutils.application.properties.TimeRangeContract;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration
@ConfigurationProperties(
        prefix = "es.jaranda.commons.timeutils.examples.timerangeexample")
public class TimeRangeConfigurationProperties implements TimeRangeContract {

    private Integer startHourOfTimeRange;
    private Integer endHourOfTimeRange;
    private String appliedTimeZoneOfTimeRange;

//    @PostConstruct
//    public void init() {
//        ZoneId.of(appliedTimeZoneOfTimeRange);
//    }

    @Override
    public Integer getStartHourOfTimeRange() {
        return startHourOfTimeRange;
    }

    @Override
    public Integer getEndHourOfTimeRange() {
        return endHourOfTimeRange;
    }

    @Override
    public String getAppliedTimeZoneForTimeRange() {
        return appliedTimeZoneOfTimeRange;
    }

    public void setStartHourOfTimeRange(final Integer startHourOfTimeRange) {
        this.startHourOfTimeRange = startHourOfTimeRange;
    }

    public void setEndHourOfTimeRange(final Integer endHourOfTimeRange) {
        this.endHourOfTimeRange = endHourOfTimeRange;
    }

    public void setAppliedTimeZoneOfTimeRange(
            final String appliedTimeZoneOfTimeRange) {
        this.appliedTimeZoneOfTimeRange = appliedTimeZoneOfTimeRange;
    }

}
