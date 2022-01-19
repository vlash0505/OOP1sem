package mytimeorganizer.models;

import java.util.Date;

public class Task {

    public static Long USER_ID;

    private Long id;
    private Date date;
    private String description;
    private boolean isCompleted;

    public static Long getUserId() {
        return USER_ID;
    }

    public static void setUserId(Long userId) {
        USER_ID = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
