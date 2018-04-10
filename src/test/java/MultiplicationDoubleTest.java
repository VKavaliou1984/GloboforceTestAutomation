import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationDoubleTest extends BaseTestClass {

    @DataProvider(name = "Multiplication double test data")
    public Object[][] multData() {
        return new Object[][]{
                {6, 2, 12},
                {"3", "0", "0"},
                {1.5, 1.5, 2.25},
                {"1.5", "-5", "-7.5"}
        };
    }

    @Test(description = "Multiplication double function check", dataProvider = "Multiplication double test data")
    public void checkFunction(Object a, Object b, Object result) {
        double ad = Double.parseDouble(String.valueOf(a));
        double bd = Double.parseDouble(String.valueOf(b));
        double resultd = Double.parseDouble(String.valueOf(result));
        double mult = calculator.mult(ad,bd);
        Assert.assertEquals(mult, resultd, "Result of multiplication isn't correct");
    }
}
