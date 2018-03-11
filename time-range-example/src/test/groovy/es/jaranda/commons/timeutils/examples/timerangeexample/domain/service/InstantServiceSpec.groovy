
package es.jaranda.commons.timeutils.examples.timerangeexample.domain.service

import es.jaranda.commons.timeutils.examples.timerangeexample.domain.service.impl.InstantServiceImpl
import spock.lang.Specification

import java.time.Instant

class InstantServiceSpec extends Specification {

    private final def instantService = new InstantServiceImpl()

    def "Should returns any Instant"() {
        when:
            final def instant = instantService.now()
        then:
            instant != null
            instant instanceof Instant
    }

}
