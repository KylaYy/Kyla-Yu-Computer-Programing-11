import java.util.*;


public class Main {
    public static void main(String[] args) {
        // Variables
        String s = "scissors";
        String r = "rock";
        String p = "paper";

        String win = "You Win!";
        String loss = "You Lose!";
        //Hhaha drawstring
        String draw = "Draw!";

        Scanner scan = new Scanner(System.in);

        // Computer generated answer:
            // In this section a random double value between 0 and 2 is generated, then rounded to an integer. This creates a random number that is either 0, 1, or 2.
            // This random integer is used to select one of three variables in the list "choices".
            //(The list items have index numbers starting at 0, so the random integer, assigned to the variable "randomvalue", can be used to select an item from the list.
            // The selected variable is stored in a new variable, "compchoice".
        //Each time the program runs, a new random integer value is generated, resulting in a random selection from the list.

        double random = (double)Math.random() * 2;
        int randomvalue = (int)Math.round(random);

        List<String> choices = Arrays.asList(r, p, s);
        String compchoice = choices.get(randomvalue);

        //User Input:
        // This section takes user input and the computer response, then returns an outcome (win, loss, draw, invalid response, etc.)
            //Initial Prompt:
        System.out.println("Choose rock paper or scissors. \'r\' for rock, \'p\' for paper and \'s\' for scissors.");

            //The code then takes a response from the user:
        String useranswer = scan.next();

            //Conditions are applied to the user input to create an appropriate response:

        // For example:
        // If the player chooses rock, a specific set of conditions are applied to the computer selection to determine whether the match was a win, loss, or draw
        if(Objects.equals(useranswer, "r")) {
            //If the computer selection is also rock, assigned to the variable "r", the match is a draw. A string will be printed that announces a draw.
            if(Objects.equals(compchoice, r))
                System.out.println(draw);
            //If the computer selection is not rock but scissors, the player wins. A string will be printed to announce a win.
            else if(Objects.equals(compchoice, s))
                System.out.println(win);
            //If the computer selection is neither rock or scissors but paper, the player loses. A string will be printed to announce a loss.
            else if(Objects.equals(compchoice, p))
                System.out.println(loss);
            System.out.print("Computer Choice: " + compchoice);
            System.out.print("\tPlayer choice: rock\n");
        }
        else if(Objects.equals(useranswer, "p")) {
            if(Objects.equals(compchoice, p))
                System.out.println(draw);
            else if(Objects.equals(compchoice, s))
                System.out.println(loss);
            else if(Objects.equals(compchoice, r))
                System.out.println(win);
            System.out.print("Computer Choice: " + compchoice);
            System.out.print("\tPlayer choice: paper\n");
        }
        else if(Objects.equals(useranswer, "s")) {
            if(Objects.equals(useranswer, compchoice))
                System.out.println(draw);
            else if(Objects.equals(compchoice, r))
                System.out.println(loss);
            else if(Objects.equals(compchoice, p))
                System.out.println(win);
            System.out.print("Computer Choice: " + compchoice);
            System.out.print("\tPlayer choice: scissors\n");
        }
            //If a response other than "r", "p", or "s" is received, the code will return an error message
        else {
            System.out.println("Invalid selection please play again.\n");
        }
    }
}
