# iCal4j-templates - A collection of templates for popular calendar use-cases

[Introduction]: #introduction

[Usage]: #usage

[Examples]: #examples


#### Table of Contents

1. [Introduction - What is iCal4j-templates?][Introduction]
2. [Usage - How to use this library][Usage]
    - [Examples - common usage scenarios][Examples]

## Introduction

Whilst the icalendar specification may be used to describe just about any activity or event, typically there are some use-cases that are more widely used than others.

Such use-cases may include birthdays and other anniversary-style observances, scheduling activities such as timetables and meetings, task management, and historical activities including recording of meeting minutes.

ical4j-templates offers an opinionated view of how such popular activities may be structured, providing a simpler and consistent approach to time-based management.

## Usage

This library is primarily based on the `Builder` pattern, whereby inputs are collected before generating iCalendar objects using the opinionated template.

### Examples

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
