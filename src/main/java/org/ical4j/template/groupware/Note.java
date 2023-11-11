package org.ical4j.template.groupware;

import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Summary;
import org.ical4j.template.AbstractTemplate;

import java.time.LocalDate;

/**
 * A Note is an independent journal item that may or may not refer to one or more other
 * referencable items. A Note may be location-specific in addition to temporal.
 */
public class Note extends AbstractTemplate<VJournal> {

    private String title;

    private LocalDate date;

    private VLocation location;

    public Note() {
        super(VJournal.class);
    }

    public Note(Class<VJournal> typeClass) {
        super(typeClass);
    }

    public Note title(String title) {
        this.title = title;
        return this;
    }

    public Note date(LocalDate date) {
        this.date = date;
        return this;
    }

    public Note location(VLocation location) {
        this.location = location;
        return this;
    }

    @Override
    public VJournal apply(VJournal vJournal) {
        vJournal.replace(new Summary(title));
        vJournal.replace(new DtStart<>(date));
        vJournal.add(location);
        return vJournal;
    }
}
