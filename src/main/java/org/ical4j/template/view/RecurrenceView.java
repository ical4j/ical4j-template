package org.ical4j.template.view;

import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Period;
import net.fortuna.ical4j.model.RecurrenceSupport;

import java.time.temporal.Temporal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
public interface RecurrenceView<T extends Component, R extends RecurrenceSupport<T>> {

    R getRecurrenceSupport();

    Period<Temporal> getPeriod();

    default <E> List<String> getOccurrences(ViewFactory<T, E> viewFactory) {
        Period<Temporal> period = getPeriod();
        if (period != null) {
            List<T> occurrences = getRecurrenceSupport().getOccurrences(getPeriod());
            return occurrences.stream().map(o -> viewFactory.createView(o).toString()).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    default <E extends DateTimePropertyView<?>> List<String> getOccurrencesStart(ViewFactory<T, E> viewFactory) {
        Period<Temporal> period = getPeriod();
        if (period != null) {
            List<T> occurrences = getRecurrenceSupport().getOccurrences(getPeriod());
            return occurrences.stream().map(o -> viewFactory.createView(o).getStart()).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

}
