import com.example.bankingsystem.Account;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
    private Bank bank;
    private Account account1;
    private Account account2;

    @Before
    public void setUp() {
        bank = new Bank();
        account1 = new Account(100.0);
        account2 = new Account(50.0);
        bank.addAccount(account1);
        bank.addAccount(account2);
    }

    @Test
    public void testValidTransfer() {
        assertTrue(bank.transfer(0, 1, 50.0));
        assertEquals(50.0, account1.getBalance(), 0.01);
        assertEquals(100.0, account2.getBalance(), 0.01);
    }

    @Test
    public void testInvalidTransfer() {
        assertFalse(bank.transfer(0, 1, 150.0));
        assertEquals(100.0, account1.getBalance(), 0.01);
        assertEquals(50.0, account2.getBalance(), 0.01);
    }

    @Test
    public void testInsufficientFunds() {
        assertFalse(bank.transfer(1, 0, 60.0));
        assertEquals(50.0, account2.getBalance(), 0.01);
    }
}
