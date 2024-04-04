package Functionaltests.Trigonometrical;

import Datafactory.CalculatorFactory;
import Dataproviders.TrigonometricalDataProvider;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class CosTest {

    private double value;
    private double result;

    Calculator calculator = CalculatorFactory.getCalculator();

    public CosTest(double value, double result){
        this.value = value;
        this.result = result;
    }

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

    @Test(description = "Cosinus basic test", groups = {"smoke", "trigonometrical"})
    public void basicCosTest(){

        Assert.assertEquals(calculator.cos(value), result);
    }
}
