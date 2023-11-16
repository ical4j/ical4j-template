package org.ical4j.template.groupware;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.RelatedTo;
import org.ical4j.template.AbstractTemplate;
import org.ical4j.template.ComponentContainerSupport;
import org.ical4j.template.PropertyContainerSupport;

import java.time.temporal.Temporal;

public class Attendance extends AbstractTemplate<VJournal> implements PropertyContainerSupport<VJournal>,
        ComponentContainerSupport<Component, VJournal> {

    private Participant participant;

    private RelatedTo context;

    private DtStart<?> start;

    private DtEnd<?> end;

    public Attendance() {
        super(VJournal.class);
    }

    public Attendance(Class<VJournal> typeClass) {
        super(typeClass);
    }

    public Attendance participant(Participant participant) {
        this.participant = participant;
        return this;
    }

    public Attendance context(VEvent context) {
        this.context = new RelatedTo(context);
        return this;
    }

    public Attendance start(Temporal start) {
        this.start = new DtStart<>(start);
        return this;
    }

    public Attendance end(Temporal end) {
        this.end = new DtEnd<>(end);
        return this;
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        replaceIfNotNull(vJournal, start);
        replaceIfNotNull(vJournal, end);
        replaceIfNotNull(vJournal, participant);
        replaceIfNotNull(vJournal, context);
        return vJournal;
    }
}
