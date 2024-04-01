package Functionaltests.Trigonometrical;

import Datafactory.CalculatorFactory;
import Dataproviders.TrigonometricalDataProvider;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CosTest {

    Calculator calculator = CalculatorFactory.getCalculator();

    @Test(dataProvider = "cosbasic", dataProviderClass = TrigonometricalDataProvider.class,
            description = "Cosinus basic test", groups = {"smoke", "trigonometrical"})
    public void basicCosTest(double value, double result){

        Assert.assertEquals(calculator.cos(value), result);
    }


}
