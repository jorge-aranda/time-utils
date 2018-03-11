
package es.jaranda.commons.timeutils.examples.timerangeexample.infrastructure.configuration;

import es.jaranda.commons.timeutils.application.properties.TimeRangeContract;
import es.jaranda.commons.timeutils.application.rule.CurrentLocalTimeIsInsideTimeRangeRule;
import es.jaranda.commons.timeutils.application.rule.impl.CurrentLocalTimeIsInsideTimeRangeRuleImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeUtilsConfiguration {

    @Bean
    public CurrentLocalTimeIsInsideTimeRangeRule
        currentLocalTimeIsInsideTimeRangeRule(
                final TimeRangeContract timeRangeContract) {
        return new CurrentLocalTimeIsInsideTimeRangeRuleImpl(timeRangeContract);
    }


}
