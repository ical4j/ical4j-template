# iCal4j Templates

A decorator layer on iCalendar and vCard for common use-cases

## Overview

iCal4j Templates is designed to make the iCalendar and vCard specifications more accessible by providing a
discoverable API for common applications.

For example, a simple meeting or task may not require the full functionality provided by the iCalendar specification,
but you still need to understand all of it in order to produce valid content.

This library aims to make it easier to construct valid iCalendar and vCard content without needing to read the
specifications in full.

## Usage

TBD.

### Examples

TBD.

#### Creating a Public Holiday

Public holidays are often anniversary-style events that can be created as follows:

```
VEvent christmasDay = new AnniversaryBuilder().title("Christmas Day").date(LocalDate.of(1970, Month.December, 25)).build();
```

The resulting iCalendar object would look like this:

```
BEGIN:VEVENT
END:VEVENT
```
