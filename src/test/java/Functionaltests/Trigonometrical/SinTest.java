package Functionaltests.Trigonometrical;

import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SinTest {

    private double value;
    private double result;

    Calculator calculator = CalculatorFactory.getCalculator();

    public SinTest(double value, double result){
        this.value = value;
        this.result = result;
    }

    @Test(description = "Sinus basic test")
    public void basicSintest(){

        Assert.assertEquals(calculator.sin(value), result);
    }
}
