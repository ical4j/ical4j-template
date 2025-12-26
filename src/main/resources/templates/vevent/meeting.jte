@import org.ical4j.template.view.VEventView
@import java.util.Base64

@param VEventView event

<h1>${event.getSummary()}</h1>
<p>
    <strong>Start:</strong> ${event.getStart()}<br/>
    <strong>End:</strong> ${event.getEnd()}<br/>
    <strong>Location:</strong> ${event.getLocation()}<br/>
</p>
<iframe src="data:text/html;base64,${Base64.getEncoder().encodeToString(event.getDescription().getBytes())}" width="600" height="400">
</iframe>
