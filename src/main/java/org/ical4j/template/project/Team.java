package org.ical4j.template.project;

import net.fortuna.ical4j.vcard.VCard;
import org.ical4j.template.AbstractTemplate;

/**
 * A group of individuals working together collaboratively to achieve one or more common goals.
 */
public class Team extends AbstractTemplate<VCard> {

    public Team() {
        super(VCard.class);
    }

    public Team(Class<VCard> typeClass) {
        super(typeClass);
    }

    @Override
    public VCard apply(VCard vCard) {
        return vCard;
    }
}
