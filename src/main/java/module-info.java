module ical4j.template {
    requires java.base;
    requires ical4j.core;
    requires ical4j.vcard;
    requires gg.jte.runtime;
    requires gg.jte;
    requires org.slf4j;

    exports org.ical4j.template;
}