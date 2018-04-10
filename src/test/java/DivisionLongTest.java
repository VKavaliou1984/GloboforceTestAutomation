import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DivisionLongTest extends BaseTestClass {

    @DataProvider(name = "Division test data")
    public Object[][] divData() {
        return new Object[][]{
                {6, 2, 3},
                {0, 3, 0},
                {"-1", "1", "-1"}
        };
    }

    @DataProvider(name = "Division exception test data")
    public Object[][] divException() {
        return new Object[][]{
                {2, 0},
                {0, 0},
                {"0", "0"}
        };
    }

    @Test(description = "Division function check", dataProvider = "Division test data")
    public void division(Object a, Object b, Object result) {
        long div = calculator.div(getLong(a), getLong(b));
        Assert.assertEquals(div, getLong(result), "Result of division isn't correct");
    }


    @Test(description = "Division by zero check", expectedExceptions = NumberFormatException.class, expectedExceptionsMessageRegExp = "Attempt to divide by zero", dataProvider = "Division exception test data", groups = "exception")
    public void divisionByZeroException(Object a, Object b) {
        calculator.div(getLong(a), getLong(b));
    }
}
