package com.epam.module2.others;

import com.epam.module2.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveValueCheck extends BaseTestClass {

    @DataProvider(name = "Positive numbers")
    public Object[][] posData() {
        return new Object[][]{
                {6, true},
                {"0", false},
                {-1, false},
                {"1", true}
        };
    }

    @Test(description = "Positive number check",
            dataProvider = "Positive numbers")
    public void positiveCheck(Object a, Object result) {
        boolean pos = calculator.isPositive(getLong(a));
        Assert.assertEquals(pos, result, "The number isn't positive");
    }
}
