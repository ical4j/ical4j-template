package org.ical4j.template.vcard;

import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

public class Place extends VCard {

    public Place(String name) {
        add(ImmutableKind.LOCATION);
        add(new Fn(name));
    }
}
