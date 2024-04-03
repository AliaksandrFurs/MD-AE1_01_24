package Functionaltests.Trigonometrical;

import Datafactory.CalculatorFactory;
import Dataproviders.TrigonometricalDataProvider;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CosTest {

    private double value;
    private double result;

    Calculator calculator = CalculatorFactory.getCalculator();

    public CosTest(double value, double result){
        this.value = value;
        this.result = result;
    }

    @Test(description = "Cosinus basic test", groups = {"smoke", "trigonometrical"})
    public void basicCosTest(){

        Assert.assertEquals(calculator.cos(value), result);
    }
}
