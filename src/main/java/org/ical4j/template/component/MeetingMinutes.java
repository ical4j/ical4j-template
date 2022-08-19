package org.ical4j.template.component;

import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.RelatedTo;
import org.ical4j.template.property.MeetingAttendance;

import java.time.ZonedDateTime;

/**
 * Creates a non-recurring {@link VJournal} representing an event in the past.
 */
public class MeetingMinutes extends VJournal {

    private String title;

    private ZonedDateTime dateTime;

    MeetingMinutes withMeeting(VEvent meeting) {
        add(new RelatedTo(meeting.getRequiredProperty(Property.UID).getValue()));
        return this;
    }

    MeetingMinutes withMeetingAttendance(MeetingAttendance attendance) {
        add(attendance);
        return this;
    }

    MeetingMinutes withAction(VToDo action) {
        add(new RelatedTo(action.getRequiredProperty(Property.UID).getValue()));
        return this;
    }
}
