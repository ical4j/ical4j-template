package org.ical4j.template.groupware;

import net.fortuna.ical4j.vcard.GeneralPropertyModifiers;
import net.fortuna.ical4j.vcard.IdentificationPropertyModifiers;
import net.fortuna.ical4j.vcard.VCard;
import net.fortuna.ical4j.vcard.property.N;
import net.fortuna.ical4j.vcard.property.immutable.ImmutableKind;
import org.ical4j.template.AbstractTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Individual extends AbstractTemplate<VCard> {

    private String familyName;

    private String givenName;

    private final List<String> additionalNames = new ArrayList<>();

    private final List<String> prefixes = new ArrayList<>();

    private final List<String> suffixes = new ArrayList<>();

    public Individual() {
        super(VCard.class);
    }

    public <T extends VCard> Individual(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    public Individual familyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public Individual givenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    public Individual additionalName(String... additionalName) {
        this.additionalNames.addAll(Arrays.asList(additionalName));
        return this;
    }

    public Individual prefix(String... prefix) {
        this.prefixes.addAll(Arrays.asList(prefix));
        return this;
    }

    public Individual suffix(String... suffix) {
        this.suffixes.addAll(Arrays.asList(suffix));
        return this;
    }

    @Override
    public VCard apply(VCard vCard) {
        applyPrototype(vCard);

        vCard.with(GeneralPropertyModifiers.KIND, ImmutableKind.INDIVIDUAL);
        vCard.with(IdentificationPropertyModifiers.N, new N(familyName, givenName,
                additionalNames.toArray(new String[0]), prefixes.toArray(new String[0]),
                suffixes.toArray(new String[0])));
        return vCard;
    }
}
