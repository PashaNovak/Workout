package workout.hfad.com.workout;

/**
 * Created by G710 on 05.03.2018.
 */

public class Workout {
    private String name;
    private String decription;

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 pull-ups"),
            new Workout("Core Agony",
                    "100 pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("The Wimp Special",
                    "5 Pull-ups\n10 Push-aps\n15 Squats"),
            new Workout("Strength and Length",
                    "500 meters run\n21 * 1.5 pood kettleball swing\n21 x pull-ups")
    };

    private Workout(String name, String decription) {
        this.name = name;
        this.decription = decription;
    }

    public String getName() {
        return name;
    }

    public String getDecription() {
        return decription;
    }

    public String toString(){
        return name;
    }
}
