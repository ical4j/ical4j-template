package org.ical4j.template.property;

import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.parameter.Role;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.vcard.VCard;
import org.ical4j.template.participant.InactiveRole;

import java.net.URI;

public class Optional extends Attendee {

    public Optional(URI aUri) {
        super(aUri);
        add(Role.OPT_PARTICIPANT);
    }

    public Optional(VCard card) {
        super(new InactiveRole(card));
        add(Role.OPT_PARTICIPANT);
    }

    public Optional(Participant participant) {
        super(participant);
        add(Role.OPT_PARTICIPANT);
    }
}
