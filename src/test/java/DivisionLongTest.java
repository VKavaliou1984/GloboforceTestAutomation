import org.testng.Assert;
import org.testng.annotations.*;


public class DivisionLongTest extends BaseTestClass {

    @DataProvider(name = "Division test data")
    public Object[][] divData() {
        return new Object[][]{
                {6, 2, 3},
                {0, 3, 0}
        };
    }

    @DataProvider(name = "Division exception test data")
    public Object[][] divException() {
        return new Object[][]{
                {2,0},
                {0,0}
        };
    }

    @Test(description = "Division function check", dataProvider = "Division test data")
    public void division(long a, long b, long result) {
        long div = calculator.div(a, b);
        Assert.assertEquals(div, result, "Result of division isn't correct");
    }


    @Test(description = "Division by zero check", expectedExceptions = NumberFormatException.class, expectedExceptionsMessageRegExp = "Attempt to divide by zero", dataProvider = "Division exception test data", groups = "Exceptions")
    public void divisionByZeroException(long a, long b) {
        calculator.div(a, b);
    }
}
