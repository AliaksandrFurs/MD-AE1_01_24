package Functionaltests.Others;

import Dataproviders.PositiveDataProvider;
import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IsPositiveTest {

    Calculator calculator = CalculatorFactory.getCalculator();

    @Test(dataProvider = "ispositive", dataProviderClass = PositiveDataProvider.class,
            description = "Positive long basic test",
            groups = {"critical path", "other"})
    public void isPositiveTest(long value, boolean expectedResult){

        Assert.assertEquals(calculator.isPositive(value), expectedResult);

    }

    @Test(dataProvider = "isnegative", dataProviderClass = PositiveDataProvider.class,
            description = "Positive long basic test",
            groups = {"critical path", "other"})
    public void isNegativeTest(long value, boolean expectedResult){

        Assert.assertEquals(calculator.isNegative(value), expectedResult);

    }

}
