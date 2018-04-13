import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CotangentTest extends BaseTestClass {

    @DataProvider(name = "Cotangent test data")
    public Object[][] ctgData() {
        return new Object[][]{
                {Math.PI / 4, 1},
                {Math.PI / 2, 0},
                {3 * Math.PI / 4, -1}
        };
    }

    @Test(description = "Cotangent function check", dataProvider = "Cotangent test data")
    public void cotangent(Object a, Object result) {
        double ctg = calculator.ctg(getDouble(a));
        Assert.assertEquals(ctg, getDouble(result), "Cotangent of the number isn't correct");
    }
}
