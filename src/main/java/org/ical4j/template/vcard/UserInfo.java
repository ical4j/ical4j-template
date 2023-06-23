package org.ical4j.template.vcard;

import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

public class UserInfo extends VCard {

    public UserInfo(String name) {
        add(ImmutableKind.INDIVIDUAL);
        add(new Fn(name));
    }
}
