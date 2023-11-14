package org.ical4j.template.groupware;

import net.fortuna.ical4j.extensions.concept.ActionType;
import net.fortuna.ical4j.extensions.link.Next;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.*;
import org.ical4j.template.AbstractTemplate;
import org.ical4j.template.ComponentContainerSupport;
import org.ical4j.template.PropertyContainerSupport;

/**
 * One or more objectives, typically linked to a Meeting to guide outcomes.
 */
public class Agenda extends AbstractTemplate<VToDo> implements PropertyContainerSupport<VToDo>,
        ComponentContainerSupport<Component, VToDo> {

    private DtStart<?> start;

    private Due<?> due;

    private Organizer organizer;

    private Uid uid;

    private Summary summary;

    private Description description;

    private Next nextItem;

    public Agenda() {
        super(VToDo.class);
    }

    public Agenda(Class<VToDo> typeClass) {
        super(typeClass);
    }

    public Agenda uid(String uid) {
        this.uid = new Uid(uid);
        return this;
    }

    public Agenda summary(String summary) {
        this.summary = new Summary(summary);
        return this;
    }

    public Agenda nextItem(VToDo item) {
        this.nextItem = new Next(item);
        return this;
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        vToDo.replace(ActionType.ACTION);
        replaceIfNotNull(vToDo, summary);
        replaceIfNotNull(vToDo, uid);
        replaceIfNotNull(vToDo, organizer);
        replaceIfNotNull(vToDo, description);
        replaceIfNotNull(vToDo, nextItem);
        return vToDo;
    }
}
