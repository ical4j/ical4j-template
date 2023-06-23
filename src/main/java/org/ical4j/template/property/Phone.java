package org.ical4j.template.property;

import net.fortuna.ical4j.model.parameter.Feature;
import net.fortuna.ical4j.model.property.Conference;

public class Phone extends Conference {

    public Phone(String value) {
        super(value);
        add(Feature.PHONE);
    }
}
