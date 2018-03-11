
@file:JvmName("LocalTimeRangeUtils")

package es.jaranda.commons.timeutils.utils

import es.jaranda.commons.timeutils.application.properties.TimeRangeContract
import es.jaranda.commons.timeutils.application.rule.impl.CurrentLocalTimeIsInsideTimeRangeRuleImpl
import java.time.*

fun currentInstantIsInsideTimeRange(zoneId : ZoneId,
                                    startRangeHour : Int,
                                    endRangeHour: Int) =
        instantIsInsideHourTimeRange(
                Instant.now(), zoneId, startRangeHour, endRangeHour
        )

fun instantIsInsideHourTimeRange(instant : Instant,
                                 zoneId: ZoneId,
                                 startRangeHour : Int,
                                 endRangeHour: Int) =
        CurrentLocalTimeIsInsideTimeRangeRuleImpl(
                object : TimeRangeContract {
                    override fun getStartHourOfTimeRange(): Int {
                        return startRangeHour
                    }

                    override fun getEndHourOfTimeRange(): Int {
                        return endRangeHour
                    }

                    override fun getAppliedTimeZoneForTimeRange(): String {
                        return zoneId.id
                    }
                }
        ).test(instant)


fun Instant.isInsideHourTimeRange(zoneId : ZoneId,
                                  startRangeHour: Int,
                                  endRangeHour: Int) =
        instantIsInsideHourTimeRange(this, zoneId, startRangeHour, endRangeHour)

fun OffsetDateTime.isInsideHourTimeRange(startRangeHour: Int,
                                         endRangeHour: Int) =
        instantIsInsideHourTimeRange(this.toInstant(), this.offset,
                                     startRangeHour, endRangeHour)

fun ZonedDateTime.isInsideHourTimeRange(startRangeHour: Int,
                                         endRangeHour: Int) =
        instantIsInsideHourTimeRange(this.toInstant(), this.offset,
                startRangeHour, endRangeHour)

fun LocalDateTime.isInsideHourTimeRange(startRangeHour: Int,
                                        endRangeHour: Int) =
        instantIsInsideHourTimeRange(
                this.toInstant(ZoneOffset.UTC),
                ZoneOffset.UTC, startRangeHour, endRangeHour
        )

fun LocalTime.isInsideHourTimeRange(startRangeHour: Int,
                                    endRangeHour: Int) =
        instantIsInsideHourTimeRange(
                this.atDate(
                        LocalDate.of(2018,1,1)
                ).toInstant(ZoneOffset.UTC),
                ZoneOffset.UTC, startRangeHour, endRangeHour
        )
