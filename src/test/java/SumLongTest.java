import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SumLongTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void initCalculator() {
        calculator = new Calculator();
    }

        @Test(description = "Sum function check")
        @Parameters({"a","b","result"})
        public void sum(long a, long b, long result) {
        long sum = calculator.sum(a,b);
        Assert.assertEquals(sum, result, "Result of sum is correct");
    }
}
