@import org.ical4j.template.view.CalendarView
@import java.time.YearMonth
@import java.time.format.DateTimeFormatter
@import org.ical4j.template.util.DateUtils
@import org.ical4j.template.util.CssUtils
@import java.util.Base64

@param CalendarView calendar
@param YearMonth month = java.time.YearMonth.now()
<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="data:text/css;base64,${Base64.getEncoder().encodeToString(CssUtils.getCalendarCss())}" type="text/css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${calendar.getName()}</title>
</head>
<body>

<div class="block p-6 bg-white border border-gray-200 rounded-lg shadow-sm dark:bg-gray-800 dark:border-gray-700">

    <ol class="relative border-s border-default">
        @for(var event : calendar.getEvents(DateUtils.getPeriod(month.getYear(), month.getMonth())))
        <li class="mb-10 ms-6">
            <span class="absolute flex items-center justify-center w-6 h-6 bg-brand-softer rounded-full -start-3 ring-8 ring-buffer">
                <svg class="w-3 h-3 text-fg-brand-strong" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24"><path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 10h16m-8-3V4M7 7V4m10 3V4M5 20h14a1 1 0 0 0 1-1V7a1 1 0 0 0-1-1H5a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1Zm3-7h.01v.01H8V13Zm4 0h.01v.01H12V13Zm4 0h.01v.01H16V13Zm-8 4h.01v.01H8V17Zm4 0h.01v.01H12V17Zm4 0h.01v.01H16V17Z"/></svg>
            </span>
            <time class="bg-neutral-secondary-medium border border-default-medium text-heading text-xs font-medium px-1.5 py-0.5 rounded">${event.getStart(DateTimeFormatter.ofPattern("MMMM d'th', yyyy"))}</time>
            <h3 class="my-2 text-lg font-semibold text-heading">${event.getSummary()}</h3>
            <p class="text-body">${event.getDescription()}</p>
        </li>
        @endfor
    </ol>
</div>

<script src="https://cdn.jsdelivr.net/npm/flowbite@4.0.1/dist/flowbite.min.js"></script>
</body>
</html>
