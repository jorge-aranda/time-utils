
package es.jaranda.commons.timeutils.examples.timerangeexample.api.mapper

import spock.lang.Specification

import java.time.ZoneId
import java.time.zone.ZoneRulesException

class ZoneIdMapperSpec extends Specification {

    private final def zoneIdMapper = new ZoneIdMapper()

    def "should map Europe/Madrid timezone"() {
        given:
            def timeZone = "Europe/Madrid"
        when:
            def zoneId = zoneIdMapper.map(timeZone)
        then:
            ZoneId.of("Europe/Madrid") == zoneId
    }

    def "should map default timezone"() {
        given:
            def timeZone = null
        when:
            def zoneId = zoneIdMapper.map()
        then:
            ZoneId.systemDefault() == zoneId
    }

    def "should fail when is present a bad timeZone"() {
        given:
            def timeZone = "Potato"
        when:
            zoneIdMapper.map(timeZone)
        then:
            thrown ZoneRulesException
    }

}
