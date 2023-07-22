package org.ical4j.template.vevent

import net.fortuna.ical4j.model.Component
import net.fortuna.ical4j.model.component.VEvent
import org.ical4j.template.property.Repeats
import spock.lang.Specification

import java.time.LocalDate

import static java.time.Month.DECEMBER
import static net.fortuna.ical4j.model.Property.SUMMARY

class ObservanceTest extends Specification {

    def 'test creation of public holiday'() {
        given: 'a new template'
        Observance template = ['Christmas Day']

        when: 'initialised'
        Optional<VEvent> event = template.date(LocalDate.of(2019, DECEMBER, 25))
                .repeats(Repeats.YEARLY).toCalendar().getComponent(Component.VEVENT)

        then: 'the event represents a public holiday'
        event.present && event.get().getRequiredProperty(SUMMARY).value == 'Christmas Day'
    }
}
