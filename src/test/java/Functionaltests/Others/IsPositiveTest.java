package Functionaltests.Others;

import Dataproviders.PositiveDataProvider;
import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class IsPositiveTest {

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

    @Test(dataProvider = "ispositive", dataProviderClass = PositiveDataProvider.class,
            description = "Positive long basic test",
            groups = {"critical path", "other"})
    public void isPositiveTest(long value, boolean expectedResult){

        Assert.assertEquals(calculator.isPositive(value), expectedResult);

    }

    @Test(dataProvider = "isnegative", dataProviderClass = PositiveDataProvider.class,
            description = "Positive long basic test",
            groups = {"critical path", "other"})
    public void isNegativeTest(long value, boolean expectedResult){

        Assert.assertEquals(calculator.isNegative(value), expectedResult);

    }

}
