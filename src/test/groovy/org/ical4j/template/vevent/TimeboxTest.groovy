package org.ical4j.template.vevent


import org.ical4j.template.property.Repeats
import org.threeten.extra.Weeks
import spock.lang.Specification

import java.time.LocalDate
import java.time.Period

class TimeboxTest extends Specification {

    def 'test iteration creation'() {
        when: 'an iteration is created'
        Timebox iteration = new Timebox('Two week iteration',
                LocalDate.of(2022, 12, 26),
                Period.ofWeeks(2))
                .repeats(new Repeats(Weeks.of(2)))

        then: 'the event matches expected value'
        iteration as String ==~ /(?m)BEGIN:VCALENDAR\r
CALSCALE:GREGORIAN\r
VERSION:2.0\r
BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
TRANSP:TRANSPARENT\r
SUMMARY:Two week iteration\r
DTSTART;VALUE=DATE:20221226\r
DURATION:P2W\r
RRULE:FREQ=WEEKLY;INTERVAL=2\r
END:VEVENT\r
END:VCALENDAR\r\n/
    }
}
