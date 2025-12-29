package org.ical4j.template.view;

import net.fortuna.ical4j.model.component.VAvailability;

import java.time.ZoneId;
import java.util.List;

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
 * A view providing access to a VAvailability component.
 */
public class VAvailabilityView implements DescriptivePropertyView<VAvailability>,
    DateTimePropertyView<VAvailability> {

    private final VAvailability availability;

    private final ZoneId zoneId;

    public VAvailabilityView(VAvailability availability) {
        this(availability, ZoneId.systemDefault());
    }

    public VAvailabilityView(VAvailability availability, ZoneId zoneId) {
        this.availability = availability;
        this.zoneId = zoneId;
    }

    @Override
    public ZoneId getZoneId() {
        return zoneId;
    }

    @Override
    public VAvailability getPropertyAccessor() {
        return availability;
    }

    public List<AvailableView> getAvailablePeriods() {
        return availability.getAvailable().stream().map(AvailableView::new).toList();
    }

    @Override
    public String toString() {
        return "Summary: " + getSummary() + "\n" +
               "Start: " + getStart() + "\n" +
               "End: " + getEnd() + "\n" +
               "Available Periods: " + getAvailablePeriods().stream().map(AvailableView::toString).toList();
    }
}
