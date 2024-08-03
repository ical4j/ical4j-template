package org.ical4j.template;

import java.lang.reflect.InvocationTargetException;
import java.util.function.UnaryOperator;

/**
 * A template encapsulates rules for creating and modifying complex iCalendar and
 * vCard objects.
 *
 * @param <T> the applicable object type
 */
public interface Template<T> extends UnaryOperator<T> {

    /**
     * Apply the template to a new object instance. The use of this method requires
     * that the applicable object type contains a default noargs constructor that
     * can be used to create a new object instance.
     * @return a new object instance resulting from applying the template
     * @throws NoSuchMethodException if a noargs constructor doesn't exist on the applicable object type
     * @throws InvocationTargetException an error resulting from invoking the noargs constructor
     * @throws InstantiationException an error resulting from invoking the noargs constructor
     * @throws IllegalAccessException an error resulting from invoking the noargs constructor
     */
    T apply() throws NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException;
}
