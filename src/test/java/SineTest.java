import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SineTest extends BaseTestClass {


    @DataProvider(name = "Sine test data")
    public Object[][] sinData() {
        return new Object[][]{
                {"0",0},
                {"1", "0.8414709848078965"},
                {Math.PI, 1.2246467991473532E-16},
                {Math.PI/2, 1},
                {-2*Math.PI,2.4492935982947064E-16}
        };
    }

    @Test(description = "Sine function check", dataProvider = "Sine test data")
    public void sine(Object a, Object result) {
        double ad = Double.parseDouble(String.valueOf(a));
        double resultd = Double.parseDouble(String.valueOf(result));
        double sin = calculator.sin(ad);
        Assert.assertEquals(sin, resultd, "Sine of the number isn't correct");
    }
}
