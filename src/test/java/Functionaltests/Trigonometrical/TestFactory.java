package Functionaltests.Trigonometrical;
import Dataproviders.TrigonometricalDataProvider;
import org.testng.annotations.Factory;


public class TestFactory {

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
