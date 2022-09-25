import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables
        int strindex = 0;
        char removed =0;
        String newstr = "";

        Scanner scan = new Scanner(System.in);

        //A string is taken
        String str = scan.next();

        //String index is found
        strindex = str.length();

        //Removed: the last character of the original string is assigned to a variable by selecting the character at index-1
        removed = str.charAt((strindex-1));

        //The original string is modified so the last character is removed
        StringBuilder strmod = new StringBuilder(str);
        strmod.deleteCharAt((strindex-1));
        //Character is made into a string so it can be combined with the modified version of the original string
        String removedstr = new Character(removed).toString();

        //New string that has last character moved to the beginning of the string and adds "ay" to the end
        newstr = removedstr + strmod + "ay";
        System.out.println(newstr);
        
        //******//
        //Undoing of the encryption//
        
        int undostrindex = newstr.length();
        
        StringBuilder undostr = new StringBuilder(newstr);
        undostr.deleteCharAt(undostrindex-1);
        undostr.deleteCharAt(undostrindex-2);
        undostr.deleteCharAt(0);

        String finalstr = undostr + removedstr;
        System.out.println(finalstr);
    }
}
