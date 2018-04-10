import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SubtractionLongTest extends BaseTestClass {

    @Test(description = "Subtraction function check")
    @Parameters ({"a","b","result"})
    public void sub(@Optional("1") long a, @Optional ("2") long b, @Optional ("-1") long result) {
        long sub = calculator.sub(a,b);
        Assert.assertEquals(sub, result, "Result of substraction isn't correct");
    }
}
