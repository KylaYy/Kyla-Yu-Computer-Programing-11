import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Variables
        String s = "scissors";
        String r = "rock";
        String p = "paper";

        String win = "You Win!";
        String loss = "You Lose!";
        String draw = "Draw!";
        // user response it set to an empty string so data can be stored in it
        String useranswer = "";
        // win/loss counts. Each time in the player wins or loses during the loop, the corresponding integer is increased by 1.
        int wins = 0;
        int losses = 0;

        Scanner scan = new Scanner(System.in);

        //The initial prompt and first printing of the score
        System.out.println("Choose rock paper of scissors. \'r\' for rock, \'p\' for paper and \'s\' for scissors. To exit choose \'x\' \n**************************************************");
        System.out.println("Wins: " + wins + "\tLosses: " + losses);

        //The loop. It runs once before repeating itself (depending on what the player response is)
        do {
            System.out.println("Players Choice:");
            //Each time the loop runs the player response is assigned to the variable useranswer.
            useranswer = scan.next();

            /*The same random selection of rock, paper, or scissors as the original rock paper scissors program. A random integer between 1 and 3 is generated,
            then used to select an item from the list of items r, p, and s. Each of these variables corresponds to a variable, each with the strings "rock", "paper",
            and "scissors" assigned to them respectively. The result is then assigned to the variable compchoice. */
            double random = (double)Math.random() * 2;
            int randomvalue = (int)Math.round(random);
            List<String> choices = Arrays.asList(r, p, s);
            String compchoice = choices.get(randomvalue);

            /* Also the sae from the original r, p, s program but with some slight alterations. Everything is the sae but
            now each time the player wins or loses, a variable, either wins or losses, is increased by one. These variables are printed at the beginning of
            each loop.
             */
            if(Objects.equals(useranswer, "r")) {
                if(Objects.equals(compchoice, r)) {
                    System.out.println(draw);
                }else if(Objects.equals(compchoice, s)) {
                    System.out.println(win);
                    wins++;
                }else if(Objects.equals(compchoice, p)) {
                    System.out.println(loss);
                    losses++;
                }System.out.print("Computer Choice: " + compchoice);
                System.out.print("\tPlayer choice: rock\n");
            } else if(Objects.equals(useranswer, "p")) {
                if(Objects.equals(compchoice, p)) {
                    System.out.println(draw);
                }else if(Objects.equals(compchoice, s)) {
                    System.out.println(loss);
                    losses++;
                }else if(Objects.equals(compchoice, r)) {
                    System.out.println(win);
                    wins++;
                }System.out.print("Computer Choice: " + compchoice);
                System.out.print("\tPlayer choice: paper\n");
            } else if(Objects.equals(useranswer, "s")) {
                if(Objects.equals(compchoice, s)) {
                    System.out.println(draw);
                }else if(Objects.equals(compchoice, r)) {
                    System.out.println(loss);
                    losses++;
                }else if(Objects.equals(compchoice, p)) {
                    System.out.println(win);
                    wins++;
                }System.out.print("Computer Choice: " + compchoice);
                System.out.print("\tPlayer choice: scissors\n");
            } else {
                if (useranswer.equals("x")) {
                    break;
                } else System.out.println("Invalid selection please play again.");
            }
            System.out.println("**************************************************");
            System.out.println("Wins:" + wins + "\tLosses:" + losses);
        }
        while(useranswer.equals("x") == false);
        /* this loop runs once, then continues on the condition that the user input is not equal to the string "x".
        Once this is inputed by the user, the loop will end.
         */

        System.out.println("Thank you for playing!");
        /* Once the loop ends, this string will be printed onto the console.
         */
    }
}
