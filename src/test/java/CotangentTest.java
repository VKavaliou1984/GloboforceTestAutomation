import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CotangentTest extends BaseTestClass {

    @DataProvider(name = "Cotangent test data")
    public Object[][] divData() {
        return new Object[][]{
                {Math.PI/4, 1},
                {Math.PI/2, 0},
                {3*Math.PI/4, -1}
        };
    }

    @Test(description = "Cotangent function check", dataProvider = "Cotangent test data")
    public void cotangent(double a, double result) {
        double ctg = calculator.ctg(a);
        Assert.assertEquals(ctg, result, "Cotangent of the number isn't correct");
    }
}
