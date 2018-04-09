import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtTest extends BaseTestClass {

    @DataProvider(name = "Square root test data")
    public Object[][] divData() {
        return new Object[][]{
                {81, 9},
                {0, 0},
                {1, 1},
                {0.5, 0.7071067811865476},
                {2, 1.4142135623730951}
        };
    }

    @Test(description = "Square root of a number function check", dataProvider = "Square root test data")
    public void sqrt(double a, double result) {
        double sqrt = calculator.sqrt(a);
        Assert.assertEquals(sqrt, result, "Square root of the number isn't correct");
    }
}
