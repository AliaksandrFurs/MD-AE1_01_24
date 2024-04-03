package Functionaltests.Trigonometrical;

import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TgTest {

    private double value;
    private double result;

    Calculator calclulator = CalculatorFactory.getCalculator();

    public TgTest(double value, double result){
        this.value = value;
        this.result = result;
    }

    @Test(description = "Tangens basic test")
    public void basicTgTest(){

        Assert.assertEquals(calclulator.tg(value), result);
    }
}
