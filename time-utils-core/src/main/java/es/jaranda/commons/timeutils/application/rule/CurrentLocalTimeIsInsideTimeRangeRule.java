
package es.jaranda.commons.timeutils.application.rule;

import java.time.Instant;
import java.util.function.Predicate;

public interface CurrentLocalTimeIsInsideTimeRangeRule
       extends Predicate<Instant> { }
