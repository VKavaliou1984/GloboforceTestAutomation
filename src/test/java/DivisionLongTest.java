import org.testng.Assert;
import org.testng.annotations.*;


public class DivisionLongTest extends BaseTestClass {

    @DataProvider(name = "Division test data")
    public Object[][] divData() {
        return new Object[][]{
                {6, 2, 3},
                {0, 3, 0},
                {"-1","1","-1"}
        };
    }

    @DataProvider(name = "Division exception test data")
    public Object[][] divException() {
        return new Object[][]{
                {2,0},
                {0,0},
                {"0","0"}
        };
    }

    @Test(description = "Division function check", dataProvider = "Division test data")
    public void division(Object a, Object b, Object result) {
        long al = Long.parseLong(String.valueOf(a));
        long bl = Long.parseLong(String.valueOf(b));
        long resultl = Long.parseLong(String.valueOf(result));
        long div = calculator.div(al, bl);
        Assert.assertEquals(div, resultl, "Result of division isn't correct");
    }


    @Test(description = "Division by zero check", expectedExceptions = NumberFormatException.class, expectedExceptionsMessageRegExp = "Attempt to divide by zero", dataProvider = "Division exception test data", groups = "exception")
    public void divisionByZeroException(Object a, Object b) {
        long al = Long.parseLong(String.valueOf(a));
        long bl = Long.parseLong(String.valueOf(b));
        calculator.div(al, bl);
    }
}
