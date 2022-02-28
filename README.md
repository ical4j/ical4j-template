# iCal4j-templates - A collection of templates for popular calendar use-cases

[Introduction]: #introduction

[Usage]: #usage

[Examples]: #examples


#### Table of Contents

1. [Introduction - What is iCal4j-templates?][Introduction]
2. [Usage - How to use this library][Usage]
    - [Examples - common usage scenarios][Examples]

## Overview

iCal4j Templates provide support for Calendar and Component prototyping and custom validation. A
template may be defined programmatically or via a supported template definition file format.

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
