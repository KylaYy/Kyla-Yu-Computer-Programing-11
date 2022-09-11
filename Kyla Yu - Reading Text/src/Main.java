import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Word Search
    public static void wordSearch(ArrayList<String> list, String word){
        for (String search : list){
            search.replaceAll("," , " ");
            search.replaceAll("\\.", " ");
            String[] wordsOfSearch = search.split(" ");
            for (String wordTemp : wordsOfSearch){
                if (wordTemp.equalsIgnoreCase(word)){
                    System.out.println("The word \""+word+"\" occurs in line " + (list.indexOf(search)+1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //Input Output variables
        FileInputStream in;
        ArrayList<String> lines =  new ArrayList<>();
        FileReader fr = new FileReader("programmingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        //Setting files for input and output
        in = new FileInputStream("programmingHistory.txt");

        //Copying lines of text
        while ((line = br.readLine()) != null){
            lines.add(line);
        }
        br.close();

        //Word search variables
        String word;
        Scanner scanner = new Scanner(System.in);

        //Taking in word from user and calling wordsearch method
        System.out.println("Enter search word here or enter \"exit\" to exit the program: ");
        word = scanner.nextLine();
        while (word.equals("exit") == false){
            wordSearch(lines, word);
            System.out.println("---\nEnter search word here: ");
            word = scanner.nextLine();
        }
    }
}
