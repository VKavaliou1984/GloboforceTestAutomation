import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosineTest extends BaseTestClass {

    @DataProvider(name = "Cosine test data")
    public Object[][] divData() {
        return new Object[][]{
                {0, 1},
                {1, 0.54030230586},
                {Math.PI, -1},
                {Math.PI / 2, 0},
                {"0", "1"}
        };
    }

    @Test(description = "Cosine function check", dataProvider = "Cosine test data")
    public void cosine(Object a, Object result) {
        double cos = calculator.cos(getDouble(a));
        Assert.assertEquals(cos, getDouble(result), "Cosine of the number isn't correct");
    }
}
