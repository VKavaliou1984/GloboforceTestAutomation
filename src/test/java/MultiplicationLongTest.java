import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationLongTest extends BaseTestClass {

    @DataProvider(name = "Multiplication test data")
    public Object[][] multData() {
        return new Object[][]{
                {6, 2, 12},
                {-3, 0, 0},
                {-6, -3, 18},
                {-6, 3, -18},
                {"-5", "3", "-15"}
        };
    }

    @Test(description = "Multiplication function check", dataProvider = "Multiplication test data")
    public void multiplication(Object a, Object b, Object result) {
        long al = Long.parseLong(String.valueOf(a));
        long bl = Long.parseLong(String.valueOf(b));
        long resultl = Long.parseLong(String.valueOf(result));
        long mult = calculator.mult(al,bl);
        Assert.assertEquals(mult, resultl, "Result of multiplication isn't correct");
    }
}
