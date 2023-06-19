package org.ical4j.template.property;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;
import net.fortuna.ical4j.model.parameter.RelType;
import net.fortuna.ical4j.model.property.RelatedTo;

public class SiblingRef extends RelatedTo {

    public SiblingRef(Component component) {
        super(component.getRequiredProperty(Property.UID).getValue());
        add(RelType.SIBLING);
    }
}
