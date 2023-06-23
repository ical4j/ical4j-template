package org.ical4j.template.vcard;

import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

public class ResourceDefinition extends VCard {

    public ResourceDefinition(String name) {
        add(ImmutableKind.THING);
        add(new Fn(name));
    }
}
