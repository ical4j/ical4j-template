package org.ical4j.template.groupware;

import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VJournal;
import org.ical4j.template.AbstractTemplate;

import java.time.temporal.Temporal;
import java.util.function.BiFunction;

import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTEND;
import static net.fortuna.ical4j.model.DateTimePropertyModifiers.DTSTART;
import static net.fortuna.ical4j.model.RelationshipPropertyModifiers.RELATED_COMPONENT;

public class Attendance extends AbstractTemplate<VJournal> {

    private Participant participant;

    private VEvent context;

    private Temporal start;

    private Temporal end;

    public Attendance() {
        super(VJournal.class);
    }

    public Attendance(Class<? extends VJournal> typeClass) {
        super(typeClass);
    }

    public <T extends VJournal> Attendance(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    public Attendance participant(Participant participant) {
        this.participant = participant;
        return this;
    }

    public Attendance context(VEvent context) {
        this.context = context;
        return this;
    }

    public Attendance start(Temporal start) {
        this.start = start;
        return this;
    }

    public Attendance end(Temporal end) {
        this.end = end;
        return this;
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        vJournal.with(DTSTART, start);
        vJournal.with(DTEND, end);
        vJournal.with(RELATED_COMPONENT, context);
        vJournal.with((BiFunction<VJournal, Participant, VJournal>) (c, p) -> { if (p != null) c.add(p); return c;},
                participant);

        return vJournal;
    }
}
