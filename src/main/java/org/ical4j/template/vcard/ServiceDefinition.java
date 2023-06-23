package org.ical4j.template.vcard;

import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;

/**
 * A service definition.
 */
public class ServiceDefinition extends VCard {

    public ServiceDefinition(String name) {
        add(ImmutableKind.THING);
        add(new Fn(name));
    }
}
