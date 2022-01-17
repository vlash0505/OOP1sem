package mytimeorganizer.models;

import java.util.Objects;

/**
 * This class represents the goal model.
 */

public class Goal {

    public static Long USER_ID;

    //properties -------------------------------------------------------------------------------------------------------

    private Long id;
    private String type;
    private String description;
    private boolean isCompleted;
    private Long userId;

    //getters and setters ----------------------------------------------------------------------------------------------

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean done) {
        isCompleted = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    //Object overrides -------------------------------------------------------------------------------------------------

    /**
     * Compares two instances. As the ID is unique for
     * each instance, method should compare by ID only.
     *
     * @param o instance to e compared.
     * @return true if the instances are equal,
     *         false - otherwise.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal = (Goal) o;
        return Objects.equals(id, goal.id);
    }

    /**
     * Returns the hash code of the goal instance. As ID is
     * unique for each goal, goal with same ID should
     * return the same hashcode.
     *
     * @return hash code of the goal instance.
     */

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Returns the String representation of the goal instance.
     *
     * @return String representation of the goal instance.
     */
    @Override
    public String toString() {
        return "Goal{" +
                "uniqueID=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", isDone=" + isCompleted +
                '}';
    }
}
