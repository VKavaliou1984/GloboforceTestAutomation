import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowTest extends BaseTestClass {

    @DataProvider(name = "Pow test data")
    public Object[][] divData() {
        return new Object[][]{
                {1, 5, 1},
                {0, 3, 0},
                {1, 0, 1},
                {7, 3, 343},
                {4, 0.5, 2},
                {4, -2, 0.0625},
                {3.5, 2, 12.25},
                {3.5, 1.5, 6.5479004268544},
                {3.5, -0.5, 0.53452248382485}

        };
    }

    @Test(description = "Pow function check", dataProvider = "Pow test data")
    public void pow(double a, double b, double result) {
        double pow = calculator.pow(a,b);
        Assert.assertEquals(pow, result, "Result of pow isn't correct");
    }
}
