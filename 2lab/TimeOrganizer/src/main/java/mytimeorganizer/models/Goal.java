package mytimeorganizer.models;

import java.util.Objects;

/**
 * This class represents the goal model.
 */

public class Goal {

    //properties -------------------------------------------------------------------------------------------------------

    private int uniqueID;
    private String type;
    private String description;
    private boolean isDone;

    //getters and setters ----------------------------------------------------------------------------------------------

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
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
        return uniqueID == goal.uniqueID;
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
        return Objects.hash(uniqueID);
    }

    /**
     * Returns the String representation of the goal instance.
     *
     * @return String representation of the goal instance.
     */
    @Override
    public String toString() {
        return "Goal{" +
                "uniqueID=" + uniqueID +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
