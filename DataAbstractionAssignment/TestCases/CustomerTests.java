import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CustomerTests {

    Customer emptyCustomer;
    Customer kylaCustomer;
    Customer hundredCustomer;
    Customer thousandCustomer;
    @Before
    public void setup() {
        emptyCustomer = new Customer();
        kylaCustomer = new Customer("Kyla", 1, 1);
        hundredCustomer = new Customer("Bill", 100.00, 100.00);
        thousandCustomer = new Customer("Steve", 1000, 1000);
    }

    @Test
    public void depositTests(){
        //Depositing positive value into empty customer
        assertEquals( 100, emptyCustomer.deposit(100, new Date(), "Checking"), 0.001);
        //Depositing negative value to test that the value does not change
        assertEquals(100, emptyCustomer.deposit(-100, new Date(), "Checking"), 0.001);
        //Checking that incorrect account spelling will not deposit
        assertEquals(0.0, emptyCustomer.deposit(100.0, new Date(), "checkig"), 0.001);

        //Depositing a positive value in kylaCustomer
        assertEquals(101, kylaCustomer.deposit(100, new Date(), "Checking"), 0.001);
        //Depositing negative value into kylaCustomer
        assertEquals(101, kylaCustomer.deposit(-100, new Date(), "Checking"), 0.001);
        //Depositing with misspelled account name
        assertEquals(0, kylaCustomer.deposit(100, new Date(), "Chocking"), 0.001);

        //Depositing positive value into empty customer
        assertEquals( 100, emptyCustomer.deposit(100, new Date(), "Saving"), 0.001);
        //Depositing negative value to test that the value does not change
        assertEquals(100, emptyCustomer.deposit(-100, new Date(), "Saving"), 0.001);
        //Checking that incorrect account spelling will not deposit
        assertEquals(0, emptyCustomer.deposit(100.0, new Date(), "Savig"), 0.001);

        //Depositing a positive value in kylaCustomer
        assertEquals(101, kylaCustomer.deposit(100, new Date(), "Saving"), 0.001);
        //Depositing negative value into kylaCustomer
        assertEquals(101, kylaCustomer.deposit(-100, new Date(), "Saving"), 0.001);
        //Depositing with misspelled account name
        assertEquals(0, kylaCustomer.deposit(100, new Date(), "Savig"), 0.001);
    }

    @Test
    public void withdrawTests(){
        //Test withdraw method for positive value
        assertEquals( 50, hundredCustomer.withdraw(50, new Date(), "Checking"), 0.001);
        //Withdrawing negative value to test that the value does not change
        assertEquals(50, hundredCustomer.withdraw(-100, new Date(), "Checking"), 0.001);
        //Checking that incorrect account spelling will not deposit
        assertEquals(0.0, hundredCustomer.withdraw(100.0, new Date(), "checkig"), 0.001);
        //Checking overdraft method
        assertEquals(50, hundredCustomer.withdraw(100, new Date(), "Checking"), 0.001);
        //Checking overdraft method beyond threshold
        assertEquals(50, hundredCustomer.withdraw(260, new Date(), "Checking"), 0.001);

        //Test withdraw method for positive value
        assertEquals( 900, thousandCustomer.withdraw(100, new Date(), "Checking"), 0.001);
        //Withdrawing negative value to test that the value does not change
        assertEquals(900, thousandCustomer.withdraw(-100, new Date(), "Checking"), 0.001);
        //Checking that incorrect account spelling will not deposit
        assertEquals(0.0, thousandCustomer.withdraw(100.0, new Date(), "checkig"), 0.001);
        //Checking overdraft method
        assertEquals(50, thousandCustomer.withdraw(950, new Date(), "Checking"), 0.001);
        //Checking overdraft method over threshold
        assertEquals(50, thousandCustomer.withdraw(1000, new Date(), "Checking"), 0.001);

        //Test withdraw method for positive value
        assertEquals( 50, hundredCustomer.withdraw(50, new Date(), "Saving"), 0.001);
        //Withdrawing negative value to test that the value does not change
        assertEquals(50, hundredCustomer.withdraw(-100, new Date(), "Saving"), 0.001);
        //Checking that incorrect account spelling will not deposit
        assertEquals(0.0, hundredCustomer.withdraw(100.0, new Date(), "savgib"), 0.001);
        //Checking overdraft method
        assertEquals(50, hundredCustomer.withdraw(150, new Date(), "Saving"), 0.001);
        //Checking overdraft method beyond threshold
        assertEquals(50, hundredCustomer.withdraw(1000, new Date(), "Saving"), 0.001);

        //Test withdraw method for positive value
        assertEquals( 900, thousandCustomer.withdraw(100, new Date(), "Saving"), 0.001);
        //Withdrawing negative value to test that the value does not change
        assertEquals(900, thousandCustomer.withdraw(-100, new Date(), "Saving"), 0.001);
        //Checking that incorrect account spelling will not deposit
        assertEquals(0.0, thousandCustomer.withdraw(100.0, new Date(), "savig"), 0.001);
        //Checking overdraft method
        assertEquals(50, thousandCustomer.withdraw(950, new Date(), "Saving"), 0.001);
        //Checking overdraft method over threshold
        assertEquals(50, thousandCustomer.withdraw(1000, new Date(), "Saving"), 0.001);
    }

    @Test
    public void depositToStringTests(){
        Date date = new Date();
        Deposit deposit1 = new Deposit(100, date, "checking");
        assertEquals("Deposit of $100.0 Date: " + date + " into account: checking", deposit1.toString());
        Deposit deposit2 = new Deposit(-100, date, "checking");
        assertEquals("Deposit of $-100.0 Date: " + date + " into account: checking", deposit2.toString());
        Deposit deposit3 = new Deposit(100, date, "saving");
        assertEquals("Deposit of $100.0 Date: " + date + " into account: saving", deposit3.toString());
        Deposit deposit4 = new Deposit(-100, date, "saving");
        assertEquals("Deposit of $-100.0 Date: " + date + " into account: saving", deposit4.toString());
    }

    @Test
    public void withdrawToStringTests(){
        Date date = new Date();
        Withdraw withdraw1 = new Withdraw(100, date, "checking");
        assertEquals("Withdraw of $" + 100.0 + " Date: " + date + " into account: checking", withdraw1.toString());
        Withdraw withdraw2 = new Withdraw(-100, date, "checking");
        assertEquals("Withdraw of $" + -100.0 + " Date: " + date + " into account: checking", withdraw2.toString());
        Withdraw withdraw3 = new Withdraw(100, date, "saving");
        assertEquals("Withdraw of $" + 100.0 + " Date: " + date + " into account: saving", withdraw3.toString());
        Withdraw withdraw4 = new Withdraw(-100, date, "saving");
        assertEquals("Withdraw of $" + -100.0 + " Date: " + date + " into account: saving", withdraw4.toString());
    }
}
