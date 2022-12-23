# iCal4j Templates

A collection of data templates for popular calendar use-cases

## Overview

iCal4j Templates provide support for data prototyping and validation based on the iCalendar and vCard standard.
Often we spend a considerable amount of time defining data models and validation for entities and relationships
that are commonly modeled time and time again. This library demonstrates that we can often use the same models
for different applications via the concept of data polymorphism.

### Data Polymorphism

You may be familiar with Polymorphism as one of the key pillars of the Object-oriented Paradigm. This is where an
object may assume multiple forms simultaneously, such that we can group and operate on them in different contexts.

Data Polymorphism allows us to represent and manipulate data differently depending on the context, which can
increase both the longevity and usefulness of our data, with potential to be shared across different applications
and contexts.

This project provides concrete implementations of well-known data types that can be modeled using iCalendar and
vCard objects. Typically, this will include most temporal-based definitions (e.g. events, tasks, etc.) and other
entities such as people, products and services.


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
