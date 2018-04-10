import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeLongValueCheck extends BaseTestClass {

    @DataProvider(name = "Negative numbers")
    public Object[][] negData() {
        return new Object[][]{
                {-6, true},
                {0, false},
                {1, false},
                {"3", "false"}
        };
    }

    @Test (description = "Negative number check", dataProvider = "Negative numbers")
    public void negativeCheck (Object a, Object result) {
        long al = Long.parseLong(String.valueOf(a));
        boolean resultb = Boolean.parseBoolean(String.valueOf(result));
        boolean neg = calculator.isNegative(al);
        Assert.assertEquals(neg, resultb, "The number isn't negative");
    }
}

