import org.example.FitnessTracker;
import org.junit.jupiter.api.Test; // JUnit Test annotation
import static org.junit.jupiter.api.Assertions.*; // Static methods for assertions


public class FitnessTrackerTest {
    @Test
    void testLogWorkout() {
        FitnessTracker tracker = new FitnessTracker();
        tracker.logWorkout("Running", 30);
        assertEquals(1, tracker.getWorkouts().size(), "There should be 1 workout logged.");
    }

    @Test
    void testCalculateTotalCaloriesBurned() {
        FitnessTracker tracker = new FitnessTracker();
        tracker.logWorkout("Running", 30);
        tracker.logWorkout("Cycling",45);

        int totalCalories = tracker.getTotalCaloriesBurned();
        assertEquals(375, totalCalories);
    }

    @Test
    void testSetFitnessGoal() {
        FitnessTracker tracker = new FitnessTracker();
        tracker.setFitnessGoal(1000); // Set the goal to burn 1000 calories
        assertEquals(1000, tracker.getFitnessGoal(), "The fitness goal should be set to 1000.");
    }

    @Test
    void testHasReachedGoal_NotYet() {
        FitnessTracker tracker = new FitnessTracker();
        tracker.logWorkout("Running", 30); // Burn 150 calories
        tracker.setFitnessGoal(200); // Goal is set to 200 calories

        assertFalse(tracker.hasReachedGoal(), "The goal should not be reached yet.");
    }

    @Test
    void testHasReachedGoal_Achieved() {
        FitnessTracker tracker = new FitnessTracker();
        tracker.logWorkout("Running", 30); // Burn 150 calories
        tracker.logWorkout("Cycling", 45); // Burn 225 calories
        tracker.setFitnessGoal(375); // Goal is set to 375 calories

        assertTrue(tracker.hasReachedGoal() );
    }
}

