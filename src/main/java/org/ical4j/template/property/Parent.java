package org.ical4j.template.property;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.parameter.RelType;
import net.fortuna.ical4j.model.property.RelatedTo;

public class Parent extends RelatedTo {

    public Parent(Component component) {
        super(component);
        add(RelType.PARENT);
    }
}
