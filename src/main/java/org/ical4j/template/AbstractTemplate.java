package org.ical4j.template;

import java.lang.reflect.InvocationTargetException;
import java.util.function.UnaryOperator;

/**
 * Base class for templates with the added ability to construct new object instances.
 *
 * @param <T>
 */
public abstract class AbstractTemplate<T> implements UnaryOperator<T> {

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
