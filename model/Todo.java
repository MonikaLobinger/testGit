// UNd noch ein Kommentar
package my.test.notes.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class Todo
{
private PropertyChangeSupport changes           = new PropertyChangeSupport(this);

public static final String    FIELD_ID          = "id";
public static final String    FIELD_SUMMARY     = "summary";
public static final String    FIELD_DESCRIPTION = "description";
public static final String    FIELD_DONE        = "done";
public static final String    FIELD_DUEDATE     = "dueDate";

private long                  id;
private String                summary           = "";
private String                description       = "";
private Date                  dueDate;
private boolean               done              = false;

public Todo()
{
    super();
}

public Todo(long id)
{
    super();
    this.id = id;
}

public Todo(long id, String summary, String description, boolean done, Date dueDate)
{
    super();
    this.id = id;
    this.summary = summary;
    this.description = description;
    this.done = done;
    this.dueDate = dueDate;
}

public Todo copy()
{
    return new Todo(this.id, this.summary, this.description, this.done, this.dueDate);
}

public String getSummary()
{
    return summary;
}

public void setSummary(String summary)
{
    changes.firePropertyChange(FIELD_SUMMARY, this.summary, this.summary = summary);
}

public String getDescription()
{
    return description;
}

public void setDescription(String description)
{
    changes.firePropertyChange(FIELD_DESCRIPTION, this.description, this.description = description);
}

public boolean isDone()
{
    return done;
}

public void setDone(boolean done)
{
    changes.firePropertyChange(FIELD_DONE, this.done, this.done = done);
}

public Date getDueDate()
{
    return dueDate;
}

public void setDueDate(Date dueDate)
{
    changes.firePropertyChange(FIELD_DUEDATE, this.dueDate, this.dueDate = dueDate);
}

public long getId()
{
    return id;
}

@Override
public String toString()
{
    return "Todo [id=" + id + ", summary=" + summary + "]";
}

@Override
public int hashCode()
{
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    return result;
}

@Override
public boolean equals(Object obj)
{
    if(this == obj)
        return true;
    if(obj == null)
        return false;
    if(getClass() != obj.getClass())
        return false;
    Todo other = (Todo) obj;
    if(id != other.id)
        return false;
    return true;
}

public void addPropertyChangeListener(PropertyChangeListener l)
{
    changes.addPropertyChangeListener(l);
}

public void removePropertyChangeListener(PropertyChangeListener l)
{
    changes.removePropertyChangeListener(l);
}
}
