package org.ical4j.template.property;

import net.fortuna.ical4j.model.property.ImmutableProperty;
import net.fortuna.ical4j.model.property.PercentComplete;

public class CompletionStatus extends PercentComplete implements ImmutableProperty {

    public static final CompletionStatus NOT_STARTED = new CompletionStatus(0);
    
    public static final CompletionStatus COMPLETED = new CompletionStatus(100);

    public CompletionStatus(int aPercentage) {
        super(aPercentage);
    }
}
