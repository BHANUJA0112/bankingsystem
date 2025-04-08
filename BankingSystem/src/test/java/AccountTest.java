import com.example.bankingsystem.Account;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = new Account();
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance(), 0.01);
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        account.deposit(100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.01);
    }

    @Test
    public void testInvalidWithdrawal() {
        account.deposit(50.0);
        account.withdraw(100.0);
        assertEquals(50.0, account.getBalance(), 0.01);
    }

    @Test
    public void testZeroBalance() {
        assertEquals(0.0, account.getBalance(), 0.01);
    }
}
