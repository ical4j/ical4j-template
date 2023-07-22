package org.ical4j.template;

import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.VCardGroup;
import net.fortuna.ical4j.vcard.VCardList;
import net.fortuna.ical4j.vcard.property.Uid;

import java.util.Collections;

public abstract class AbstractVCardTemplate {

    private final VCardGroup revisions;

    public AbstractVCardTemplate(VCard initialValue) {
        Uid uid = initialValue.getRequiredProperty(PropertyName.UID.toString());
        this.revisions = new VCardGroup(uid, new VCardList(Collections.singletonList(initialValue)));
    }

    public VCardGroup getRevisions() {
        return revisions;
    }

    @Override
    public String toString() {
        return revisions.toString();
    }
}
