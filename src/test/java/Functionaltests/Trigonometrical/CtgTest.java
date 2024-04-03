package Functionaltests.Trigonometrical;

import Datafactory.CalculatorFactory;
import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CtgTest {

    private double value;
    private double result;

    Calculator calculator = CalculatorFactory.getCalculator();

    public CtgTest(double value, double result){
        this.value = value;
        this.result = result;
    }

    @Test(description = "Catangens basic test")
    public void basicCtgTest(){

        Assert.assertEquals(calculator.ctg(value), result);
    }
}
