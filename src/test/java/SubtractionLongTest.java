import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SubtractionLongTest extends BaseTestClass {

    @Test(description = "Subtraction function check")
    @Parameters ({"a","b","result"})
    public void sum(long a, long b, long result) {
        long sub = calculator.sub(a,b);
        Assert.assertEquals(sub, result, "Result of substraction isn't correct");
    }
}
