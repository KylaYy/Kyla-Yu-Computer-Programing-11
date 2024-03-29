import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        //Requires: double, Date, String
        //Modifies: Customer
        //Effects: Creates new withdraw object
        this.amount = amount;
        this.date = date;
        this.account = account;
        }

    public String toString(){
        return "Withdraw of $" + amount + " Date: " + date + " into account: " + account;
    }
}
