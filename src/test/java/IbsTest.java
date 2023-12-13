import org.example.AXIS;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class IbsTest {
    AXIS obj = new AXIS();
    @Test
    public void getBalanceTest() {
        float balance = obj.getBalance();
        Assertions.assertEquals(4000.0f, balance);
    }

    @Test
    public void depositMoneyTest()
    {
        obj.depositMoneyTest(5000.0f);
        Assertions.assertEquals(9000.0f,obj.balance);
    }
}
