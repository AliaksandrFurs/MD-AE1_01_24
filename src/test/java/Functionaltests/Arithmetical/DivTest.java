package Functionaltests.Arithmetical;

import Dataproviders.ArithmeticalDataProvider;
import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class DivTest {

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

    @Test(dataProvider = "longbasicdiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long div basic test",
            groups = {"smoke", "arithmetical"},
            priority = 0)
    public void testLongBasicDiv (long firstValue, long secondValue, long result){

        Long actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "longboundaryvaluesdiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long div boundary values test",
            groups = {"Critical path", "arithmetical"},
            priority = 1)
    public void testLongBoundaryValuesDiv (long firstValue, long secondValue, long result){

        Long actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "longonzerodiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long div on zero test",
            groups = {"Critical path", "arithmetical"},
            expectedExceptions = NumberFormatException.class,
            priority = 2)
    public void testLongOnZeroDiv (long firstValue, long secondValue){

        calculator.div(firstValue, secondValue);

    }

    @Test(dataProvider = "doublebasicdiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double div basic test",
            groups = {"smoke", "arithmetical"},
            priority = 3)
    public void testDoubleBasicDiv (double firstValue, double secondValue, double result){

        double actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "doubleboundaryvaluesdiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double boundary values basic test",
            groups = {"critical path", "arithmetical"},
            priority = 4)
    public void testDoubleBoundaryValuesDiv (double firstValue, double secondValue, double result){

        double actualResult = calculator.div(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "doubleonzerodiv", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double div on zero test",
            groups = {"critical path", "arithmetical"}
    )
    public void testDoubleOnZeroDiv (double firstValue, double secondValue){
        try {
            calculator.div(firstValue, secondValue);
        }catch(NumberFormatException e){

        }
    }
}
