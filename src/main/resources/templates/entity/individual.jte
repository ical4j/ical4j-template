@import org.ical4j.template.view.EntityView
@import org.ical4j.template.util.EmojiProvider

@param EntityView entity

<h1>${entity.getFormattedNames().get(0)}</h1>
@for(var name : entity.getFormattedNames().subList(1, entity.getFormattedNames().size()))
    <h3>${name}</h3>
@endfor

<p>
    @for(var title : entity.getTitles())
        <strong>Title:</strong> ${EmojiProvider.getEmoji("title")} ${title}<br/>
    @endfor
    @for(var org : entity.getOrganizations())
        <strong>Organization:</strong> ${EmojiProvider.getEmoji("organization")} ${org}<br/>
    @endfor
    @for(var email : entity.getEmails())
        <strong>Email:</strong> <a href="mailto:${email}">${EmojiProvider.getEmoji("email")} ${email}</a><br/>
    @endfor
    @for(var phone : entity.getTelephones())
        <strong>Phone:</strong> <a href="tel:${phone}">${EmojiProvider.getEmoji("phone")} ${phone}</a><br/>
    @endfor
    @for(var url : entity.getUrls())
        <strong>URL:</strong> <a href="${url}">${EmojiProvider.getEmoji("url")} ${url}</a><br/>
    @endfor
</p>
