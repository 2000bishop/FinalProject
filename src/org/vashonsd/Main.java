package org.vashonsd;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Create two instances of the Runner class. then print there respective information.
        System.out.println("welcome! here is your info:");
        Runner bishop = new Runner("Bishop");
        bishop.setGoal(20.12);
        bishop.recordRun(LocalDate.of(2021, 5, 23), 16.07);
        bishop.recordRun(LocalDate.of(2020, 8, 14), 21.45);
        bishop.recordRun(LocalDate.now(), 18.31);
        System.out.println("Here is bishop's average time: " + bishop.getAverageTime());
        if (bishop.didMetGoal()) {
            System.out.println("bishop did meet his goal");
        } else {
            System.out.println("bishop did NOT meet his goal");
        }
        System.out.println(bishop.didMetGoal());

        Runner ted = new Runner("Ted");
        ted.setGoal(18.94);
        ted.recordRun(LocalDate.of(2021, 6, 18), 19.04);
        ted.recordRun(LocalDate.of(2022, 3, 18), 19.23);
        ted.recordRun(LocalDate.of(2021, 9, 6), 20.24);
        System.out.println("Here is ted's average time: " + ted.getAverageTime());
        if (ted.didMetGoal()) {
            System.out.println("ted did meet his goal");
        } else {
            System.out.println("ted did NOT meet his goal");
        }

        System.out.println(ted.didMetGoal());



        //makes a roster class with the team name as "Pirates" and adds the bishop and ted runners to it then prints it.
        Roster pirates = new Roster("Pirates");
        pirates.addRunner(bishop);
        pirates.addRunner(ted);
        System.out.println(pirates);
        System.out.println(pirates.runnersThatHaveMetGoal());


        Scanner scan = new Scanner(System.in);

        // makes a while loop that acts as an interface for the user,
        // they enter one of the text commands given and  allow them to edit variables (temporarily till they close the program), pull up information, or close the program.

        while (true) {
        System.out.println("you can: set my goal , what did I run on date , did I reach my goal? , exit");
        System.out.println("what would you like to do?");
        String userResponse = scan.nextLine();

        // temporarily edits the goal variable, till user closes the program.
        if (userResponse.equals("set my goal")) {
            System.out.println("what is your goal?");
            Double userDouble = scan.nextDouble();
            bishop.setGoal(userDouble);
            System.out.println("your goal is now: " + bishop.getGoal());
        }
        // closes the program
        else if (userResponse.equals("exit")) {
            System.out.print("goodbye");
            break;
        }
        //checks if the user's runner profile(bishop) reaches there goal. Then prints if they did or did not make there goal.
        // And it includes how much they were over or under their goal. It does this by subtracting your best score by your goal then shows the difference.
        else if (userResponse.equals("did I reach my goal?")) {
            System.out.println("your goal was: " + bishop.goal);
            double best = 100000000000.0;
            for(Double time : bishop.times.values()) {
                if (time <= best) {
                    best = time;
                }
            }
            System.out.println("your best time was: " + best);
           double diffrence = best - bishop.goal;
            if(diffrence <= 0){
                System.out.println("Yes, you where " + (-1 * diffrence) + " over your goal");
            }
             else
             {
                System.out.println("No you were " + diffrence + " away from your goal");
            }
        }
        // The program will ask the user for a date. This date will be used as a key in the getTimeFromDate() function to get the time variable.
        else if (userResponse.equals("what did I run on date")) {
            System.out.println("what Year?");
            int userIntegerYear = scan.nextInt();
            System.out.println("what month?");
            int userIntegerMonth = scan.nextInt();
            System.out.println("what day?");
            int userIntegerDay = scan.nextInt();
            System.out.println( "Your run time was: " + bishop.getTimeFromDate(LocalDate.of(userIntegerYear, userIntegerMonth, userIntegerDay)));

        }
        // This method is made to detect incorrect commands or junk text and loop back to the command interface to try again. This keep the program from crashing.

        else {
            System.out.println("I dont know what you mean");
        }
    }


    }


}
