import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TangentTest extends BaseTestClass {


    @DataProvider(name = "Tangent test data")
    public Object[][] divData() {
        return new Object[][]{
                {0, 0},
                {2*Math.PI, 0},
                {3*Math.PI/4,-1},
                {5*Math.PI/4,1},
                {Math.PI,0},
        };
    }

    @Test(description = "Tangent function check", dataProvider = "Tangent test data")
    public void tangent(double a, double result) {
        double tang = calculator.tg(a);
        Assert.assertEquals(tang, result, "Tangent of the number isn't correct");
    }
}
