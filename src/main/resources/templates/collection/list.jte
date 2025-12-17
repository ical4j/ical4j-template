@import org.ical4j.connector.ObjectCollection
@import java.util.List

@param List<ObjectCollection<?>> collections

@for(var c : collections)
    ${c.getDisplayName()}
@endfor
