import Dataproviders.ArithmeticalDataProvider;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtTest {

    Calculator calculator = CalculatorFactory.getCalculator();

    @Test(dataProvider = "doublebasicsqrt", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double sqrt basic test",
            groups = {"Smoke, arithmetical"})
    public void testBasicSqrt(double firstValue, double result){

        double actualResult = calculator.sqrt(firstValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "doubleboundaryvaluessqrt", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double sqrt boundary values test",
            groups = {"Critical path, arithmetical"})
    public void testBoundaryValuesSqrt(double firstValue, double result){

        double actualResult = calculator.sqrt(firstValue);
        Assert.assertEquals(actualResult, result);

    }
}
