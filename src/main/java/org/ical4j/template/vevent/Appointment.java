package org.ical4j.template.vevent;

import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Organizer;
import net.fortuna.ical4j.model.property.Summary;
import org.ical4j.template.property.ComponentType;

import java.net.URISyntaxException;
import java.time.ZonedDateTime;

public class Appointment extends VEvent {

    public Appointment(String summary, ZonedDateTime start) {
        add(ComponentType.APPOINTMENT);
        add(new Summary(summary));
        add(new DtStart<>(start));
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
