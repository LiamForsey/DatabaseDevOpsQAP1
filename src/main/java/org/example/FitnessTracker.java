package org.example;

import java.util.ArrayList;
import java.util.List;

public class FitnessTracker {
    private final List<Workout> workouts;
    private int fitnessGoal; // in calories

    public FitnessTracker() {
        workouts = new ArrayList<>();
        fitnessGoal = 0;
    }

    // Log a workout
    public void logWorkout(String type, int duration) {
        workouts.add(new Workout(type, duration)); // This here adds a new workout to the list
    }

    // This will get the total calories burned so far
    public int getTotalCaloriesBurned() {
        int total = 0;
        for (Workout w : workouts) {
            total += w.getCaloriesBurned();
        }
        return total;
    }

    // Set a fitness goal
    public void setFitnessGoal(int goal) {
        this.fitnessGoal = goal;
    }

    // Get the current fitness goal
    public int getFitnessGoal() {
        return fitnessGoal;
    }

    // Check if the goal has been met
    public boolean hasReachedGoal() {
        return getTotalCaloriesBurned() >= fitnessGoal;
    }

    // Get the list of all workouts
    public List<Workout> getWorkouts() {
        return workouts;
    }

    // Print all logged workouts
    public void printWorkouts() {
        System.out.println("Workouts:");
        for (Workout w : workouts) {
            System.out.println("- " + w.getWorkoutType() + " for " + w.getDuration() + " min, burned " + w.getCaloriesBurned() + " cal");
        }
    }

    public static void main(String[] args) {
        FitnessTracker tracker = new FitnessTracker();

        tracker.logWorkout("Running", 30);
        tracker.logWorkout("Cycling", 45);
        tracker.logWorkout("Lifting", 60);

        tracker.setFitnessGoal(1000);

        tracker.printWorkouts();
        System.out.println("Total Calories Burned: " + tracker.getTotalCaloriesBurned());
        System.out.println("Fitness Goal: " + tracker.getFitnessGoal());

        if (tracker.hasReachedGoal()) {
            System.out.println("Nice! You reached your goal!");
        } else {
            System.out.println("Keep going! You need " + (tracker.getFitnessGoal() - tracker.getTotalCaloriesBurned()) + " more calories.");
        }
    }
}
