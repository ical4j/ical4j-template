package org.ical4j.template.vcard;

import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.Note;
import net.fortuna.ical4j.vcard.property.Related;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;
import org.ical4j.template.AbstractVCardTemplate;

import java.util.Arrays;

/**
 * This class provides support for grouping related card entities as well as hierarchical
 * relationships.
 */
public class Group extends AbstractVCardTemplate {

    public Group(String name, VCard...members) {
        super(new VCard(new PropertyList(Arrays.asList(new Fn(name), ImmutableKind.GROUP))));
//        for (VCard member : members) {
//            add(new Member(member));
//        }
    }

    public Group description(String description) {
        getRevisions().getLatestRevision().add(new Note(description));
        return this;
    }

    public Group related(Related group) {
        getRevisions().getLatestRevision().add(group);
        return this;
    }
}
