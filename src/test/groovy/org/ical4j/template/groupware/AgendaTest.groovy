package org.ical4j.template.groupware

import net.fortuna.ical4j.model.ComponentGroup
import net.fortuna.ical4j.model.ComponentList
import net.fortuna.ical4j.model.component.VToDo
import net.fortuna.ical4j.model.property.Summary
import net.fortuna.ical4j.model.property.Uid
import spock.lang.Specification

class AgendaTest extends Specification {

    def 'create a new agenda'() {
        when: 'an agenda is created from the default template'
        def agenda = new Agenda().apply()

        then: 'the result matches expected'
        agenda as String ==~ /BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:ical4j:concept:action:agenda\r
END:VTODO\r\n/

        when: 'the agenda is updated'
        def results = new Agenda().summary('Financial results').uid(new Uid('4')).apply()
        def review = new Agenda().summary('The year in review').uid(new Uid('3')).nextItem(results).apply()
        def welcome = new Agenda().summary('Welcome and introductions').uid(new Uid('2')).nextItem(review).apply()
        agenda = new Agenda().summary('Annual General Meeting (AGM)').uid(new Uid('1')).nextItem(welcome).apply(agenda)

        def components = new ComponentList([agenda, welcome, review, results])

        then: 'the result matches expected'
        components as String ==~ /BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:ical4j:concept:action:agenda\r
SUMMARY:Annual General Meeting \(AGM\)\r
UID:1\r
LINK;VALUE=UID;LINKREL=next:2\r
END:VTODO\r
BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:ical4j:concept:action:agenda\r
SUMMARY:Welcome and introductions\r
UID:2\r
LINK;VALUE=UID;LINKREL=next:3\r
END:VTODO\r
BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:ical4j:concept:action:agenda\r
SUMMARY:The year in review\r
UID:3\r
LINK;VALUE=UID;LINKREL=next:4\r
END:VTODO\r
BEGIN:VTODO\r
DTSTAMP:\d{8}T\d{6}Z\r
CONCEPT:ical4j:concept:action:agenda\r
SUMMARY:Financial results\r
UID:4\r
END:VTODO\r\n/
    }
}
