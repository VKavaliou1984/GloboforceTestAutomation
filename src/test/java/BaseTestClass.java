import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {
    protected Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void initCalculator() {
        calculator = new Calculator();
    }
}
