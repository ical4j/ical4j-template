# iCal4j Templates

This library builds on the models provided by iCal4j to support rendering of iCalendar and vCard objects using
template views.

The library includes a collection of predefined Views and Templates that can be used to render iCalendar and
vCard objects in different formats.

## Views

iCal4j Views are classes that support rendering iCalendar and vCard objects as text. Views provide accessor methods
that return string representations of relevant properties for the underlying iCalendar or vCard object.

Views may be used directly, or as part of a Template rendering process.

Common traits of Views:

* Return values for accessor methods are either string literals, or collections of string literals or other Views
* No complex objects are returned (e.g. Date, URI, etc.)
* Views are read-only representations of the underlying iCalendar or vCard object


## Templates

iCal4j Templates are implemented using JTE syntax, and provide different rendering options for iCalendar and
vCard views. Template input parameters are typically iCal4j Views, although other parameters may be used as needed.

Most templates will render as HTML, but other formats may be supported as needed.

HTML templates use Tailwind CSS for styling. The CSS files are embedded in page template output for simplicity, but
for fragment templates you will need to include the Tailwind CSS file in your application separately.




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