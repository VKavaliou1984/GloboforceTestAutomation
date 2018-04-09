import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SumDoubleTest extends BaseTestClass {

        @Test(description = "Sum double function check")
        @Parameters({"ad","bd","result"})
        public void sum(double ad, double bd, double result) {
                double sum = calculator.sum(ad,bd);
                Assert.assertEquals(sum, result, "Result of sum isn't correct");
    }
}
