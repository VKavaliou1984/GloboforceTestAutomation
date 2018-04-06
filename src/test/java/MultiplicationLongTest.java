import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiplicationLongTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void initCalculator() {
        calculator = new Calculator();
    }

    @Test(description = "Multiplication function check")
    @Parameters({"a","b","result"})
    public void sum(long a, long b, long result) {
        long mult = calculator.mult(a,b);
        Assert.assertEquals(mult, result, "Result of sum is correct");
    }
}
