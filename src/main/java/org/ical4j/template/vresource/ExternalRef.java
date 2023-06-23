package org.ical4j.template.vresource;

import net.fortuna.ical4j.model.component.VResource;
import net.fortuna.ical4j.model.property.Name;
import net.fortuna.ical4j.model.property.Url;
import net.fortuna.ical4j.vcard.PropertyName;
import net.fortuna.ical4j.vcard.VCard;

import java.net.URI;

public class ExternalRef extends VResource {

    public ExternalRef(String name, URI productDefinitionUri) {
        add(new Name(name));
        add(new Url(productDefinitionUri));
    }

    public ExternalRef(VCard card) {
        add(new Name(card.getRequiredProperty(PropertyName.FN.toString()).getValue()));
        net.fortuna.ical4j.vcard.property.Url url = card.getRequiredProperty(PropertyName.URL.toString());
        add(new Url(url.getUri()));
    }
}
