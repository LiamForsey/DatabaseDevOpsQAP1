// This project is for a fitness tracker, however i slightly turned mine into a fat loss journey project...
// instead of different workouts like weights within, i made it so it shows how many calories you burned,
// Compared to the calorie goal of your workout. if someones goal is to burn 500 calories for example, if they meet it
// or if they need to do more to meet it or etc.


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



    // This function will Log a workout
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


    // code below will configure the type and how long workout is
    public static void main(String[] args) {
        FitnessTracker tracker = new FitnessTracker();

        tracker.logWorkout("Treadmill", 15);
        tracker.logWorkout("Bike", 15);
        tracker.logWorkout("Weightlifting", 45);

        // This is the goal of calories burned in the session
        tracker.setFitnessGoal(500);


        // printing out results in terminal
        tracker.printWorkouts();
        System.out.println("Calories Burned: " + tracker.getTotalCaloriesBurned());

        System.out.println("Calorie Goal: " + tracker.getFitnessGoal());


        if (tracker.hasReachedGoal()) {
            System.out.println("Nice! You reached your calorie goal!");
        } else {
            System.out.println("Keep going! You need " + (tracker.getFitnessGoal() - tracker.getTotalCaloriesBurned()) + " more calories to reach your goal!.");

        }
    }
}