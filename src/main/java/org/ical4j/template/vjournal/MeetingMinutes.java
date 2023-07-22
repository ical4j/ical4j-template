package org.ical4j.template.vjournal;

import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.RelatedTo;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;

import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * Creates a non-recurring {@link VJournal} representing an event in the past.
 */
public class MeetingMinutes extends AbstractCalendarTemplate<VJournal> {

    public MeetingMinutes(String title, ZonedDateTime dateTime) {
        super(new VJournal(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new DtStamp(), new Summary(title), new DtStart<>(dateTime)))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VJournal>> T getFluentTarget() {
        return (T) this;
    }

    MeetingMinutes withMeeting(VEvent meeting) {
        getRevisions().getLatestRevision().add(new RelatedTo(meeting.getRequiredProperty(Property.UID).getValue()));
        return this;
    }

//    MeetingMinutes withMeetingAttendance(Attendance attendance) {
//        add(attendance);
//        return this;
//    }

    MeetingMinutes withAction(VToDo action) {
        getRevisions().getLatestRevision().add(new RelatedTo(action.getRequiredProperty(Property.UID).getValue()));
        return this;
    }
}
