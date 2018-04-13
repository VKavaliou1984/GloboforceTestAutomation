import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {
    protected Calculator calculator;

    @BeforeClass(alwaysRun = true)
    public void initCalculator() {
        calculator = new Calculator();
    }

    @BeforeSuite
    public void printStartInfoMessage() {
        System.out.println("Testing is in progress");
    }

    @AfterSuite
    public void printFinishInfoMessage() {
        System.out.println("Testing is finished");
    }

    double getDouble(Object object) {
        return Double.parseDouble(String.valueOf(object));
    }

    long getLong(Object object) {
        return Long.parseLong(String.valueOf(object));
    }
}
