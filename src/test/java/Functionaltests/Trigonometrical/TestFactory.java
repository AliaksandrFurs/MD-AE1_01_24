package Functionaltests.Trigonometrical;
import Dataproviders.TrigonometricalDataProvider;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class TestFactory {

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

    @Factory(dataProvider = "cosbasic", dataProviderClass = TrigonometricalDataProvider.class)
    public Object [] setCosConstructorValue(double value, double result){

        return new Object []
                {new CosTest(value, result)};

    }

    @Factory(dataProvider = "sinbasic", dataProviderClass = TrigonometricalDataProvider.class)
    public Object [] setSinConstructorValue(double value, double result){

        return new Object []
                {new SinTest(value, result)};
    }

    @Factory(dataProvider = "tgbasic", dataProviderClass = TrigonometricalDataProvider.class)
    public Object [] setTgConstructorValue(double value, double result){

        return new Object []
                {new TgTest(value, result)};
    }

    @Factory(dataProvider = "ctgbasic", dataProviderClass = TrigonometricalDataProvider.class)
    public Object [] setCtgConstructorValue(double value, double result){

        return new Object []
                {new CtgTest(value, result)};
    }
}
