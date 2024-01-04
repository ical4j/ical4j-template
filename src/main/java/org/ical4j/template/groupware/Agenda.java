package org.ical4j.template.groupware;

import net.fortuna.ical4j.extensions.concept.ActionType;
import net.fortuna.ical4j.extensions.link.Next;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.Uid;
import org.ical4j.template.AbstractTemplate;

import java.net.URI;
import java.time.temporal.Temporal;

import static net.fortuna.ical4j.model.DescriptivePropertyModifiers.DESCRIPTION;
import static net.fortuna.ical4j.model.DescriptivePropertyModifiers.SUMMARY;
import static net.fortuna.ical4j.model.RelationshipPropertyModifiers.*;

/**
 * One or more objectives, typically linked to a Meeting to guide outcomes.
 */
public class Agenda extends AbstractTemplate<VToDo> {

    private Temporal start;

    private Temporal due;

    private URI organizer;

    private Uid uid;

    private String summary;

    private String description;

    private Next nextItem;

    public Agenda() {
        super(VToDo.class);
    }

    public Agenda(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Agenda(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    public Agenda uid(Uid uid) {
        this.uid = uid;
        return this;
    }

    public Agenda summary(String summary) {
        this.summary = summary;
        return this;
    }

    public Agenda nextItem(VToDo item) {
        this.nextItem = new Next(item);
        return this;
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        vToDo.replace(ActionType.AGENDA);
        vToDo.with(SUMMARY, summary);
        vToDo.with(DESCRIPTION, description);
        vToDo.with(ORGANIZER_URI, organizer);
        vToDo.with(UID, uid);
        vToDo.with(LINK, nextItem);

        return vToDo;
    }
}
