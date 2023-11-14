package org.ical4j.template.groupware

import net.fortuna.ical4j.extensions.participant.Contact
import net.fortuna.ical4j.vcard.ContentBuilder
import spock.lang.Specification

import java.time.Duration
import java.time.LocalDate
import java.time.ZonedDateTime

class MeetingTest extends Specification {

    def 'create a new meeting'() {
        when: 'a new meeting is created from a template'
        def meeting = new Meeting().apply()

        then: 'the result matches expected'
        meeting as String ==~ /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:https:\/\/ical4j.org\/event-types\/MEETING\r
END:VEVENT\r\n/

        when: 'the meeting is updated with more details'
        def organizer = new ContentBuilder().vcard {
            fn('Big Boss')
            caladruri('mailto:boss@example.com')
        }
        meeting = new Meeting().organizer(organizer)
                .start(LocalDate.of(2023, 11, 13).atStartOfDay())
                .duration(Duration.ofMinutes(30)).apply(meeting)

        then: 'the result matches expected'
        meeting as String ==~ /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:https:\/\/ical4j.org\/event-types\/MEETING\r
ORGANIZER;CN=Big Boss:mailto:boss@example.com\r
DTSTART:20231113T000000\r
DURATION:PT30M\r
END:VEVENT\r\n/

        when: 'the meeting is updated with more details'
        def chair = new ContentBuilder().vcard {
            uid '1234'
            fn('Team Lead')
            caladruri('mailto:lead-by@example.com')
        }
        meeting = new Meeting().chair(new Contact(chair)).apply(meeting)

        then: 'the result matches expected'
        meeting as String ==~ /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
ORGANIZER;CN=Big Boss:mailto:boss@example.com\r
DTSTART:20231113T000000\r
DURATION:PT30M\r
CONCEPT:https:\/\/ical4j.org\/event-types\/MEETING\r
ATTENDEE;CUTYPE=INDIVIDUAL;ROLE=CHAIR:mailto:lead-by@example.com\r
BEGIN:PARTICIPANT\r
PARTICIPANT-TYPE:CONTACT\r
UID:1234\r
CALENDAR-ADDRESS:mailto:lead-by@example.com\r
STRUCTURED-DATA;VALUE=BINARY;ENCODING=BASE64;FMTTYPE=text\/vcard:QkVHSU46VkNBUkQNClVJRDoxMjM0DQpGTjpUZWFtIExlYWQNCkNBTEFEUlVSSTptYWlsdG86bGVhZC1ieUBleGFtcGxlLmNvbQ0KRU5EOlZDQVJEDQo=\r
END:PARTICIPANT\r
END:VEVENT\r\n/
    }

    def 'test meeting creation'() {
        when: 'a new meeting is created'
        def meeting = new Meeting().start(ZonedDateTime.parse('2023-11-11T11:00:00Z'))
                .required(URI.create('mailto:joe@example.com'))
                .optional(URI.create('mailto:sally@example.com'))
                .chair(URI.create('mailto:vanessa@example.com')).apply()

        then: 'the result matches expected'
        meeting as String ==~ /BEGIN:VEVENT\r
DTSTAMP:\d{8}T\d{6}Z\r
DTSTART;TZID=Z:20231111T110000Z\r
END:VEVENT\r\n/
    }
}
