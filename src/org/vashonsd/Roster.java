package org.vashonsd;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    String teamName;
    List<Runner> runners = new ArrayList<>();

    public Roster(String teamName) {
        this.teamName = teamName;
    }

    public void addRunner(Runner r) {
        runners.add(r);
    }

    public List<Runner> runnersThatHaveMetGoal() {
        List<Runner> result = new ArrayList<>();
        for(Runner r : runners) {
            if(r.didMetGoal()) {
                result.add(r);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Roster{" +
                "teamName='" + teamName + '\'' +
                ", runners=" + runners +
                '}';
    }
}
