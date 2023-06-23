package org.ical4j.template.vjournal;

import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.RelatedTo;
import net.fortuna.ical4j.model.property.Summary;

import java.time.ZonedDateTime;

/**
 * Creates a non-recurring {@link VJournal} representing an event in the past.
 */
public class MeetingMinutes extends VJournal {

    public MeetingMinutes(String title, ZonedDateTime dateTime) {
        add(new Summary(title));
        add(new DtStart<>(dateTime));
    }

    MeetingMinutes withMeeting(VEvent meeting) {
        add(new RelatedTo(meeting.getRequiredProperty(Property.UID).getValue()));
        return this;
    }

//    MeetingMinutes withMeetingAttendance(Attendance attendance) {
//        add(attendance);
//        return this;
//    }

    MeetingMinutes withAction(VToDo action) {
        add(new RelatedTo(action.getRequiredProperty(Property.UID).getValue()));
        return this;
    }
}
