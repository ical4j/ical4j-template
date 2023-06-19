package org.ical4j.template.property;

import net.fortuna.ical4j.model.property.Comment;
import net.fortuna.ical4j.model.property.ImmutableProperty;

public class Annotation extends Comment implements ImmutableProperty {

    public static final Annotation REQUIRES_CLASSIFICATION = new Annotation("Must be classified");

    public Annotation(String text) {
        super(text);
    }
}
