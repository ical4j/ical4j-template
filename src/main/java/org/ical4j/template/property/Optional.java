package org.ical4j.template.property;

import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.CalAdrUri;

import java.net.URI;

public class Optional extends Attendee {

    public Optional(URI aUri) {
        super(aUri);
        add(Role.OPT_PARTICIPANT);
    }

    public Optional(VCard card) {
        add(Role.OPT_PARTICIPANT);
        CalAdrUri uri = card.getRequiredProperty(PropertyName.CALADRURI.toString());
        setCalAddress(uri.getUri());
    }

    public Optional(Participant participant) {
        super(participant);
        add(Role.OPT_PARTICIPANT);
    }
}
