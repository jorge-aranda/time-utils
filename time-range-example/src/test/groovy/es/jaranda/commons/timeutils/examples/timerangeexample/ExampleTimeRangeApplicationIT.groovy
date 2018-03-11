

package es.jaranda.commons.timeutils.examples.timerangeexample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.TestPropertySource
import spock.lang.Specification

@SpringBootTest(classes = ExampleTimeRangeApplication.class)
@TestPropertySource(locations="classpath:test.properties")
class ExampleTimeRangeApplicationIT extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    def "Should start Spring Application Context"() {
        expect:
            applicationContext != null
    }

}
