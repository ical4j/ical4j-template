package org.ical4j.template.vevent


import net.fortuna.ical4j.model.Recur
import net.fortuna.ical4j.model.component.VEvent
import org.ical4j.template.property.Repeats
import spock.lang.Specification

import java.time.LocalDate

import static java.time.Month.DECEMBER
import static net.fortuna.ical4j.model.Property.SUMMARY
import static net.fortuna.ical4j.transform.recurrence.Frequency.YEARLY

class ObservanceTest extends Specification {

    def 'test creation of public holiday'() {
        given: 'a builder'
        Observance builder = ['Christmas Day']

        when: 'initialised'
        VEvent event = builder.date(LocalDate.of(2019, DECEMBER, 25))
                .repeats(Repeats.YEARLY)

        then: 'the event represents a public holiday'
        event.getRequiredProperty(SUMMARY).value == 'Christmas Day'
    }
}
