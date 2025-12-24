package org.ical4j.template.view;

import net.fortuna.ical4j.vcard.Entity;
import net.fortuna.ical4j.vcard.property.Fn;
import org.ical4j.template.util.EmojiProvider;

import java.util.List;

public class EntityView {

    private final Entity entity;

    public EntityView(Entity entity) {
        this.entity = entity;
    }

    public String getKind() {
        if (entity.getKind() == null) {
            return "";
        }
        return EmojiProvider.getEmoji(entity.getKind().getValue()) + " " + entity.getKind().getValue();
    }

    public List<String> getFormattedNames() {
        return entity.getFormattedNames().stream().map(Fn::getValue).toList();
    }

    public List<String> getTelephones() {
        return entity.getTelephones().stream()
                .map(tel -> EmojiProvider.getEmoji("phone") + " " + tel.getValue())
                .toList();
    }

    public List<String> getEmails() {
        return entity.getEmails().stream()
                .map(email -> EmojiProvider.getEmoji("email") + " " + email.getValue())
                .toList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!getKind().isBlank()) {
            sb.append(getKind()).append("\n");
        }
        getFormattedNames().forEach(name -> sb.append(name).append("\n"));
        getTelephones().forEach(tel -> sb.append(tel).append("\n"));
        getEmails().forEach(email -> sb.append(email).append("\n"));
        return sb.toString();
    }
}
