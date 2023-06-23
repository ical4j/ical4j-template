package org.ical4j.template.vcard;

import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

public class Organization extends VCard {

    public Organization(String name) {
        add(ImmutableKind.ORG);
        add(new Fn(name));
    }
}
