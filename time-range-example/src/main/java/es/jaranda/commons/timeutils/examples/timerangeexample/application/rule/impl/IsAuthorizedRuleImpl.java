
package es.jaranda.commons.timeutils.examples.timerangeexample.application.rule.impl;

import es.jaranda.commons.timeutils.application.rule.CurrentLocalTimeIsInsideTimeRangeRule;
import es.jaranda.commons.timeutils.examples.timerangeexample.application.rule.IsAuthorizedRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class IsAuthorizedRuleImpl implements IsAuthorizedRule {

    private final CurrentLocalTimeIsInsideTimeRangeRule
            currentLocalTimeIsInsideTimeRangeRule;

    @Override
    public boolean test(final OffsetDateTime offsetDateTime) {
        return Optional.of(offsetDateTime)
                .map(OffsetDateTime::toInstant)
                .filter(currentLocalTimeIsInsideTimeRangeRule)
                .isPresent();
    }

}
