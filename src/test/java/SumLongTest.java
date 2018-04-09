import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SumLongTest extends BaseTestClass {

        @Test(description = "Sum function check")
        @Parameters({"a","b","result"})
        public void sum(long a, long b, long result) {
        long sum = calculator.sum(a,b);
        Assert.assertEquals(sum, result, "Result of sum isn't correct");
    }
}
