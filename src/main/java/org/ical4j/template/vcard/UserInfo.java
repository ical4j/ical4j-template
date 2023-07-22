package org.ical4j.template.vcard;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;
import org.ical4j.template.AbstractVCardTemplate;

import java.util.Arrays;

public class UserInfo extends AbstractVCardTemplate {

    public UserInfo(String name) {
        super(new VCard(new PropertyList(Arrays.asList(new Fn(name), ImmutableKind.INDIVIDUAL))));
    }

    public UserInfo tags() {
        return this;
    }

    public UserInfo directReports() {
        return this;
    }
}
