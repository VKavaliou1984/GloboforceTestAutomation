import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveLongValueCheck extends BaseTestClass {

    @DataProvider(name = "Positive numbers")
    public Object[][] posData() {
        return new Object[][]{
                {6, true},
                {0, false},
                {-1, false},
                {"0", "false"},
                {"5", "true"},
                {"-5",""}
        };
    }

        @Test (description = "Positive number check", dataProvider = "Positive numbers")
        public void positiveCheck (Object a, Object result) {
            long al = Long.parseLong(String.valueOf(a));
            boolean resultb = Boolean.parseBoolean(String.valueOf(result));
            boolean pos = calculator.isPositive(al);
            Assert.assertEquals(pos, resultb, "The number isn't positive");
        }
    }
