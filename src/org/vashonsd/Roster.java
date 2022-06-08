package org.vashonsd;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    // this class has an array list of Runners called roster. It is esentaly a list for lists.
    String teamName;
    List<Runner> runners = new ArrayList<>();


    public Roster(String teamName) {
        this.teamName = teamName;
    }

    public void addRunner(Runner r) {
        runners.add(r);
    }

    //this will run through all the runners in a Roster and return the runners that have met their goal.
    public List<Runner> runnersThatHaveMetGoal() {
        List<Runner> result = new ArrayList<>();
        for(Runner r : runners) {
            if(r.didMetGoal()) {
                result.add(r);
            }
        }
        return result;
    }


    // returns string of the rosters team name and runners when the class is printed
    @Override
    public String toString() {
        return "Roster{" +
                "teamName='" + teamName + '\'' +
                ", runners=" + runners +
                '}';
    }
}
