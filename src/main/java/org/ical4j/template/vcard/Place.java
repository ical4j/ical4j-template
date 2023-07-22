package org.ical4j.template.vcard;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;
import org.ical4j.template.AbstractVCardTemplate;

import java.util.Arrays;

public class Place extends AbstractVCardTemplate {

    public Place(String name) {
        super(new VCard(new PropertyList(Arrays.asList(new Fn(name), ImmutableKind.LOCATION))));
    }
}
