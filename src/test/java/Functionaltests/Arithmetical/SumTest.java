package Functionaltests.Arithmetical;

import Dataproviders.ArithmeticalDataProvider;
import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class SumTest {

    Calculator calculator = CalculatorFactory.getCalculator();

    @BeforeSuite
    public void beforeSuite () {
        System.out.println("Suit test starts" + "\n");
    };

    @AfterSuite
    public void afterSuite(){
        System.out.println("Suit tests ends" + "\n");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Class tests starts: " + this.getClass() );
    }

    @AfterClass
    public void afterClass (){
        System.out.println("Class tests ends: " + this.getClass() );
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        Test test = method.getAnnotation(Test.class);
        System.out.println(test.description() + " starts" + "\n");
    }

    @AfterMethod
    public void afterMethod(Method method){
        Test test = method.getAnnotation(Test.class);
        System.out.println( test.description() + " finished" + "\n");
    }



    @Test(dataProvider = "longbasicsum", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long sum method test",
            groups = {"smoke", "arithmetical"})
    public void testBasicLongSum (long firstValue, long secondValue, long result){

        Long actualResult = calculator.sum(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "longboundaryvaluessum", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long sum method test",
            groups = {"critical path", "arithmetical"})
    public void testBoundaryValuesLongSum (long firstValue, long secondValue, long result){

        Long actualResult = calculator.sum(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test (dataProvider = "doublebasicsum", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double sum method test",
            groups = {"critical path", "arithmetical"})
    public void testBasicDoubleSum(double firstValue, double secondValue, double result){

        Double actualResult = calculator.sum(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);
    }

    @Test (dataProvider = "doubleboundaryvaluessum", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double sum method test",
            groups = {"critical path", "arithmetical"})
    public void testBoundaryValuesDoubleSum(double firstValue, double secondValue, double result){

        Double actualResult = calculator.sum(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);
    }
}



