
package es.jaranda.commons.timeutils.application.rule.impl;

import es.jaranda.commons.timeutils.application.properties.TimeRangeContract;
import es.jaranda.commons.timeutils.application.rule.
        CurrentLocalTimeIsInsideTimeRangeRule;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;

public class CurrentLocalTimeIsInsideTimeRangeRuleImpl
       implements CurrentLocalTimeIsInsideTimeRangeRule {

    private final TimeRangeContract timeRangeContract;

    public CurrentLocalTimeIsInsideTimeRangeRuleImpl(
            final TimeRangeContract timeRangeContract) {
        this.timeRangeContract = timeRangeContract;
    }

    @Override
    public boolean test(final Instant currentInstant) {
        final ZoneId zoneId = ZoneId.of(
                timeRangeContract.getAppliedTimeZoneForTimeRange()
        );
        final Integer minHour = timeRangeContract.getStartHourOfTimeRange();
        final Integer maxHour = timeRangeContract.getEndHourOfTimeRange();

        final LocalTime minLocalTime = LocalTime.of(minHour, 0);
        final LocalTime maxLocalTime = LocalTime.of(
                maxHour, 59, 59, 999_999_999
        );
        final LocalTime currentLocalTime =
                currentInstant.atZone(zoneId).toLocalTime();

        final boolean sameDayInterval =
                isSameDayInterval(minLocalTime, maxLocalTime, currentLocalTime);
        final boolean betweenDaysInterval = isBetweenDaysInterval(
                minLocalTime, maxLocalTime, currentLocalTime
        );

        return sameDayInterval || betweenDaysInterval;
    }

    private boolean isBetweenDaysInterval(final LocalTime minLocalTime,
                                          final LocalTime maxLocalTime,
                                          final LocalTime currentLocalTime) {
        return minLocalTime.isAfter(maxLocalTime) &&
                (currentLocalTime.isAfter(minLocalTime) ||
                 currentLocalTime.isBefore(maxLocalTime));
    }

    private boolean isSameDayInterval(final LocalTime minLocalTime,
                                      final LocalTime maxLocalTime,
                                      final LocalTime currentLocalTime) {
        return !minLocalTime.isAfter(maxLocalTime) &&
                !currentLocalTime.isAfter(maxLocalTime) &&
                !currentLocalTime.isBefore(minLocalTime);
    }
}
