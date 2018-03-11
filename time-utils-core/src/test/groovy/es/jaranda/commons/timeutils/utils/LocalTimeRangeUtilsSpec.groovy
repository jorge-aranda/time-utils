
package es.jaranda.commons.timeutils.utils

import spock.lang.Specification

import java.time.Instant
import java.time.ZoneOffset

class LocalTimeRangeUtilsSpec extends Specification {

    def "Should be inside of range"() {
        given:
            def instant = Instant.parse("2017-03-11T03:00:00Z")
        when:
            def isInside = LocalTimeRangeUtils.instantIsInsideHourTimeRange(
                    instant, ZoneOffset.UTC, 0, 4)
        then:
            isInside
    }

    def "Should be outside of range"() {
        given:
            def instant = Instant.parse("2017-03-11T03:00:00Z")
        when:
            def isInside = LocalTimeRangeUtils.instantIsInsideHourTimeRange(
                    instant, ZoneOffset.MIN, 0, 4)
        then:
            !isInside
    }
}
