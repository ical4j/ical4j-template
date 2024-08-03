package org.ical4j.template.groupware;

import net.fortuna.ical4j.vcard.GeneralPropertyModifiers;
import net.fortuna.ical4j.vcard.IdentificationPropertyModifiers;
import net.fortuna.ical4j.vcard.OrganizationalPropertyModifiers;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.Member;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;
import org.ical4j.template.AbstractTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team extends AbstractTemplate<VCard> {

    private final List<String> names = new ArrayList<>();

    private final List<URI> members = new ArrayList<>();

    public Team() {
        super(VCard.class);
    }

    public <T extends VCard> Team(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    public Team name(String...name) {
        names.addAll(Arrays.asList(name));
        return this;
    }

    public Team member(URI...member) {
        members.addAll(Arrays.asList(member));
        return this;
    }

    @Override
    public VCard apply(VCard vCard) {
        applyPrototype(vCard);

        vCard.with(GeneralPropertyModifiers.KIND, ImmutableKind.GROUP);
        names.forEach(name -> vCard.with(IdentificationPropertyModifiers.FN, new Fn(name)));
        members.forEach(member -> vCard.with(OrganizationalPropertyModifiers.MEMBER, new Member(member)));
        return vCard;
    }
}
