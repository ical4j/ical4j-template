package org.ical4j.template.vevent

import org.ical4j.template.property.Repeats
import spock.lang.Specification

import java.time.LocalDate
import java.time.MonthDay

class AnniversaryTest extends Specification {

    def 'test anniversary creation'() {
        expect: 'result matches expected'
        new Anniversary('Repeats.YEARLY', date) as String ==~ expectedValue

        where:
        date                    | expectedValue
        LocalDate.of(0, 12, 25) | /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
TRANSP:TRANSPARENT\r
SUMMARY:Repeats.YEARLY\r
DTSTART;VALUE=DATE:00011225\r
RRULE:FREQ=YEARLY;INTERVAL=1\r
END:VEVENT\r\n/
    }
}
