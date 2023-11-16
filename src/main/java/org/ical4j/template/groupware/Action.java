package org.ical4j.template.groupware;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.Participant;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.Due;
import net.fortuna.ical4j.model.property.RelatedTo;
import net.fortuna.ical4j.model.property.Summary;
import org.ical4j.template.AbstractTemplate;
import org.ical4j.template.ComponentContainerSupport;
import org.ical4j.template.PropertyContainerSupport;

import java.time.temporal.Temporal;

/**
 * This represents an action undertaken by an actor in response to a related component.
 * Typically, actions are chained together to form a workflow.
 *
 * See: <a href="https://schema.org/Action">Action</a>
 */
public class Action extends AbstractTemplate<VToDo> implements PropertyContainerSupport<VToDo>,
        ComponentContainerSupport<Component, VToDo> {

    private Participant participant;

    private Summary summary;

    private RelatedTo context;

    private Due<?> due;

    public Action() {
        super(VToDo.class);
    }

    public Action(Class<VToDo> typeClass) {
        super(typeClass);
    }

    public Action participant(Participant participant) {
        this.participant = participant;
        return this;
    }

    public Action summary(String summary) {
        this.summary = new Summary(summary);
        return this;
    }

    public Action due(Temporal due) {
        this.due = new Due<>(due);
        return this;
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        addIfNotNull(vToDo, participant);
        addIfNotNull(vToDo, summary);
        addIfNotNull(vToDo, context);
        addIfNotNull(vToDo, due);
        return vToDo;
    }
}
