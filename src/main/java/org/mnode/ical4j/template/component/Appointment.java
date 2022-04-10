package org.mnode.ical4j.template.component;

import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.Organizer;

import java.net.URISyntaxException;

public class Appointment extends VEvent {

    /**
     * Update the organizer for this appointment. Note there can only be ONE organizer so
     * this method will REPLACE any existing ORGANIZER properties.
     * @param organizer an organizer email address
     * @return this appointment instance
     * @throws URISyntaxException if the specified string is not a valid mailto: URI.
     */
    Appointment withOrganizer(String organizer) throws URISyntaxException {
        replace(new Organizer(organizer));
        return this;
    }
}
