package Functionaltests.Arithmetical;

import Dataproviders.ArithmeticalDataProvider;
import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class SqrtTest {

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
