package org.ical4j.template.property;

import net.fortuna.ical4j.model.parameter.FmtType;
import net.fortuna.ical4j.model.parameter.Value;
import net.fortuna.ical4j.model.property.StyledDescription;

public class Html extends StyledDescription {

    public Html(String value) {
        super(value);
        add(Value.TEXT);
        add(new FmtType("text/html"));
    }
}
