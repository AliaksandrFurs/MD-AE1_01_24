package Functionaltests.Arithmetical;

import Dataproviders.ArithmeticalDataProvider;
import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultTest {

    Calculator calculator = CalculatorFactory.getCalculator();

    @Test(dataProvider = "longbasicmult", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long mult basic test",
            groups = {"smoke", "arithmetical"})
    public void testLongBasicMult (long firstValue, long secondValue, long result){

        Long actualResult = calculator.mult(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "longboundaryvaluesmult", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long mult boundary values test",
            groups = {"critical path", "arithmetical"})
    public void testLongBoundaryValuesMult (long firstValue, long secondValue, long result){

        Long actualResult = calculator.mult(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "doublebasicmult", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double mult basic test",
            groups = {"critical path", "arithmetical"})
    public void testDoubleBasicMult (double firstValue, double secondValue, double result){

        Double actualResult = calculator.mult(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "doubleboundaryvaluesmult", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double mult boundary values test",
            groups = {"critical path", "arithmetical"})
    public void testDoubleBoundaryValuesMult (double firstValue, double secondValue, double result){

        Double actualResult = calculator.mult(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }
}
