package org.ical4j.template.view;

import net.fortuna.ical4j.model.DateTimePropertyAccessor;
import net.fortuna.ical4j.model.Parameter;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.Due;
import net.fortuna.ical4j.vcard.parameter.Value;
import org.ical4j.template.util.EmojiProvider;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.util.Objects;
import java.util.Optional;

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
/**
 * A view over date-time properties.
 *
 * @param <T> the type of date-time property accessor
 */
public interface DateTimePropertyView<T extends DateTimePropertyAccessor> {

    T getPropertyAccessor();

    ZoneId getZoneId();

    default String getStart() {
        DtStart<?> dtStart = getPropertyAccessor().getDateTimeStart();
        if (Optional.of(Value.DATE).equals(dtStart.getParameter(Parameter.VALUE))) {
            return getLocalizedDateString(Objects.requireNonNull(dtStart).getDate());
        } else {
            return getLocalizedDateTimeString(Objects.requireNonNull(dtStart).getDate(), getZoneId());
        }
    }

    default String getEnd() {
        DtEnd<?> dtEnd = getPropertyAccessor().getDateTimeEnd();
        if (Optional.of(Value.DATE).equals(dtEnd.getParameter(Parameter.VALUE))) {
            return getLocalizedDateString(Objects.requireNonNull(dtEnd).getDate());
        } else {
            return getLocalizedDateTimeString(Objects.requireNonNull(dtEnd).getDate(), getZoneId());
        }
    }

    default String getDue() {
        Due<?> due = getPropertyAccessor().getDateTimeDue();
        if (due != null) {
            return getLocalizedDateTimeString(due.getDate(), getZoneId());
        }
        return "";
    }

    static String getLocalizedDateString(Temporal date) {
        return EmojiProvider.getEmoji(date) + " " +
                DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(date);
    }

    static String getLocalizedDateTimeString(Temporal dateTime, ZoneId zoneId) {
        DateTimeFormatter formatter;
        if (zoneId != null) {
            formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withZone(zoneId);
        } else {
            formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        }
        return EmojiProvider.getEmoji(dateTime) + " " + formatter.format(dateTime);
    }
}
