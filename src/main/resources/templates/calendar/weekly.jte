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

<div class="w-full bg-white rounded-lg shadow dark:bg-gray-800">
    <!-- Header -->
    <div class="grid grid-cols-8 border-b border-gray-200 dark:border-gray-700">
        <div class="p-4"></div>

        <div class="p-4 text-center font-semibold text-gray-700 dark:text-gray-200">
            Mon
        </div>
        <div class="p-4 text-center font-semibold text-gray-700 dark:text-gray-200">
            Tue
        </div>
        <div class="p-4 text-center font-semibold text-gray-700 dark:text-gray-200">
            Wed
        </div>
        <div class="p-4 text-center font-semibold text-gray-700 dark:text-gray-200">
            Thu
        </div>
        <div class="p-4 text-center font-semibold text-gray-700 dark:text-gray-200">
            Fri
        </div>
        <div class="p-4 text-center font-semibold text-gray-700 dark:text-gray-200">
            Sat
        </div>
        <div class="p-4 text-center font-semibold text-gray-700 dark:text-gray-200">
            Sun
        </div>
    </div>

    <!-- Time grid -->
    <div class="grid grid-cols-8 divide-x divide-gray-200 dark:divide-gray-700">
        <!-- Time column -->
        <div class="flex flex-col">
            <!-- Repeat for each hour -->
            <div class="h-20 px-2 text-xs text-gray-500 dark:text-gray-400 border-b">
                08:00
            </div>
            <div class="h-20 px-2 text-xs text-gray-500 dark:text-gray-400 border-b">
                09:00
            </div>
            <div class="h-20 px-2 text-xs text-gray-500 dark:text-gray-400 border-b">
                10:00
            </div>
            <div class="h-20 px-2 text-xs text-gray-500 dark:text-gray-400 border-b">
                11:00
            </div>
            <div class="h-20 px-2 text-xs text-gray-500 dark:text-gray-400 border-b">
                12:00
            </div>
        </div>

        <!-- Day columns -->
        <div class="relative border-b">
            <!-- Event -->
            <div
                    class="absolute top-20 left-2 right-2 h-16 rounded-lg bg-blue-100 text-blue-800 text-xs p-2 dark:bg-blue-900 dark:text-blue-200"
            >
                Team Meeting
                <div class="text-[10px]">09:00 – 10:00</div>
            </div>
        </div>

        <div class="relative border-b"></div>
        <div class="relative border-b"></div>
        <div class="relative border-b"></div>
        <div class="relative border-b"></div>
        <div class="relative border-b"></div>
        <div class="relative border-b"></div>
    </div>
</div>

</body>
</html>
