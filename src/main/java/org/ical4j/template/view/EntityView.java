package org.ical4j.template.view;

import net.fortuna.ical4j.vcard.Entity;
import org.ical4j.template.util.EmojiProvider;

public class EntityView implements CommunicationsPropertyView<Entity>, ExplanatoryPropertyView<Entity>,
    GeneralPropertyView<Entity>, IdentificationPropertyView<Entity>, OrganizationalPropertyView<Entity> {

    private final Entity entity;

    public EntityView(Entity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getPropertyAccessor() {
        return entity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!getKind().isBlank()) {
            sb.append(getKind()).append("\n");
        }
        getFormattedNames().forEach(name -> sb.append(name).append("\n"));
        getTelephones().forEach(tel -> sb.append(EmojiProvider.getEmoji("phone")).append(" ").append(tel).append("\n"));
        getEmails().forEach(email -> sb.append(EmojiProvider.getEmoji("email")).append(" ").append(email).append("\n"));
        getUrls().forEach(url -> sb.append(EmojiProvider.getEmoji("url")).append(" ").append(url).append("\n"));
        getNotes().forEach(note -> sb.append(EmojiProvider.getEmoji("note")).append(" ").append(note).append("\n"));
        getTitles().forEach(title -> sb.append(EmojiProvider.getEmoji("title")).append(" ").append(title).append("\n"));
        getOrganizations().forEach(org -> sb.append(EmojiProvider.getEmoji("organization")).append(" ").append(org).append("\n"));
        return sb.toString();
    }
}
