module ical4j.template {
    requires java.base;
    requires ical4j.core;
    requires ical4j.vcard;
    requires ical4j.extensions;

    exports org.ical4j.template;
    exports org.ical4j.template.agile;
    exports org.ical4j.template.groupware;
    exports org.ical4j.template.project;
    exports org.ical4j.template.wiki;
    exports org.ical4j.template.workflow;
}
