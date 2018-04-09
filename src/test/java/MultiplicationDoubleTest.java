import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationDoubleTest extends BaseTestClass {

    @DataProvider(name = "Multiplication double test data")
    public Object[][] divData() {
        return new Object[][]{
                {6, 2, 12},
                {3, 0, 0},
                {1.5, 1.5, 2.25},
                {1.5, 5, 7.5}
        };
    }

    @Test(description = "Multiplication double function check", dataProvider = "Multiplication double test data")
    public void multiplication(double a, double b, double result) {
        double mult = calculator.mult(a,b);
        Assert.assertEquals(mult, result, "Result of multiplication isn't correct");
    }
}
