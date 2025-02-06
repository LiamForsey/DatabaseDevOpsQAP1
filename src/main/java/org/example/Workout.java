package org.example;

public class Workout {
    private final String type; // This is for the type of the workout
    private final int time; // The Time (In Minutes)
    private static final int CALORIES_RATE = 5; // The calories burned per minute

    public Workout(String type, int time) {
        this.type = type;
        this.time = time;
    }

    // code to configure the calories burned
    public int getCaloriesBurned() {
        return time * CALORIES_RATE;
    }

    // shows the workout type
    public String getWorkoutType() {
        return type;
    }

    // shows how long the workout was
    public int getDuration() {
        return time;
    }
}
