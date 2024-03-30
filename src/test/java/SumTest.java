import Dataproviders.ArithmeticalDataProvider;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SumTest {

    Calculator calculator = CalculatorFactory.getCalculator();

    @BeforeSuite
    public void beforeSuite () {
        System.out.println("Suit test starts");
    };

    @AfterSuite
    public void afterSuite(){
        System.out.println("Suit tests ends");
    }



    @Test(dataProvider = "longbasicsum", dataProviderClass = ArithmeticalDataProvider.class, description = "Long sum method test",
    groups = {"Smoke, arithmetical"})
    public void testBasicLongSum (long firstValue, long secondValue, long result){

        Long actualResult = calculator.sum(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "longboundaryvaluessum", dataProviderClass = ArithmeticalDataProvider.class, description = "Long sum method test",
            groups = {"Critical path, arithmetical"})
    public void testBoundaryValuesLongSum (long firstValue, long secondValue, long result){

        Long actualResult = calculator.sum(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test (dataProvider = "doublebasicsum", dataProviderClass = ArithmeticalDataProvider.class, description = "Double sum method test",
    groups = {"Smoke, arithmetical"})
    public void testBasicDoubleSum(double firstValue, double secondValue, double result){

        Double actualResult = calculator.sum(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);
    }

    @Test (dataProvider = "doubleboundaryvaluessum", dataProviderClass = ArithmeticalDataProvider.class, description = "Double sum method test",
            groups = {"Critical path, arithmetical"})
    public void testBoundaryValuesDoubleSum(double firstValue, double secondValue, double result){

        Double actualResult = calculator.sum(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);
    }
}



