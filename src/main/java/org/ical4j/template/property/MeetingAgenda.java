package org.ical4j.template.property;

import net.fortuna.ical4j.model.Content;
import net.fortuna.ical4j.model.ParameterList;
import net.fortuna.ical4j.model.PropertyFactory;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.StructuredData;
import net.fortuna.ical4j.model.property.StyledDescription;

import java.net.URISyntaxException;

/**
 * A JSON representation of a meeting agenda. This may also be used to derive a STYLED-DESCRIPTION and
 * DESCRIPTION property.
 */
public class MeetingAgenda extends StructuredData {

    public DescriptionFactory newDescriptionFactory() {
        return new DescriptionFactory();
    }

    public StyledDescriptionFactory newStyledDescriptionFactory() {
        return new StyledDescriptionFactory();
    }

    public class DescriptionFactory extends Content.Factory implements PropertyFactory<Description> {

        public DescriptionFactory() {
            super(DESCRIPTION);
        }

        @Override
        public Description createProperty(final ParameterList parameters, final String value) {
            return new Description(parameters, value);
        }

        @Override
        public Description createProperty() {
            return new Description();
        }
    }

    public class StyledDescriptionFactory extends Content.Factory implements PropertyFactory<StyledDescription> {

        public StyledDescriptionFactory() {
            super(STYLED_DESCRIPTION);
        }

        @Override
        public StyledDescription createProperty(final ParameterList parameters, final String value) throws URISyntaxException {
            return new StyledDescription(parameters, value);
        }

        @Override
        public StyledDescription createProperty() {
            return new StyledDescription();
        }
    }
}
