package org.ical4j.template.workflow;

import net.fortuna.ical4j.extensions.concept.RequestType;
import net.fortuna.ical4j.model.component.VToDo;
import org.ical4j.template.AbstractTemplate;

public class Request extends AbstractTemplate<VToDo> {

    private RequestType requestType;

    public Request() {
        super(VToDo.class);
    }

    public Request(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Request(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    public Request type(String summary, RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        applyPrototype(vToDo);

        vToDo.replace(requestType);
        return vToDo;
    }
}
