package org.ical4j.template.vevent


import spock.lang.Specification

import java.time.LocalDate

class AnniversaryTest extends Specification {

    def 'test anniversary creation'() {
        expect: 'result matches expected'
        new Anniversary('Repeats.YEARLY', date) as String ==~ expectedValue

        where:
        date                    | expectedValue
        LocalDate.of(0, 12, 25) | /BEGIN:VCALENDAR\r
CALSCALE:GREGORIAN\r
VERSION:2.0\r
BEGIN:VEVENT\r
UID:.+\r
DTSTAMP:\d{8}T\d{6}Z\r
TRANSP:TRANSPARENT\r
RRULE:FREQ=YEARLY;INTERVAL=1\r
DTSTART;VALUE=DATE:00011225\r
SUMMARY:Repeats.YEARLY\r
END:VEVENT\r
END:VCALENDAR\r\n/
    }

    def 'test anniversary revision creation'() {
        given: 'an anniversary instance with one revision'
        Anniversary anniversary = ['Repeats.YEARLY', LocalDate.of(0, 12, 25)]
        anniversary.withRevision().withSummary('Christmas Day')

        expect: 'result matches expected'
        anniversary as String ==~ expectedValue

        where:
        date                    | expectedValue
        LocalDate.of(0, 12, 25) | /BEGIN:VCALENDAR\r
CALSCALE:GREGORIAN\r
VERSION:2.0\r
BEGIN:VEVENT\r
UID:.+\r
DTSTAMP:\d{8}T\d{6}Z\r
TRANSP:TRANSPARENT\r
RRULE:FREQ=YEARLY;INTERVAL=1\r
DTSTART;VALUE=DATE:00011225\r
SUMMARY:Repeats.YEARLY\r
END:VEVENT\r
BEGIN:VEVENT\r
UID:.+\r
DTSTAMP:\d{8}T\d{6}Z\r
TRANSP:TRANSPARENT\r
RRULE:FREQ=YEARLY;INTERVAL=1\r
DTSTART;VALUE=DATE:00011225\r
SEQUENCE:1\r
SUMMARY:Christmas Day\r
END:VEVENT\r
END:VCALENDAR\r\n/
    }
}
