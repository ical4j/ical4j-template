package org.ical4j.template.util;

import net.fortuna.ical4j.model.TemporalAdapter;

import java.time.temporal.ChronoField;
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
public class EmojiProvider {

    public static String getEmoji(String name) {
        return switch (name.toLowerCase()) {
            case "smile" -> "\uD83D\uDE04"; // Smiling Face 😄
            case "party" -> "\uD83C\uDF89"; // Party Popper 🎉
            case "thumbs_up" -> "\uD83D\uDC4D"; // Thumbs Up 👍
            case "heart" -> "\u2764\uFE0F"; // Heart ❤️
            case "star" -> "\u2B50"; // Star ⭐
            case "fire" -> "\uD83D\uDD25"; // Fire 🔥
            case "sunrise" -> "\uD83C\uDF05"; // Sunrise 🌅
            case "sun" -> "\u2600\uFE0F"; // Sun ☀️
            case "sunset" -> "\uD83C\uDF07"; // Sunset 🌇
            case "moon" -> "\uD83C\uDF19"; // Crescent Moon 🌙
            case "calendar" -> "\uD83D\uDCC5"; // Calendar 📅
            case "duration" -> "\u23F1\uFE0F"; // Stopwatch ⏱️
            case "location" -> "\uD83D\uDCCD"; // Location Pin 📍
            case "image" -> "\uD83D\uDDBC\uFE0F"; // Framed Picture 🖼️
            case "video" -> "\uD83C\uDFA5"; // Movie Camera 🎥
            case "task" -> "\u2705"; // Check Mark ✅
            case "bubbles" -> "\uD83E\uDEE7"; // 🫧

            // action emojis
            case "audio" -> "\uD83D\uDD0A"; // Speaker with Sound Waves 🔊
            case "display" -> "\uD83D\uDDA5\uFE0F"; // Notification Display 🖥️
            case "email" -> "\uD83D\uDCE7"; // E-mail 📧

            case "0", "00", "12" -> "\uD83D\uDD5B"; // 12 o'clock 🕛
            case "1", "01", "13" -> "\uD83D\uDD50"; // 1 o'clock 🕐
            case "2", "02", "14" -> "\uD83D\uDD51"; // 2 o'clock 🕑
            case "3", "03", "15" -> "\uD83D\uDD52"; // 3 o'clock 🕒
            case "4", "04", "16" -> "\uD83D\uDD53"; // 4 o'clock 🕓
            case "5", "05", "17" -> "\uD83D\uDD54"; // 5 o'clock 🕔
            case "6", "06", "18" -> "\uD83D\uDD55"; // 6 o'clock 🕕
            case "7", "07", "19" -> "\uD83D\uDD56"; // 7 o'clock 🕖
            case "8", "08", "20" -> "\uD83D\uDD57"; // 8 o'clock 🕗
            case "9", "09", "21" -> "\uD83D\uDD58"; // 9 o'clock 🕘
            case "10", "22" -> "\uD83D\uDD59"; // 10 o'clock 🕙
            case "11", "23" -> "\uD83D\uDD5A"; // 11 o'clock 🕚

            case "1230" -> "\uD83D\uDD67"; // 12:30 🕧
            case "130" -> "\uD83D\uDD5C"; // 1:30 🕜
            case "230" -> "\uD83D\uDD5D"; // 2:30 🕝
            case "330" -> "\uD83D\uDD5E"; // 3:30 🕞
            case "430" -> "\uD83D\uDD5F"; // 4:30 🕟
            case "530" -> "\uD83D\uDD60"; // 5:30 🕠
            case "630" -> "\uD83D\uDD61"; // 6:30 🕡
            case "730" -> "\uD83D\uDD62"; // 7:30 🕢
            case "830" -> "\uD83D\uDD63"; // 8:30 🕣
            case "930" -> "\uD83D\uDD64"; // 9:30 🕤
            case "1030" -> "\uD83D\uDD65"; // 10:30 🕥
            case "1130" -> "\uD83D\uDD66"; // 11:30 🕦

            // classification emojis
            case "public" -> "\uD83D\uDD13"; // Open Lock 🔓
            case "private" -> "\uD83D\uDD12"; // Closed Lock 🔒
            case "confidential" -> "\uD83D\uDD10"; // Locked with Pen 🔐

            // entity kinds
            case "individual" -> "\uD83D\uDC64"; // Bust in Silhouette 👤
            case "group" -> "\uD83D\uDC65"; // Busts in Silhouette 👥
            case "organization" -> "\uD83C\uDFE2"; // Office Building 🏢
//            case "location" -> "\uD83C\uDFE0"; // House Building 🏠

            // communication types
            case "phone" -> "\uD83D\uDCDE"; // Telephone Receiver 📞
            case "fax" -> "\uD83D\uDCE0"; // Fax Machine 📠
            case "pager" -> "\uD83D\uDCDF"; // Pager 📟
            case "url" -> "\uD83D\uDD17"; // Link 🔗

            default -> "";
        };
    }

    public static String getEmoji(Temporal dateTime) {
        if (TemporalAdapter.isDateTimePrecision(dateTime)) {
            int hour = dateTime.get(ChronoField.HOUR_OF_AMPM);
            int minute = dateTime.get(ChronoField.MINUTE_OF_HOUR);
            if (minute >= 15 && minute <= 44) {
                return getEmoji(hour + "30");
            }
            return getEmoji(hour + "");
        } else {
            return getEmoji("calendar");
        }
    }
}
