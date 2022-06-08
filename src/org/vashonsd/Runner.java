package org.vashonsd;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Runner {
    // makes a list of runners along with class methods to use them in.
    String nameOfRunner;
    Map<LocalDate, Double> times = new HashMap<>();
    Double goal;



    public Runner(String nameOfRunner) {
        this.nameOfRunner = nameOfRunner;
    }

    public Runner(Double goal){this.goal = goal;}

    public void setGoal(Double goal) {
        this.goal = goal;
    }

    public Double getGoal() {
        return goal;
    }

    //Return the time matching the given date.
    public Double getTimeFromDate(LocalDate whatDate){
        if(!times.containsKey(whatDate)) {
            return null;
        }
        return times.get(whatDate);
    }



    //Returns the average time of all the runs.
    public Double getAverageTime() {
        Double sum = 0.0;
        for(Double time : times.values()) {
            sum += time;
        }
        return sum / times.values().size();
    }

    public Map<LocalDate, Double> getTimes(){
        return times;
    }

    public void recordRun(LocalDate when, Double time){
        times.put(when, time);
    }

    //return true or false based on whether this Runner has ever met their goal.
     public boolean didMetGoal(){
        for(Double time : times.values()) {
            if (time <= goal) {
                return true;
            }
        }
        return false;
    }
    //  loops through map. return any days that met the goal
    public List<LocalDate> daysmetgoal(){
        List<LocalDate> metgoal = new ArrayList<LocalDate>();
        for(LocalDate date: times.keySet()) {
            if(times.get(date) < goal){
                metgoal.add(date);
            }
        }
        return metgoal;
    }
// prints runner information
    @Override
    public String toString() {
        return "Runner{" +
                "nameOfRunner='" + nameOfRunner + '\'' +
                ", times=" + times +
                ", goal=" + goal +
                '}';
    }
}
