package org.ical4j.template.workflow;

import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.Member;
import org.ical4j.template.AbstractTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * A workspace represents a collaborative space for one or more members. A member can be an individual or
 * a group.
 */
public class Workspace extends AbstractTemplate<VCard> {

    private String title;

    private List<VCard> members = new ArrayList<>();

    public Workspace() {
        super(VCard.class);
    }

    public Workspace(Class<VCard> typeClass) {
        super(typeClass);
    }

    public Workspace title(String title) {
        this.title = title;
        return this;
    }

    public Workspace member(VCard member) {
        members.add(member);
        return this;
    }

    @Override
    public VCard apply(VCard vCard) {
        vCard.replace(new Fn(title));
        members.forEach(m -> vCard.add(new Member(m)));
        return vCard;
    }
}
