
package es.jaranda.commons.timeutils.validations.validation

import es.jaranda.commons.timeutils.validations.validator.ValidTimeZoneValidator
import spock.lang.Specification

class ValidTimeZoneValidatorSpec extends Specification {

    private final def validTimeZoneValidator = new ValidTimeZoneValidator()

    def "Should be valid when a valid time zone is passed"() {
        given:
            final def timeZone = "Europe/Madrid"
        when:
            final def valid = validTimeZoneValidator.isValid(timeZone, null)
        then:
            valid
    }

    def "Should be valid when null time zone is passed"() {
        given:
            final def timeZone = null
        when:
            final def valid = validTimeZoneValidator.isValid(timeZone, null)
        then:
            valid
    }

    def "Should be invalid when null time zone is passed"() {
        given:
            final def timeZone = "Europa/Madrid"
        when:
            final def valid = validTimeZoneValidator.isValid(timeZone, null)
        then:
            !valid
    }

}
