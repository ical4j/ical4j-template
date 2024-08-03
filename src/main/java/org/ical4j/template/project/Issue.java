package org.ical4j.template.project;

import net.fortuna.ical4j.extensions.concept.IssueType;
import net.fortuna.ical4j.model.component.VToDo;
import net.fortuna.ical4j.model.property.RelatedTo;
import org.ical4j.template.AbstractTemplate;

/**
 * A workflow component representing a problem ticket requiring resolution. This may be used to
 * track incidents, change requests, impediments, etc.
 */
public class Issue extends AbstractTemplate<VToDo> {

    private IssueType issueType;

//    private IssueStatus status;

    private RelatedTo parent;

    public Issue() {
        super(VToDo.class);
    }

    public Issue(Class<? extends VToDo> typeClass) {
        super(typeClass);
    }

    public <T extends VToDo> Issue(T prototype) {
        super(prototype.getClass());
        setPrototype(prototype);
    }

    public Issue issueType(IssueType issueType) {
        this.issueType = issueType;
        return this;
    }

//    public Issue status(IssueStatus status) {
//        this.status = status;
//        return this;
//    }

    public Issue parent(RelatedTo parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public VToDo apply(VToDo vToDo) {
        applyPrototype(vToDo);

        vToDo.replace(issueType);
//        vToDo.replace(status);
        vToDo.replace(parent);
        return vToDo;
    }
}
