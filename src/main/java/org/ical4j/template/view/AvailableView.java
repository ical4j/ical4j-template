package org.ical4j.template.view;

import net.fortuna.ical4j.model.Period;
import net.fortuna.ical4j.model.component.Available;

import java.time.ZoneId;
import java.time.temporal.Temporal;

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
public class AvailableView extends AbstractComponentView implements DescriptivePropertyView<Available>,
        DateTimePropertyView<Available>, RecurrenceView<Available, Available> {

    private final Available available;

    private final Temporal periodStart;

    private final Temporal periodEnd;

    private final ZoneId zoneId;

    public AvailableView(Available available) {
        this(available, ZoneId.systemDefault());
    }

    public AvailableView(Available available, ZoneId zoneId) {
        this(available, null, null, zoneId);
    }

    public AvailableView(Available available, Temporal periodStart, Temporal periodEnd) {
        this(available, periodStart, periodEnd, ZoneId.systemDefault());
    }

    public AvailableView(Available available, Temporal periodStart, Temporal periodEnd, ZoneId zoneId) {
        this.available = available;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.zoneId = zoneId;
    }

    @Override
    public Available getPropertyAccessor() {
        return available;
    }

    @Override
    public ZoneId getZoneId() {
        return zoneId;
    }

    @Override
    public Available getRecurrenceSupport() {
        return available;
    }

    @Override
    public Period<Temporal> getPeriod() {
        if (periodStart != null && periodEnd != null) {
            return new Period<>(periodStart, periodEnd);
        }
        return null;
    }

    public String toString() {
        return "Available: " + getSummary() + "\n" +
                "Start: " + getStart() + "\n" +
                "End: " + getEnd() + "\n";
    }

    public static class AvailableViewFactory implements ViewFactory<Available, AvailableView> {

        public static final AvailableViewFactory INSTANCE = new AvailableViewFactory();

        @Override
        public AvailableView createView(Available model) {
            return new AvailableView(model);
        }
    }
}
