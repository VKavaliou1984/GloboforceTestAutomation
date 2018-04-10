import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowTest extends BaseTestClass {

    @DataProvider(name = "Pow test data")
    public Object[][] powData() {
        return new Object[][]{
                {1, 5, 1},
                {0, 3, "0"},
                {"1", 0, 1},
                {7, "3", 343},
                {4, 0.5, 2},
                {4, -2, 0.0625},
                {3.5, 2, 12.25},
                {3.5, 1.5, 6.5479004268544},
                {"3.5", "-0.5", "0.53452248382485"}

        };
    }

    @Test(description = "Pow function check", dataProvider = "Pow test data")
    public void pow(Object a, Object b, Object result) {
        double ad = Double.parseDouble(String.valueOf(a));
        double bd = Double.parseDouble(String.valueOf(b));
        double resultd = Double.parseDouble(String.valueOf(result));
        double pow = calculator.pow(ad,bd);
        Assert.assertEquals(pow, resultd, "Result of pow isn't correct");
    }
}
