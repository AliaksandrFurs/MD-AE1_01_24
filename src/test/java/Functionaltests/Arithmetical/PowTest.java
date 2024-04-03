package Functionaltests.Arithmetical;

import Dataproviders.ArithmeticalDataProvider;
import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class PowTest {

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

    @Test(dataProvider = "doublebasicpow", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double pow basic test",
            groups = {"smoke", "arithmetical"})
    public void testDoubleBasicPow (double firstValue, double secondValue, double result){

        double actualResult = calculator.pow(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "doubleboundaryvaluespow", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double pow boundary values test",
            groups = {"critical path", "arithmetical"})
    public void testDoubleBoundaryValuesPow (double firstValue, double secondValue, double result){

        double actualResult = calculator.pow(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }
}
