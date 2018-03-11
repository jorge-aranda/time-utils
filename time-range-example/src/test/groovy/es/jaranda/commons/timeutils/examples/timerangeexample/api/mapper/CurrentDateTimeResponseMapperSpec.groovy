
package es.jaranda.commons.timeutils.examples.timerangeexample.api.mapper

import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneOffset

class CurrentDateTimeResponseMapperSpec extends Specification {

    private final def currentDateTimeResponseMapper =
            new CurrentDateTimeResponseMapper()

    def "Should map all fields"() {
        given:
            def offsetDateTime = OffsetDateTime.of(
                    LocalDateTime.of(2017, 3, 11,
                            15, 0, 10), ZoneOffset.UTC
            )
        when:
            def response = currentDateTimeResponseMapper.map(offsetDateTime)
        then:
            response.currentDateTime ==
                    OffsetDateTime.parse("2017-03-11T15:00:10Z")
            response.currentLocalDate == LocalDate.parse("2017-03-11")
            response.currentLocalTime == LocalTime.parse("15:00:10")
            response.currentMillis == 1489244410000
    }

}
