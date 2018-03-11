
package es.jaranda.commons.timeutils.examples.timerangeexample.application.usecase

import es.jaranda.commons.timeutils.examples.timerangeexample.application.usecase.impl.RetrieveCurrentDateTimeUseCaseImpl
import es.jaranda.commons.timeutils.examples.timerangeexample.domain.service.InstantService
import spock.lang.Specification

import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset

class RetrieveCurrentDateTimeUseCaseSpec extends Specification {

    private final def instantServiceMock = Mock(InstantService)

    private final def retrieveCurrentDateTimeUseCase =
            new RetrieveCurrentDateTimeUseCaseImpl(instantServiceMock)

    def "Should retrieve current OffsetDateTime in chosen ZoneId"() {
        given:
            def zoneId = ZoneId.of("Asia/Tokyo")
            1 * instantServiceMock.now() >>
                    Instant.ofEpochMilli(1520733960651)
        when:
            def offsetDateTime = retrieveCurrentDateTimeUseCase.apply(zoneId)
        then:
            offsetDateTime.year        == 2018
            offsetDateTime.month.value == 3
            offsetDateTime.dayOfMonth  == 11
            offsetDateTime.hour        == 11
            offsetDateTime.minute      == 6
            offsetDateTime.second      == 0
            offsetDateTime.nano        == 651_000_000
            offsetDateTime.offset      == ZoneOffset.of("+09:00")
    }



}
