import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationLongTest extends BaseTestClass {

    @DataProvider(name = "Multiplication test data")
    public Object[][] divData() {
        return new Object[][]{
                {6, 2, 12},
                {3, 0, 0}
        };
    }

    @Test(description = "Multiplication function check", dataProvider = "Multiplication test data")
    public void multiplication(long a, long b, long result) {
        long mult = calculator.mult(a,b);
        Assert.assertEquals(mult, result, "Result of multiplication isn't correct");
    }
}
