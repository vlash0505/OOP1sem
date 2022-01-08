package mytimeorganizer.database;

import mytimeorganizer.models.Goal;

import java.util.List;

public class GoalsStorage {
    private final GoalDAO goalDAO;

    public GoalsStorage(GoalDAO goalDAO) {
        this.goalDAO = goalDAO;
    }

    private GoalDAO buildDAO() {
        return new DerbyGoalDAO();
    }

    private GoalsStorage buildGoalsStorage() {
        return new GoalsStorage(buildDAO());
    }

    public void setupDB() {
        goalDAO.setup();
    }

    public void connectToDB() {
        goalDAO.connect();
    }

    public void closeDB() {
        goalDAO.close();
    }


    /**
     * Adds the new goal to database.
     *
     * @param type        type of the goal to be inserted.
     * @param description description of the goal to be inserted.
     */

    public void addNewGoal(String type, String description) {
        Goal goal = new Goal();
        goal.setType(type);
        goal.setDescription(description);
        goalDAO.insertGoal(goal);
    }

    /**
     * Deletes the goal instance from the database.
     *
     * @param uniqueID ID of the goal to be deleted.
     */

    public void deleteGoal(int uniqueID) {
        List<Goal> goals = goalDAO.findGoalByProperty(GoalSearchType.ID, uniqueID);
        if(!goals.isEmpty()) { goalDAO.deleteGoal(goals.get(0)); }
    }

    /**
     * Updates the description of the goal instance.
     *
     * @param uniqueID ID of the goal.
     */


    public void updateGoalDescription(int uniqueID) {

    }
}
