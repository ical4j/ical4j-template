package org.ical4j.template.view

import net.fortuna.ical4j.model.component.VEvent
import net.fortuna.ical4j.util.Calendars
import spock.lang.Specification

/*
 * Copyright (c) 2025, Ben Fortuna
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *  o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 
 *  o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 
 *  o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

class EventViewTest extends Specification {

    def 'test event view rendering'() {
        given: 'an event'
        def calendar = Calendars.load(getClass().getResource('/samples/EV_AWS-re-Invent-2025-livestream_Nov-2025.ics'))

        and: 'an event view'
        def eventView = new EventView((VEvent) calendar.getComponent("VEVENT").get(), null)

        expect: 'the output is as expected'
        eventView.toString() == '''Summary: AWS re:Invent 2025 livestream
Start: 🕚 30 Nov 2025, 11:00:00 am
End: 🕟 4 Dec 2025, 4:30:00 pm
Location: 📍 https://reinvent.awslivestream.com/
'''
    }
}
