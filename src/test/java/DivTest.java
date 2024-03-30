import Dataproviders.ArithmeticalDataProvider;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest {

    Calculator calculator = CalculatorFactory.getCalculator();

    @Test(dataProvider = "longbasicdiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long div basic test",
            groups = {"Smoke, arithmetical"})
    public void testLongBasicDiv (long firstValue, long secondValue, long result){

        Long actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "longboundaryvaluesdiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long div boundary values test",
            groups = {"Critical path, arithmetical"})
    public void testLongBoundaryValuesDiv (long firstValue, long secondValue, long result){

        Long actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "longonzerodiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long div on zero test",
            groups = {"Critical path, arithmetical"},
            expectedExceptions = NumberFormatException.class
    )
    public void testLongOnZeroDiv (long firstValue, long secondValue){

        calculator.div(firstValue, secondValue);

    }

    @Test(dataProvider = "doublebasicdiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double div basic test",
            groups = {"Smoke, arithmetical"})
    public void testDoubleBasicDiv (double firstValue, double secondValue, double result){

        double actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "doubleboundaryvaluesdiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double boundary values basic test",
            groups = {"Critical path, arithmetical"})
    public void testDoubleBoundaryValuesDiv (double firstValue, double secondValue, double result){

        double actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    // there is a problem with zero and exceptions
    @Test(dataProvider = "doubleonzerodiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double div on zero test",
            groups = {"Critical path, arithmetical"}
            //expectedExceptions = NumberFormatException.class
    )
    public void testDoubleOnZeroDiv (double firstValue, double secondValue, double result){

        double actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);
    }
}
