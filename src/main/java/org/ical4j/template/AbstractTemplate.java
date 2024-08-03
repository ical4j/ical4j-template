package org.ical4j.template;

import java.lang.reflect.InvocationTargetException;

/**
 * Base class for templates with support for a prototype instance. A prototype is an
 * instance of the applicable object type used to construct a new instance or modify
 * an existing instance prior to applying the template.
 *
 * @param <T> the applicable object type
 */
public abstract class AbstractTemplate<T> implements Template<T> {

    private final Class<? extends T> typeClass;

    private T prototype;

    public AbstractTemplate(Class<? extends T> typeClass) {
        this.typeClass = typeClass;
    }

    public T getPrototype() {
        return prototype;
    }

    public void setPrototype(T prototype) {
        this.prototype = prototype;
    }

    public T apply() throws NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException {

        return apply(typeClass.getDeclaredConstructor().newInstance());
    }
}
