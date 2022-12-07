import javax.security.sasl.SaslClient;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    static int allAccountNum = 1;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        accountNumber = allAccountNum;
        allAccountNum++;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        checkBalance = 0;
        savingBalance = 0;
        savingRate = 0;
        name = "";

    }
    Customer(String name, double checkDeposit, double savingDeposit){
        //Requires: String, int, double
        //Modifies: this
        //Effects: Takes in and sets values for customer class fields
        this.accountNumber = allAccountNum;
        allAccountNum++;
        this.name = name;
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        checkBalance = checkDeposit;
        savingBalance = savingDeposit;
        savingRate = 0;

    }

    public double deposit(double amt, Date date, String account) {
        //Requires: double, date, String
        //Modifies: Customer
        //Effects: Changes value of checkBalance or savingBalance, creates new deposit
        if (account.equals(CHECKING)){
            if (amt < 0) {
                System.out.println("Negative values are not permitted, please enter a valid amount.");
                return checkBalance;
            }
            else{
                return checkBalance += amt;
            }

        }
        if (account.equals(SAVING)){
            if (amt < 0) {
                System.out.println("Negative values are not permitted, please enter a valid amount.");
                return savingBalance;
            }
            else{
                return savingBalance += amt;
            }
        }
        deposits.add(new Deposit(amt, date, account));
        return 0;
    }

    public double withdraw(double amt, Date date, String account){
        //Requires: double, date, string
        //Modifies: Customer
        //Effects: Removes withdrawn amount from specified account unless it is outside of
        if (account.equals(CHECKING)) {
            if (amt < 0){
                System.out.println("Negative values are not permitted, please enter a valid amount.");
                return checkBalance;
            }
            if (amt > checkBalance && checkOverdraft(amt, account) == false){
                System.out.println("Insufficient funds. Please withdraw amount within " + (checkBalance - OVERDRAFT) + ".");
                return checkBalance;
            }
            if (amt > checkBalance && checkOverdraft(amt, account) == true){
                checkBalance = checkBalance - amt + 100;
                return checkBalance;
            }
            else {
                checkBalance -= amt;
                return checkBalance;
            }
        }
        if (account.equals(SAVING)){
            if (amt < 0){
                System.out.println("Negative values are not permitted, please enter a valid amount.");
                return savingBalance;
            }
            if (amt > savingBalance && checkOverdraft(amt, account) == false){
                System.out.println("Insufficient funds. Please withdraw amount within " + (savingBalance - OVERDRAFT) + ".");
                return savingBalance;
            }
            if (amt > savingBalance && checkOverdraft(amt, account) == true) {
                savingBalance = savingBalance - amt + 100;
                return savingBalance;
            }
            else {
                savingBalance -= amt;
                return savingBalance;
            }
        }
        withdraws.add(new Withdraw(amt, date, account));
        return 0;
    }
    private boolean checkOverdraft(double amt, String account) {
        if (account.equals(SAVING)) {
            if (savingBalance - amt <= OVERDRAFT) {
                return false;
            }
            else {
                return true;
            }
        }
        if (account.equals(CHECKING)){
            if ((checkBalance-amt) <= OVERDRAFT){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return true;
        }
    }

    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
