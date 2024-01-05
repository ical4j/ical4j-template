package org.ical4j.template;

import net.fortuna.ical4j.extensions.concept.ActionType;
import net.fortuna.ical4j.extensions.concept.EventType;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.Concept;
import org.ical4j.template.groupware.Action;
import org.ical4j.template.groupware.Meeting;

import java.util.function.UnaryOperator;

public class TemplateFactory {

    @SuppressWarnings("unchecked")
    public <T> UnaryOperator<T> newInstance(Concept concept) {
        if (EventType.MEETING.equals(concept)) {
            return (UnaryOperator<T>) new Meeting();
        } else if (ActionType.ACTION.equals(concept)) {
            return (UnaryOperator<T>) new Action();
//        } else if (ActionType.AGENDA.equals(concept)) {
//            return (UnaryOperator<T>) new Agenda();
        }
        throw new IllegalArgumentException("Unknown concept");
    }

    @SuppressWarnings("unchecked")
    public <T> UnaryOperator<T> newInstance(Concept concept, T prototype) {
        if (EventType.MEETING.equals(concept)) {
            return (UnaryOperator<T>) new Meeting((VEvent) prototype);
        } else if (ActionType.ACTION.equals(concept)) {
            return (UnaryOperator<T>) new Action((VToDo) prototype);
//        } else if (ActionType.AGENDA.equals(concept)) {
//            return (UnaryOperator<T>) new Agenda();
        }
        throw new IllegalArgumentException("Unknown concept");
    }
}
