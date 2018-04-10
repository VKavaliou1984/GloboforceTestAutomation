import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SumDoubleTest extends BaseTestClass {

        @Test(description = "Sum double function check")
        @Parameters({"ad","bd","result"})
        public void sum(@Optional ("0") double ad, @Optional ("0") double bd, @Optional ("0") double result) {
                double sum = calculator.sum(ad,bd);
                Assert.assertEquals(sum, result, "Result of sum isn't correct");
    }
}
