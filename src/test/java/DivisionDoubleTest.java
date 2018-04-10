import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DivisionDoubleTest extends BaseTestClass {

    @DataProvider(name = "Division double test data")
    public Object[][] divData() {
        return new Object[][]{
                {6, 2, 3},
                {0, 3.5, 0},
                {6.5, 2, 3.25},
                {"6.5", "2", "3.25"},
                {3.125, 2.5, 1.25},
                {"-3.125", "2.5", "-1.25"}
        };
    }

    @DataProvider(name = "Division double exception test data")
    public Object[][] divException() {
        return new Object[][]{
                {2, 0},
                {"2", "0"},
                {0, 0}
        };
    }

    @Test(description = "Division double function check", dataProvider = "Division double test data")
    public void divisionDouble(Object a, Object b, Object result) {
        double divDouble = calculator.div(getDouble(a), getDouble(b));
        Assert.assertEquals(divDouble, getDouble(result), "Result of division isn't correct");
    }

    /**
     * There is no the no division by zero check for double
     */
    @Test(description = "Division by zero check", expectedExceptions = NumberFormatException.class, expectedExceptionsMessageRegExp = "Attempt to divide by zero", dataProvider = "Division double exception test data", groups = "exception")
    public void divisionByZeroException(Object a, Object b) {
        calculator.div(getDouble(a), getDouble(b));
    }
}
