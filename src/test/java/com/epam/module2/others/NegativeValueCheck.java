package com.epam.module2.others;

import com.epam.module2.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeValueCheck extends BaseTestClass {

    @DataProvider(name = "Negative numbers")
    public Object[][] negData() {
        return new Object[][]{
                {-6, true},
                {0, false},
                {1, false}
        };
    }

    @Test(description = "Negative number check",
            dataProvider = "Negative numbers")
    public void negativeCheck(Object a, Object result) {
        boolean neg = calculator.isNegative(getLong(a));
        Assert.assertEquals(neg, result, "The number isn't negative");
    }
}

