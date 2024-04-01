package Functionaltests.Arithmetical;

import Dataproviders.ArithmeticalDataProvider;
import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SqrtTest {

    Calculator calculator = CalculatorFactory.getCalculator();

    @Test(dataProvider = "doublebasicsqrt", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double sqrt basic test",
            groups = {"smoke", "arithmetical"})
    public void testBasicSqrt(double firstValue, double result){

        double actualResult = calculator.sqrt(firstValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "doubleboundaryvaluessqrt", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double sqrt boundary values test",
            groups = {"critical path", "arithmetical"})
    public void testBoundaryValuesSqrt(double firstValue, double result){

        double actualResult = calculator.sqrt(firstValue);
        Assert.assertEquals(actualResult, result);

    }
}
