
package es.jaranda.commons.timeutils.application.rule

import es.jaranda.commons.timeutils.application.properties.TimeRangeContract
import es.jaranda.commons.timeutils.application.rule.impl.CurrentLocalTimeIsInsideTimeRangeRuleImpl
import spock.lang.Specification

import java.time.Instant
import java.time.OffsetDateTime
import java.time.zone.ZoneRulesException

class CurrentLocalTimeIsInsideTimeRangeRuleSpec extends Specification {

    private static final String UTC_TIME_ZONE_CODE = "UTC"
    private static final String BAD_TIME_ZONE_CODE = "badTimeZone"
    private static final String VALID_ISO_8601_IN_UTC_ZONE =
            "2016-04-15T10:00:00Z"
    private static final String VALID_ISO_8601_IN_UTC_ZONE_MAX_LIMIT =
            "2016-04-15T10:59:59.999Z"

    private static final String VALID_ISO_8601_DAYLIGHT_SAVING_TIME_DAY =
            "2018-03-25T02:30:00+01:00"
    private static final String MADRID_TIME_ZONE_CODE = "Europe/Madrid"

    private final def timeRangeContractMock = Mock(TimeRangeContract)

    private final def currentLocalTimeIsInsideTimeRangeRule =
            new CurrentLocalTimeIsInsideTimeRangeRuleImpl(timeRangeContractMock)



    def "Should be is inside of range when is same day and is between"() {
        given:
            final def currentInstant = Instant.parse(VALID_ISO_8601_IN_UTC_ZONE)
            1 * timeRangeContractMock.startHourOfTimeRange >> 8
            1 * timeRangeContractMock.endHourOfTimeRange >> 11
            1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                    UTC_TIME_ZONE_CODE
        when:
            def isInsideRange =
                currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            isInsideRange
    }

    def "Should be is inside of range when is same day and is not between"() {
        given:
            final def currentInstant = Instant.parse(VALID_ISO_8601_IN_UTC_ZONE)
            1 * timeRangeContractMock.startHourOfTimeRange >> 11
            1 * timeRangeContractMock.endHourOfTimeRange >> 13
            1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                    UTC_TIME_ZONE_CODE
        when:
            def isInsideRange =
                    currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            !isInsideRange
    }

    def "Should be is inside of range when is same day and is min-limit"() {
        given:
            final def currentInstant = Instant.parse(VALID_ISO_8601_IN_UTC_ZONE)
            1 * timeRangeContractMock.startHourOfTimeRange >> 10
            1 * timeRangeContractMock.endHourOfTimeRange >> 15
            1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                UTC_TIME_ZONE_CODE
        when:
            def isInsideRange =
                currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            isInsideRange
    }

    def """Should be is inside of range when is same day and is max hour limit
        """() {
        given:
            final def currentInstant = Instant.parse(VALID_ISO_8601_IN_UTC_ZONE)
            1 * timeRangeContractMock.startHourOfTimeRange >> 8
            1 * timeRangeContractMock.endHourOfTimeRange >> 10
            1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                    UTC_TIME_ZONE_CODE
        when:
            def isInsideRange =
                    currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            isInsideRange
    }

    def "Should be is inside of range when is same day and is max-limit"() {
        given:
            final def currentInstant = Instant.parse(
                    VALID_ISO_8601_IN_UTC_ZONE_MAX_LIMIT
            )
            1 * timeRangeContractMock.startHourOfTimeRange >> 8
            1 * timeRangeContractMock.endHourOfTimeRange >> 10
            1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                    UTC_TIME_ZONE_CODE
        when:
            def isInsideRange =
                    currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            isInsideRange
    }

    def """Should be is inside of range when is same day and is
           min and max hour limit"""() {
        given:
            final def currentInstant = Instant.parse(VALID_ISO_8601_IN_UTC_ZONE)
            1 * timeRangeContractMock.startHourOfTimeRange >> 10
            1 * timeRangeContractMock.endHourOfTimeRange >> 10
            1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                    UTC_TIME_ZONE_CODE
        when:
            def isInsideRange =
                    currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            isInsideRange
    }

    def """Should be is inside of range when is same day and is
           min hour and max limit"""() {
        given:
            final def currentInstant = Instant.parse(
                    VALID_ISO_8601_IN_UTC_ZONE_MAX_LIMIT
            )
            1 * timeRangeContractMock.startHourOfTimeRange >> 10
            1 * timeRangeContractMock.endHourOfTimeRange >> 10
            1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                    UTC_TIME_ZONE_CODE
        when:
            def isInsideRange =
                    currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            isInsideRange
    }

    def """Should be is inside of range when is between two days and is
           between"""() {
        given:
            final def currentInstant = Instant.parse(VALID_ISO_8601_IN_UTC_ZONE)
            1 * timeRangeContractMock.startHourOfTimeRange >> 22
            1 * timeRangeContractMock.endHourOfTimeRange >> 12
            1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                    UTC_TIME_ZONE_CODE
        when:
            def isInsideRange =
                    currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            isInsideRange
    }

    def "Should be outside when is between two days and is not between"() {
        given:
            final def currentInstant = Instant.parse(VALID_ISO_8601_IN_UTC_ZONE)
            1 * timeRangeContractMock.startHourOfTimeRange >> 11
            1 * timeRangeContractMock.endHourOfTimeRange >> 15
            1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                    UTC_TIME_ZONE_CODE
        when:
            def isInsideRange =
                    currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            !isInsideRange
    }

    def "Should be outside when is daylight saving and is missing hour of day"() {
        given:
            final def currentInstant = OffsetDateTime.
                    parse(VALID_ISO_8601_DAYLIGHT_SAVING_TIME_DAY).toInstant()
            1 * timeRangeContractMock.startHourOfTimeRange >> 2
            1 * timeRangeContractMock.endHourOfTimeRange >> 2
            1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                    MADRID_TIME_ZONE_CODE
        when:
            def isInsideRange =
                currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            !isInsideRange
    }

    def "Should fail when bad time zone is specified"() {
        given:
        final def currentInstant = Instant.parse(VALID_ISO_8601_IN_UTC_ZONE)
        timeRangeContractMock.startHourOfTimeRange >> 8
        timeRangeContractMock.endHourOfTimeRange >> 11
        1 * timeRangeContractMock.appliedTimeZoneForTimeRange >>
                BAD_TIME_ZONE_CODE
        when:
            currentLocalTimeIsInsideTimeRangeRule.test(currentInstant)
        then:
            final ZoneRulesException ex = thrown()
            ex
    }

}
