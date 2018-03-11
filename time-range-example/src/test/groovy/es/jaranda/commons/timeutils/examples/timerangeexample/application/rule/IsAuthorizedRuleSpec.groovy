
package es.jaranda.commons.timeutils.examples.timerangeexample.application.rule

import es.jaranda.commons.timeutils.application.rule.CurrentLocalTimeIsInsideTimeRangeRule
import es.jaranda.commons.timeutils.examples.timerangeexample.application.rule.impl.IsAuthorizedRuleImpl
import spock.lang.Specification

import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset

class IsAuthorizedRuleSpec extends Specification {

    private final def currentLocalTimeIsInsideTimeRangeRuleMock =
            Mock(CurrentLocalTimeIsInsideTimeRangeRule)

    private final def isAuthorizedRule = new IsAuthorizedRuleImpl(
            currentLocalTimeIsInsideTimeRangeRuleMock
    )

    def "Should be authorized"() {
        given:
            def offsetDateTime = OffsetDateTime.of(
                    LocalDateTime.of(2017, 3, 11,
                            15, 0, 0), ZoneOffset.UTC
            )
        when:
            def isAuthorized =
                    isAuthorizedRule.test(offsetDateTime)
        then:
            1 * currentLocalTimeIsInsideTimeRangeRuleMock.test(
                    offsetDateTime.toInstant()
            ) >> true
            isAuthorized
    }

    def "Should not be authorized"() {
        given:
            def offsetDateTime = OffsetDateTime.of(
                    LocalDateTime.of(2017, 3, 11,
                            15, 0, 0), ZoneOffset.UTC
            )
        when:
            def isAuthorized =
                    isAuthorizedRule.test(offsetDateTime)
        then:
            1 * currentLocalTimeIsInsideTimeRangeRuleMock.test(
                    offsetDateTime.toInstant()
            ) >> false
            !isAuthorized
    }

}
