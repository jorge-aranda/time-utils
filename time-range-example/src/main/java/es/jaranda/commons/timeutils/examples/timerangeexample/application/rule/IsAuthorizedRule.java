
package es.jaranda.commons.timeutils.examples.timerangeexample.application.rule;

import java.time.OffsetDateTime;
import java.util.function.Predicate;

public interface IsAuthorizedRule extends Predicate<OffsetDateTime> {

}
