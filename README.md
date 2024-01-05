# iCal4j Templates

iCalendar templates for common use-cases

## Overview

iCal4j Templates is designed to make the iCalendar specifications more accessible by providing a
discoverable API for common applications. For example, a simple meeting or task may not require the full
functionality provided by iCalendar, but you still need to understand it in order to
produce valid content.

This library aims to make it easier to construct valid iCalendar content without needing to read the
specifications in full.

Templates includes in this library are used to create or modify iCalendar objects. 

### Domains

Template domains are simply a grouping of related templates that may be applied to a specific problem domain.
Currently, the supported domains include:

* Groupware - support for collaborative applications
* Project - Project management
* Agile - agile management processes
* Workflow - Work management
* Catalog - develop a service catalog
* Wiki - knowledge management


## Groupware

Support collaborative features such as calendar and task management, scheduling appointments
and meetings, as well as journaling and note-taking.

### Meeting

Meetings are scheduled with two or more participants, and may be created as follows:

```java
VEvent meeting = new Meeting().start(ZonedDateTime.of(...))
    .required(URI.create("mailto:joe@example.com")).required(URI.create("mailto:sally@example.com"))
    .optional(URI.create("mailto:fred@example.com"))
    .chair(URI.create("mailto:vanessa@example.com")).apply();
```


## Project

TBD.


## Agile

TBD.


## Workflow

Journal your workflows and deliverables as you work. Build a relational graph of people, teams, outputs
and dependencies.


## Catalog

Maintain a graph of customer and vendor relationships. Track offers and orders, and monitor customer satisfaction.


## Wiki

TBD.


<!--
## iCalendar and vCard Collections

In practice iCalendar and vCard formats are well-supported by server implementations of the CalDAV and
CardDAV specifications. This library is modeled around potential use-cases for CalDAV and CardDAV collections.

For example, a CalDAV server implementation could define the following default collections for VEvents:

    /appointments   # events without attendees - used by the organizer to block calendar time
    /meetings       # events with multiple participants
    /reminders      # transparent events used to provide deadline notifications, etc.

Similarly, the following collections could support different types of VToDo:

    /actions        # assignable tasks in response to events, journals, or other tasks
    /engagements    # temporary relationships between two parties
    /issues         # tracking for incidents, changes, risks, etc.
    /orders         # order pertaining to one or more offers from another party
    /requests       # service requests from one party to another

And the following collections for VJournal types:

    /annotations    # a note referencing an event, task or other journal type
    /articles       # a knowledge base article in response to an event or task
    /invoices       # invoice pertaining to an order
    /metrics        # measurement of qantitative metrics pertaining to events, tasks or journal types
    /notes          # independent notes 
    /offers         # published offers used to build a product or service catalog
    /records        # 

For a CardDAV server implementation the following default collections could apply:

    /assets         # inventory of items of value
    /items          # configuration items used to build a CMDB
    /groups         # collection of entities used to define teams, etc.
    /orgs           # relationships with other organizations
    /places         # physical locations
    /products       # product definitions including branding and logos
    /services       # service definitions including branding and logos
    /subscriptions  # entity groups notified when specific collections, events, tasks or journals are modified
    /users          # user profiles capturing contact information and availability

-->