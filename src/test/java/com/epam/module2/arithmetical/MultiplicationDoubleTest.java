package com.epam.module2.arithmetical;

import com.epam.module2.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationDoubleTest extends BaseTestClass {

    @DataProvider(name = "Multiplication double test data")
    public Object[][] multData() {
        return new Object[][]{
                {6, 2, 12},
                {"3", "0", "0"},
                {1.5, 1.5, 2.25},
                {"1.5", "-5", "-7.5"},
                {1.33, "1.22", "1.6226"}
        };
    }

    @Test(description = "Multiplication double function check",
            dataProvider = "Multiplication double test data")
    public void checkFunction(Object a, Object b, Object result) {
        double mult = calculator.mult(getDouble(a), getDouble(b));
        Assert.assertEquals(mult, getDouble(result), "Result of multiplication isn't correct");
    }
}



