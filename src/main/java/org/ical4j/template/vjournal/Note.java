package org.ical4j.template.vjournal;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Geo;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.ical4j.template.AbstractCalendarTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

/**
 * A Note is an independent journal item that may or may not refer to one or more other
 * referencable items. A Note may be location-specific in addition to temporal.
 */
public class Note extends AbstractCalendarTemplate<VJournal> {

    public Note() {
        super(new VJournal(new PropertyList(Collections.singletonList(new RandomUidGenerator().generateUid()))));
    }

    public Note(String title) {
        super(new VJournal(new PropertyList(Arrays.asList(new RandomUidGenerator().generateUid(),
                new Summary(title)))));
    }

    @Override
    public <T extends AbstractCalendarTemplate<VJournal>> T getFluentTarget() {
        return (T) this;
    }

    public Note date(LocalDate date) {
        getRevisions().getLatestRevision().add(new DtStart<>(date));
        return this;
    }

    public Note withLocation(long latitude, long longitude) {
        getRevisions().getLatestRevision().add(new VLocation(new PropertyList(Collections.singletonList(
                new Geo(BigDecimal.valueOf(latitude), BigDecimal.valueOf(longitude))))));
        return this;
    }
}
