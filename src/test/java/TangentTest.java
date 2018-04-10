import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TangentTest extends BaseTestClass {


    @DataProvider(name = "Tangent test data")
    public Object[][] tangData() {
        return new Object[][]{
                {"0", "0"},
                {2*Math.PI, 0},
                {3*Math.PI/4,-1},
                {5*Math.PI/4,"1"},
                {Math.PI,0},
        };
    }

    @Test(description = "Tangent function check", dataProvider = "Tangent test data")
    public void tangent(Object a, Object result) {
        double ad = Double.parseDouble(String.valueOf(a));
        double resultd = Double.parseDouble(String.valueOf(result));
        double tang = calculator.tg(ad);
        Assert.assertEquals(tang, resultd, "Tangent of the number isn't correct");
    }
}
