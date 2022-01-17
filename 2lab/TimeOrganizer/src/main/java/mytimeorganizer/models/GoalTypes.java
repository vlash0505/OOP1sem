package mytimeorganizer.models;

public enum GoalTypes {
    PERSONAL("personal"),
    WORK("work"),
    STUDY("study");

    private final String goalType;

    GoalTypes(String goalType) {
        this.goalType = goalType;
    }

    public String getGoalType() {
        return goalType;
    }
}
