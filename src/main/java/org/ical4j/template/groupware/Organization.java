package org.ical4j.template.groupware;

import net.fortuna.ical4j.vcard.GeneralPropertyModifiers;
import net.fortuna.ical4j.vcard.IdentificationPropertyModifiers;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.Fn;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;
import org.ical4j.template.AbstractTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Organization extends AbstractTemplate<VCard> {

    private final List<String> names = new ArrayList<>();

    public Organization() {
        super(VCard.class);
    }

    public <T extends VCard> Organization(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    public Organization name(String...name) {
        names.addAll(Arrays.asList(name));
        return this;
    }

    @Override
    public VCard apply(VCard vCard) {
        vCard.with(GeneralPropertyModifiers.KIND, ImmutableKind.ORG);
        names.forEach(name -> vCard.with(IdentificationPropertyModifiers.FN, new Fn(name)));
        return vCard;
    }
}
