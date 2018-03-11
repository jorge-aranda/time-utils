
package es.jaranda.commons.timeutils.examples.timerangeexample.application.rule.impl;

import es.jaranda.commons.timeutils.application.rule.CurrentLocalTimeIsInsideTimeRangeRule;
import es.jaranda.commons.timeutils.examples.timerangeexample.application.rule.IsAuthorizedRule;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Optional;

@Component
public class IsAuthorizedRuleImpl implements IsAuthorizedRule {

    private final CurrentLocalTimeIsInsideTimeRangeRule
            currentLocalTimeIsInsideTimeRangeRule;

    public IsAuthorizedRuleImpl(
            final CurrentLocalTimeIsInsideTimeRangeRule
                    currentLocalTimeIsInsideTimeRangeRule) {
        this.currentLocalTimeIsInsideTimeRangeRule =
                currentLocalTimeIsInsideTimeRangeRule;
    }

    @Override
    public boolean test(final OffsetDateTime offsetDateTime) {
        return Optional.of(offsetDateTime)
                .map(OffsetDateTime::toInstant)
                .filter(currentLocalTimeIsInsideTimeRangeRule)
                .isPresent();
    }

}
