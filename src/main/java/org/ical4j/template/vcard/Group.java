package org.ical4j.template.vcard;

import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.Member;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

public class Group extends VCard {

    public Group(String name, VCard...members) {
        add(ImmutableKind.GROUP);
        add(new Fn(name));
        for (VCard member : members) {
            add(new Member(member));
        }
    }
}
