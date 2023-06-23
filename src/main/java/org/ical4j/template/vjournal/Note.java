package org.ical4j.template.vjournal;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.component.VJournal;
import net.fortuna.ical4j.model.component.VLocation;
import net.fortuna.ical4j.model.property.Geo;
import net.fortuna.ical4j.model.property.Summary;

import java.math.BigDecimal;
import java.util.Collections;

public class Note extends VJournal {

    public Note(String title) {
        add(new Summary(title));
    }

    public Note withLocation(long latitude, long longitude) {
        add(new VLocation(new PropertyList(Collections.singletonList(
                new Geo(BigDecimal.valueOf(latitude), BigDecimal.valueOf(longitude))))));
        return this;
    }
}
