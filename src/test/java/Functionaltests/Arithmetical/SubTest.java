package Functionaltests.Arithmetical;

import Dataproviders.ArithmeticalDataProvider;
import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class SubTest {

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

    @Test(dataProvider = "longbasicsub", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long sub basic test",
            groups = {"smoke", "arithmetical"})
    public void testLongBasicSub (long firstValue, long secondValue, long result){

        Long actualResult = calculator.sub(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test(dataProvider = "longboundaryvaluessub", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Long sub boundary values test",
            groups = {"critical path", "arithmetical"})
    public void testLongBoundaryValuesSub (long firstValue, long secondValue, long result){

        Long actualResult = calculator.sub(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);

    }

    @Test (dataProvider = "doublebasicsub", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double sub basic test",
            groups = {"smoke", "arithmetical"})
    public void testDoubleBasicSub(double firstValue, double secondValue, double result){

        Double actualResult = calculator.sub(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);
    }

    @Test (dataProvider = "doubleboundaryvaluessub", dataProviderClass = ArithmeticalDataProvider.class,
            description = "Double sub boundary values test",
            groups = {"critical path", "arithmetical"})
    public void testDoubleBoundaryValuesSum(double firstValue, double secondValue, double result){

        Double actualResult = calculator.sub(firstValue, secondValue);
        Assert.assertEquals(actualResult, result);
    }

}
