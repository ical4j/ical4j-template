package org.mnode.ical4j.template.component;

import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.property.RelatedTo;
import org.mnode.ical4j.template.property.MeetingAttendance;

import java.time.ZonedDateTime;

/**
 * Creates a non-recurring {@link VJournal} representing an event in the past.
 */
public class MeetingMinutes extends VJournal {

    private String title;

    private ZonedDateTime dateTime;

    MeetingMinutes withMeeting(Meeting meeting) {
        add(new RelatedTo(meeting.getRequiredProperty(Property.UID).getValue()));
        return this;
    }

    MeetingMinutes withMeetingAttendance(MeetingAttendance attendance) {
        return this;
    }

    MeetingMinutes withAction(Task action) {
        add(new RelatedTo(action.getRequiredProperty(Property.UID).getValue()));
        return this;
    }
}
