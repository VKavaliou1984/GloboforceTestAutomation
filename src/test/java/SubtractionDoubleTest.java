import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SubtractionDoubleTest extends BaseTestClass {

    @Test(description = "Subtraction double function check")
    @Parameters ({"ad","bd","result"})
    public void sum(double ad, double bd, double result) {
        double sub = calculator.sub(ad,bd);
        Assert.assertEquals(sub, result, "Result of substraction isn't correct");
    }
}
