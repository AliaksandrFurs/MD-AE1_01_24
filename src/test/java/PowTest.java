import Dataproviders.ArithmeticalDataProvider;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PowTest {

    Calculator calculator = CalculatorFactory.getCalculator();

    @Test(dataProvider = "doublebasicpow", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double pow basic test",
            groups = {"Smoke, arithmetical"})
    public void testDoubleBasicPow (double firstValue, double secondValue, double result){

        double actualResult = calculator.pow(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "doubleboundaryvaluespow", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double pow boundary values test",
            groups = {"Smoke, arithmetical"})
    public void testDoubleBoundaryValuesPow (double firstValue, double secondValue, double result){

        double actualResult = calculator.pow(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }
}
