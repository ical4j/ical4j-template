module ical4j.template {
    requires java.base;
    requires ical4j.core;
    requires ical4j.vcard;
    requires ical4j.extensions;
    requires gg.jte.runtime;
    requires gg.jte;
    requires ical4j.connector.api;
    requires org.slf4j;

    exports org.ical4j.template;
}