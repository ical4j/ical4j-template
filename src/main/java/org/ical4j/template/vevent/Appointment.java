package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;
import org.ical4j.template.property.EventType;

import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class Appointment extends AbstractCalendarTemplate<VEvent> {

    public Appointment(String summary, ZonedDateTime start) {
        super(new VEvent(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), EventType.APPOINTMENT, new Summary(summary),
                new DtStart<>(start)))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VEvent>> T getFluentTarget() {
        return (T) this;
    }

    /**
     * Update the organizer for this appointment. Note there can only be ONE organizer so
     * this method will REPLACE any existing ORGANIZER properties.
     * @param organizer an organizer email address
     * @return this appointment instance
     * @throws URISyntaxException if the specified string is not a valid mailto: URI.
     */
//    Appointment withOrganizer(String organizer) throws URISyntaxException {
//        replace(new Organizer(organizer));
//        return this;
//    }
}
