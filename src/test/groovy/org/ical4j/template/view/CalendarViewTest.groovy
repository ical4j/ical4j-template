package org.ical4j.template.view

import gg.jte.output.StringOutput
import net.fortuna.ical4j.util.Calendars
import org.ical4j.template.TemplateEngineFactory
import spock.lang.Specification

import java.time.YearMonth

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

class CalendarViewTest extends Specification {

    def 'test calendar view rendering'() {
        given: 'a calendar'
        def calendar = Calendars.load(getClass().getResource('/samples/2026-multifaith-calendar-Victoria.ics'))

        and: 'a calendar view'
        def calendarView = new CalendarView(calendar)

        expect: 'the output is as expected'
        calendarView.toString() == '''Calendar Name: 2026-multifaith-calendar-Victoria
Events:
Summary: Mahayana New Year
Start: 📅 3 Jan 2026
End: 📅 4 Jan 2026

Summary: Birthday of Guru Gobind Singh Ji
Start: 📅 5 Jan 2026
End: 📅 6 Jan 2026

Summary: Epiphany
Start: 📅 6 Jan 2026
End: 📅 7 Jan 2026

Summary: Nativity [Orthodox]
Start: 📅 7 Jan 2026
End: 📅 8 Jan 2026

Summary: Maghi
Start: 📅 13 Jan 2026
End: 📅 14 Jan 2026

Summary: Pongal
Start: 📅 14 Jan 2026
End: 📅 18 Jan 2026

Summary: Lailat al Miraj
Start: 📅 16 Jan 2026
End: 📅 17 Jan 2026

Summary: Feast of Epiphany [Orthodox]
Start: 📅 19 Jan 2026
End: 📅 20 Jan 2026

Summary: Lailat al Bara'ah
Start: 📅 3 Feb 2026
End: 📅 4 Feb 2026

Summary: Losar / Tibetan New Year
Start: 📅 10 Feb 2026
End: 📅 11 Feb 2026

Summary: Nirvana Day
Start: 📅 15 Feb 2026
End: 📅 16 Feb 2026

Summary: MahaShivaratri
Start: 📅 15 Feb 2026
End: 📅 16 Feb 2026

Summary: Lunar New Year
Start: 📅 17 Feb 2026
End: 📅 18 Feb 2026

Summary: Ramadan
Start: 📅 17 Feb 2026
End: 📅 19 Mar 2026

Summary: Lent
Start: 📅 18 Feb 2026
End: 📅 3 Apr 2026

Summary: Great Lent [Orthodox]
Start: 📅 23 Feb 2026
End: 📅 4 Apr 2026

Summary: Magha Puja Day
Start: 📅 3 Mar 2026
End: 📅 4 Mar 2026

Summary: Purim
Start: 📅 3 Mar 2026
End: 📅 14 Mar 2026

Summary: Holi
Start: 📅 3 Mar 2026
End: 📅 4 Mar 2026

Summary: Hola Mohalla
Start: 📅 4 Mar 2026
End: 📅 7 Mar 2026

Summary: Sikh New Year
Start: 📅 14 Mar 2026
End: 📅 15 Mar 2026

Summary: Lailat al Qadr
Start: 📅 16 Mar 2026
End: 📅 17 Mar 2026

Summary: Eid ul Fitr
Start: 📅 20 Mar 2026
End: 📅 21 Mar 2026

Summary: Naw Ruz
Start: 📅 21 Mar 2026
End: 📅 22 Mar 2026

Summary: Annunciation
Start: 📅 25 Mar 2026
End: 📅 26 Mar 2026

Summary: Rama Navami
Start: 📅 26 Mar 2026
End: 📅 27 Mar 2026

Summary: Holy Week
Start: 📅 29 Mar 2026
End: 📅 5 Apr 2026

Summary: Mahavir Jayanti
Start: 📅 31 Mar 2026
End: 📅 1 Apr 2026

Summary: Pesach
Start: 📅 2 Apr 2026
End: 📅 10 Apr 2026

Summary: Theravada New Year
Start: 📅 2 Apr 2026
End: 📅 6 Apr 2026

Summary: Good/Holy Friday
Start: 📅 3 Apr 2026
End: 📅 4 Apr 2026

Summary: Easter/Pascha
Start: 📅 5 Apr 2026
End: 📅 6 Apr 2026

Summary: Good/Holy Friday [Orthodox]
Start: 📅 10 Apr 2026
End: 📅 11 Apr 2026

Summary: Easter/Pascha [Orthodox]
Start: 📅 12 Apr 2026
End: 📅 13 Apr 2026

Summary: Yom HaShoah
Start: 📅 14 Apr 2026
End: 📅 15 Apr 2026

Summary: Vaisakhi
Start: 📅 14 Apr 2026
End: 📅 15 Apr 2026

Summary: Ridvan
Start: 📅 21 Apr 2026
End: 📅 3 May 2026

Summary: Vesak / Buddha Day
Start: 📅 1 May 2026
End: 📅 2 May 2026

Summary: Shavuot
Start: 📅 22 May 2026
End: 📅 24 May 2026

Summary: Declaration of the Bab
Start: 📅 24 May 2026
End: 📅 25 May 2026

Summary: Pentecost
Start: 📅 24 May 2026
End: 📅 25 May 2026

Summary: Eid Al Adha
Start: 📅 27 May 2026
End: 📅 31 May 2026

Summary: Ascension of Baha'ullah
Start: 📅 29 May 2026
End: 📅 30 May 2026

Summary: Saga Dawa Duchen
Start: 📅 31 May 2026
End: 📅 1 June 2026

Summary: Martyrdom of Guru Arjun Dev Ji
Start: 📅 16 June 2026
End: 📅 17 June 2026

Summary: Hijra
Start: 📅 16 June 2026
End: 📅 17 June 2026

Summary: Ashura
Start: 📅 26 June 2026
End: 📅 27 June 2026

Summary: Martyrdom of the Bab
Start: 📅 10 July 2026
End: 📅 11 July 2026

Summary: Tisha B'Av
Start: 📅 23 July 2026
End: 📅 24 July 2026

Summary: Asalha Puja
Start: 📅 29 July 2026
End: 📅 30 July 2026

Summary: Assumption of the Blessed Virgin Mary
Start: 📅 15 Aug 2026
End: 📅 16 Aug 2026

Summary: Ullambana
Start: 📅 27 Aug 2026
End: 📅 28 Aug 2026

Summary: Raksha Bandhan
Start: 📅 28 Aug 2026
End: 📅 29 Aug 2026

Summary: Krishna Janmashtami
Start: 📅 4 Sept 2026
End: 📅 5 Sept 2026

Summary: Paryushana
Start: 📅 8 Sept 2026
End: 📅 16 Sept 2026

Summary: Rosh Hashanah
Start: 📅 12 Sept 2026
End: 📅 14 Sept 2026

Summary: Ganesh Chaturthi
Start: 📅 15 Sept 2026
End: 📅 16 Sept 2026

Summary: Samvatsari
Start: 📅 15 Sept 2026
End: 📅 16 Sept 2026

Summary: Daslakshana
Start: 📅 15 Sept 2026
End: 📅 26 Sept 2026

Summary: Yom Kippur
Start: 📅 21 Sept 2026
End: 📅 22 Sept 2026

Summary: Sukkot
Start: 📅 26 Sept 2026
End: 📅 3 Oct 2026

Summary: Kshamavani
Start: 📅 27 Sept 2026
End: 📅 28 Sept 2026

Summary: Shemini Atzeret
Start: 📅 3 Oct 2026
End: 📅 4 Oct 2026

Summary: Simchat Torah
Start: 📅 4 Oct 2026
End: 📅 5 Oct 2026

Summary: Navaratri
Start: 📅 11 Oct 2026
End: 📅 20 Oct 2026

Summary: Dussehra
Start: 📅 20 Oct 2026
End: 📅 21 Oct 2026

Summary: Conferment of Guruship to Guru Granth Sahib
Start: 📅 20 Oct 2026
End: 📅 21 Oct 2026

Summary: Kathina
Start: 📅 25 Oct 2026
End: 📅 26 Oct 2026

Summary: All Saints Day
Start: 📅 1 Nov 2026
End: 📅 2 Nov 2026

Summary: Diwali
Start: 📅 8 Nov 2026
End: 📅 9 Nov 2026

Summary: Bandi Chhor Divas (Diwali)
Start: 📅 8 Nov 2026
End: 📅 9 Nov 2026

Summary: Mahavira Nirvana (Diwali)
Start: 📅 9 Nov 2026
End: 📅 10 Nov 2026

Summary: Birth of the Bab
Start: 📅 10 Nov 2026
End: 📅 11 Nov 2026

Summary: Birth of Baha'ullah
Start: 📅 11 Nov 2026
End: 📅 12 Nov 2026

Summary: Birth of Guru Nanak Dev Sahib Ji
Start: 📅 24 Nov 2026
End: 📅 25 Nov 2026

Summary: Martyrdom of Guru Tegh Bahadur Ji
Start: 📅 24 Nov 2026
End: 📅 25 Nov 2026

Summary: Day of the Covenant
Start: 📅 26 Nov 2026
End: 📅 27 Nov 2026

Summary: Ascension of Abdu’l‑Baha
Start: 📅 28 Nov 2026
End: 📅 29 Nov 2026

Summary: Advent
Start: 📅 29 Nov 2026
End: 📅 25 Dec 2026

Summary: Hanukkah
Start: 📅 5 Dec 2026
End: 📅 13 Dec 2026

Summary: Bodhi Day
Start: 📅 8 Dec 2026
End: 📅 9 Dec 2026

Summary: Christmas
Start: 📅 25 Dec 2026
End: 📅 26 Dec 2026

'''
    }

    def 'test calendar view with location rendering'() {
        given: 'a calendar'
//        def parser = CalendarParserFactory.instance.get()
//        def calendar = null
//        parser.parse(new UnfoldingReader(getClass().getResource('/samples/afl-2026-essendon-AUSEasternStandardTime.ics').newReader()),
//                new ExtendedContentHandler((c) -> calendar = c, TimeZoneRegistryFactory.getInstance().createRegistry()))
        def calendar = Calendars.load(getClass().getResource('/samples/afl-2026-essendon-AUSEasternStandardTime.ics'))

        and: 'a calendar view'
        def calendarView = new CalendarView(calendar)

        expect: 'the output is as expected'
        calendarView.toString() == '''Events:
Summary: Essendon vs Hawthorn - AFL 2026 Round 1
Start: 🕣 13 Mar 2026, 8:40:00 am
End: 🕚 13 Mar 2026, 11:10:00 am
Location: 📍 MCG

Summary: Port Adelaide vs Essendon - AFL 2026 Round 2
Start: 🕟 22 Mar 2026, 4:15:00 am
End: 🕕 22 Mar 2026, 6:45:00 am
Location: 📍 Adelaide Oval

Summary: Essendon vs North Melbourne - AFL 2026 Round 3
Start: 🕣 28 Mar 2026, 8:35:00 am
End: 🕚 28 Mar 2026, 11:05:00 am
Location: 📍 Marvel Stadium

Summary: Western Bulldogs vs Essendon - AFL 2026 Round 4
Start: 🕤 5 Apr 2026, 9:20:00 am
End: 🕚 5 Apr 2026, 11:50:00 am
Location: 📍 Marvel Stadium

Summary: Essendon vs Melbourne - AFL 2026 Round 5
Start: 🕞 11 Apr 2026, 3:15:00 am
End: 🕔 11 Apr 2026, 5:45:00 am
Location: 📍 Adelaide Oval

Summary: Gold Coast SUNS vs Essendon - AFL 2026 Round 6
Start: 🕞 18 Apr 2026, 3:15:00 am
End: 🕔 18 Apr 2026, 5:45:00 am
Location: 📍 People First Stadium

Summary: Essendon vs Collingwood - AFL 2026 Round 7
Start: 🕠 25 Apr 2026, 5:15:00 am
End: 🕖 25 Apr 2026, 7:45:00 am
Location: 📍 MCG

Summary: Essendon vs Brisbane Lions - AFL 2026 Round 8
Start: 🕝 2 May 2026, 2:35:00 am
End: 🕔 2 May 2026, 5:05:00 am
Location: 📍 Marvel Stadium

Summary: GWS GIANTS vs Essendon - AFL 2026 Round 9
Start: 🕡 9 May 2026, 6:15:00 am
End: 🕗 9 May 2026, 8:45:00 am
Location: 📍 ENGIE Stadium

Summary: Essendon vs Fremantle - AFL 2026 Round 10
Start: 🕒 17 May 2026, 3:10:00 am
End: 🕠 17 May 2026, 5:40:00 am
Location: 📍 MCG

Summary: Richmond vs Essendon - AFL 2026 Round 11
Start: 🕤 22 May 2026, 9:40:00 am
End: 🕛 22 May 2026, 12:10:00 pm
Location: 📍 MCG

Summary: West Coast Eagles vs Essendon - AFL 2026 Round 12
Start: 🕤 31 May 2026, 9:20:00 am
End: 🕚 31 May 2026, 11:50:00 am
Location: 📍 Optus Stadium

Summary: Essendon vs Carlton - AFL 2026 Round 13
Start: 🕤 7 June 2026, 9:20:00 am
End: 🕚 7 June 2026, 11:50:00 am
Location: 📍 MCG

Summary: Melbourne vs Essendon - AFL 2026 Round 14
Start: 🕞 13 June 2026, 3:15:00 am
End: 🕔 13 June 2026, 5:45:00 am
Location: 📍 MCG

Summary: North Melbourne vs Essendon - AFL 2026 Round 16
Start: 🕑 27 June 2026, 2:00:00 am
End: 🕟 27 June 2026, 4:30:00 am
Location: 📍 Marvel Stadium

Summary: Essendon vs St Kilda - AFL 2026 Round 17
Start: 🕑 4 July 2026, 2:00:00 am
End: 🕟 4 July 2026, 4:30:00 am
Location: 📍 Marvel Stadium

Summary: Brisbane Lions vs Essendon - AFL 2026 Round 18
Start: 🕑 11 July 2026, 2:00:00 am
End: 🕟 11 July 2026, 4:30:00 am
Location: 📍 Gabba

Summary: Essendon vs GWS GIANTS - AFL 2026 Round 19
Start: 🕑 18 July 2026, 2:00:00 am
End: 🕟 18 July 2026, 4:30:00 am
Location: 📍 Marvel Stadium

Summary: Hawthorn vs Essendon - AFL 2026 Round 20
Start: 🕑 25 July 2026, 2:00:00 am
End: 🕟 25 July 2026, 4:30:00 am
Location: 📍 MCG

Summary: Essendon vs Adelaide Crows - AFL 2026 Round 21
Start: 🕑 1 Aug 2026, 2:00:00 am
End: 🕟 1 Aug 2026, 4:30:00 am
Location: 📍 Marvel Stadium

Summary: Geelong Cats vs Essendon - AFL 2026 Round 22
Start: 🕑 8 Aug 2026, 2:00:00 am
End: 🕟 8 Aug 2026, 4:30:00 am
Location: 📍 GMHBA Stadium

Summary: Essendon vs Sydney Swans - AFL 2026 Round 23
Start: 🕑 15 Aug 2026, 2:00:00 am
End: 🕟 15 Aug 2026, 4:30:00 am
Location: 📍 MCG

Summary: Essendon vs Port Adelaide - AFL 2026 Round 24
Start: 🕑 22 Aug 2026, 2:00:00 am
End: 🕟 22 Aug 2026, 4:30:00 am
Location: 📍 Marvel Stadium

'''
    }

    def 'test calendar view monthly template rendering'() {
        given: 'a calendar'
        def calendar = Calendars.load(getClass().getResource('/samples/2026-multifaith-calendar-Victoria.ics'))

        and: 'a calendar view'
        def calendarView = new CalendarView(calendar)

        and: 'a monthly calendar template'
        def engine = new TemplateEngineFactory().newInstance()
        def month = YearMonth.of(2026, 1)

        expect: 'the output is as expected'
        def output = new StringOutput()
        engine.render('calendar/monthly.jte', [calendar: calendarView, month: month], output)

        output.toString().startsWith('<!doctype html>')
    }

    def 'test calendar view agenda template rendering'() {
        given: 'a calendar'
        def calendar = Calendars.load(getClass().getResource('/samples/2026-multifaith-calendar-Victoria.ics'))

        and: 'a calendar view'
        def calendarView = new CalendarView(calendar)

        and: 'an agenda calendar template'
        def engine = new TemplateEngineFactory().newInstance()
        def month = YearMonth.of(2026, 1)

        expect: 'the output is as expected'
        def output = new StringOutput()
        engine.render('calendar/agenda.jte', [calendar: calendarView, month: month], output)

        output.toString().startsWith('<!doctype html>')
    }

    def 'test calendar view weekly template rendering'() {
        given: 'a calendar'
        def calendar = Calendars.load(getClass().getResource('/samples/2026-multifaith-calendar-Victoria.ics'))

        and: 'a calendar view'
        def calendarView = new CalendarView(calendar)

        and: 'a weekly calendar template'
        def engine = new TemplateEngineFactory().newInstance()
        def month = YearMonth.of(2026, 1)

        expect: 'the output is as expected'
        def output = new StringOutput()
        engine.render('calendar/weekly.jte', [calendar: calendarView, month: month], output)

        output.toString().startsWith('<!doctype html>')
    }
}
