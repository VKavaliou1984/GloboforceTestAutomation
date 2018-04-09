import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeLongValueCheck extends BaseTestClass {

    @DataProvider(name = "Multiplication double test data")
    public Object[][] divData() {
        return new Object[][]{
                {6.0, 2.5, 15.0},
                {3.0, 0.0, 0.0},
                {1.5,1.5,2.25},
                {6.0,3.0,18.0}
        };
    }

    @Test(description = "Multiplication function check", dataProvider = "Multiplication double test data")
    public void multiplication(double a, double b, long result) {
        double mult = calculator.mult(a,b);
        Assert.assertEquals(mult, result, "Result of multiplication isn't correct");
    }
    }
