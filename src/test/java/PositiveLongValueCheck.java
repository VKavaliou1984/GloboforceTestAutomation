import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveLongValueCheck extends BaseTestClass {

    @DataProvider(name = "Positive numbers")
    public Object[][] divData() {
        return new Object[][]{
                {6, true},
                {0, false},
                {-1, false}
        };
    }

        @Test (description = "Positive number check", dataProvider = "Positive numbers")
        public void positiveCheck (long a, boolean result) {
            boolean pos = calculator.isPositive(a);
            Assert.assertEquals(pos, result, "The number isn't positive");
        }
    }
