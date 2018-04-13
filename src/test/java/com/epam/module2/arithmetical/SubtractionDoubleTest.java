package com.epam.module2.arithmetical;

import com.epam.module2.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SubtractionDoubleTest extends BaseTestClass {

    @Test(description = "Subtraction double function check")
    @Parameters({"ad", "bd", "result"})
    public void sub(@Optional("2") double ad, @Optional("2") double bd, @Optional("0") Double result) {
        double sub = calculator.sub(ad, bd);
        Assert.assertEquals(sub, result, "Result of substraction isn't correct");
    }
}
