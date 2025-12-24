package org.ical4j.template.view;

import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.parameter.LinkRel;
import net.fortuna.ical4j.model.property.*;
import org.ical4j.template.util.EmojiProvider;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.util.Objects;

/*
 * Copyright (c) 2025, Ben Fortuna
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  o Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 *  o Neither the name of Ben Fortuna nor the names of any other contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
public class AbstractComponentView {

    protected String getLocalizedDateString(Temporal date) {
        return EmojiProvider.getEmoji(date) + " " +
                DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(date);
    }

    protected String getLocalizedDateTimeString(Temporal dateTime, ZoneId zoneId) {
        DateTimeFormatter formatter;
        if (zoneId != null) {
            formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withZone(zoneId);
        } else {
            formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        }
        return EmojiProvider.getEmoji(dateTime) + " " + formatter.format(dateTime);
    }

    protected String getSafeString(String value) {
        return Objects.requireNonNullElse(value, "");
    }

    protected String getConceptString(Concept concept) {
        return concept != null ? EmojiProvider.getEmoji(concept.getValue()) + " " + concept.getValue() : "";
    }

    protected String getLinkString(Link link) {
        if (link != null) {
            LinkRel linkRelation = link.getRequiredParameter(Parameter.RELTYPE);
            return EmojiProvider.getEmoji(linkRelation.getLinkRelationType().toString()) + " " + link.getValue();
        }
        return "";
    }

    protected String getStatusString(Status status) {
        return status != null ? EmojiProvider.getEmoji(status.getValue()) + " " + status.getValue() : "";
    }

    protected String getPriorityString(Priority priority) {
        if (priority == null) {
            return "⚪ None";
        }
        int value = priority.getLevel();
        if (value >= 1 && value <= 3) {
            return "🔴 High";
        } else if (value >= 4 && value <= 6) {
            return "🟡 Medium";
        } else if (value >= 7 && value <= 9) {
            return "🟢 Low";
        } else {
            return "⚪ None";
        }
    }

    protected String getPercentCompleteString(PercentComplete percentComplete) {
        if (percentComplete != null) {
            int value = percentComplete.getPercentage();
            if (value >= 0 && value <= 100) {
                return "📊 " + percentComplete + "%";
            }
        }
        return "📊 N/A";
    }

    protected String getClassificationString(Clazz classification) {
        return classification != null ? EmojiProvider.getEmoji(classification.getValue()) + " "
                + classification.getValue() : "";
    }
}
