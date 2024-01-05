package org.ical4j.template.groupware

import net.fortuna.ical4j.extensions.participant.Contact
import net.fortuna.ical4j.model.component.VEvent
import net.fortuna.ical4j.model.property.Summary
import net.fortuna.ical4j.model.property.Uid
import net.fortuna.ical4j.vcard.ContentBuilder
import spock.lang.Specification

import java.time.LocalDateTime

class ActionTest extends Specification {

    def 'create new action'() {
        when: 'an empty action is created'
        def action = new Action().apply()

        then: 'result matches expected'
        action ==~ /BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
END:VTODO\r\n/

        when: 'action is updated'
        def attendee = new ContentBuilder().vcard {
            uid '1234'
            fn('Attendee')
            caladruri('mailto:attendee@example.com')
        }
        action = new Action().participant(new Contact(attendee))
                .summary('Complete outstanding code reviews')
                .due(LocalDateTime.of(2023, 11, 15, 9, 0))
                .apply(action)

        then: 'result matches expected'
        action ==~ /BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
SUMMARY:Complete outstanding code reviews\r
DUE:20231115T090000\r
BEGIN:PARTICIPANT\r
PARTICIPANT-TYPE:CONTACT\r
UID:1234\r
CALENDAR-ADDRESS:mailto:attendee@example.com\r
STRUCTURED-DATA;VALUE=BINARY;ENCODING=BASE64;FMTTYPE=text\/vcard:QkVHSU46VkNBUkQNClVJRDoxMjM0DQpGTjpBdHRlbmRlZQ0KQ0FMQURSVVJJOm1haWx0bzphdHRlbmRlZUBleGFtcGxlLmNvbQ0KRU5EOlZDQVJEDQo=\r
END:PARTICIPANT\r
END:VTODO\r\n/

    }
}
