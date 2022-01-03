package mytimeorganizer.database;

import mytimeorganizer.models.Goal;

import java.util.List;

public class GoalsStorage {
    private final GoalDAO goalDAO;

    private GoalDAO buildDAO() {
        return new DerbyGoalDAO();
    }

    private GoalsStorage buildGoalsStorage() {
        return new GoalsStorage(buildDAO());
    }

    public GoalsStorage(GoalDAO goalDAO) {
        this.goalDAO = goalDAO;
    }

    public void addNewGoal(String type, String description) {
        Goal goal = new Goal();
        goal.setType(type);
        goal.setDescription(description);
        goalDAO.insertGoal(goal);
    }

    public void deleteGoal(int uniqueID) {
        List<Goal> goals = goalDAO.findGoalByProperty(GoalSearchType.ID, uniqueID);
        if(!goals.isEmpty()) { goalDAO.deleteGoal(goals.get(0)); }
    }

    public void updateGoal() {

    }
}
