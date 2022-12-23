package org.ical4j.template.property

import org.threeten.extra.Days
import org.threeten.extra.Months
import org.threeten.extra.Weeks
import org.threeten.extra.Years
import spock.lang.Specification

import java.time.LocalDate

import static java.time.DayOfWeek.MONDAY
import static java.time.DayOfWeek.WEDNESDAY
import static java.time.Month.APRIL
import static java.time.Month.MAY

class RecurrenceTest extends Specification {

    def 'test recurrence creation'() {
        expect: 'recurrence matched expected value'
        recurrence as String == expectedValue

        where:
        recurrence              | expectedValue
        Recurrence.of(Days.ONE)                     | 'RRULE:FREQ=DAILY;INTERVAL=1\r\n'
        Recurrence.of(Weeks.of(3))                  | 'RRULE:FREQ=WEEKLY;INTERVAL=3\r\n'
        Recurrence.of(Weeks.of(2))
                .until(LocalDate.of(2022, 12, 23))
                .on(MONDAY, WEDNESDAY)              | 'RRULE:FREQ=WEEKLY;UNTIL=20221223;INTERVAL=2;BYDAY=MO,WE\r\n'
        Recurrence.of(Months.of(3))
                .on(1, 15)                          | 'RRULE:FREQ=MONTHLY;INTERVAL=3;BYMONTHDAY=1,15\r\n'
        Recurrence.of(Years.of(1))
                .on(APRIL, MAY).occurrences(3)      | 'RRULE:FREQ=YEARLY;COUNT=3;INTERVAL=1;BYMONTH=4,5\r\n'
    }
}
