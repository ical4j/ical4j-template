package org.ical4j.template.property;

import net.fortuna.ical4j.model.parameter.FmtType;
import net.fortuna.ical4j.model.parameter.Schema;
import net.fortuna.ical4j.model.property.StructuredData;

/**
 * A type defined by Schema.org.
 */
public class SchemaType extends StructuredData {

    public SchemaType(String type, String value) {
        add(new FmtType("application/ld+json"));
        add(new Schema("https://schema.org/" + type));
        setValue(value);
    }
}
