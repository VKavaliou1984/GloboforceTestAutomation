import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SubstractionLongTest {
    private Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void initCalculator() {
        calculator = new Calculator();
    }

    @Test(description = "Substraction function check")
    @Parameters ({"a","b","result"})
    public void sum(long a, long b, long result) {
        long sub = calculator.sub(a,b);
        Assert.assertEquals(sub, result, "Result of substraction is correct");
    }
}
