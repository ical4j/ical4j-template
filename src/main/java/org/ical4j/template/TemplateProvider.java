package org.ical4j.template;

import net.fortuna.ical4j.model.ComponentFactory;
import net.fortuna.ical4j.model.component.CalendarComponent;

import java.util.function.Supplier;

/**
 * Implementors provide a component factory that can be used to create new instances of a template.
 */
public interface TemplateProvider<T extends CalendarComponent> extends Supplier<ComponentFactory<T>> {

    String getName();

    String getDescription();
}
