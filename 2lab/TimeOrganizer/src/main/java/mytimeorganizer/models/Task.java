package mytimeorganizer.models;

import java.util.Date;

public class Task {
    Date creationDate;
    String description;

    public Task(Date creationDate, String description) {
        this.creationDate = creationDate;
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
