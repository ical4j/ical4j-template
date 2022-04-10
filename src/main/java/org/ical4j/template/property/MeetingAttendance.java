package org.ical4j.template.property;

import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.StructuredData;

/**
 * Meeting attendance summary, including attendees (time joined/left?), meeting reference, etc.
 */
public class MeetingAttendance extends StructuredData {

    MeetingAttendance withAttendee(Attendee attendee) {
        //XXX: populate
        return this;
    }
}
