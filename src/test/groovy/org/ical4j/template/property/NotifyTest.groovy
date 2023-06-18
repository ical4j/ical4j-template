package org.ical4j.template.property

import org.threeten.extra.Minutes
import spock.lang.Specification

import java.time.Duration

class NotifyTest extends Specification {

    def 'test notify creation'() {
        expect: 'trigger matched expected value'
        trigger as String == expectedValue

        where:
        trigger                                                 | expectedValue
        new Notify().beforeStart(Minutes.of(10).toDuration())   | 'TRIGGER;RELATED=START;VALUE=DURATION:-PT10M\r\n'
    }
}
