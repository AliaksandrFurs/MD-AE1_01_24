package Datafactory;

import com.epam.tat.module4.Calculator;

public class CalculatorFactory {

    private static Calculator calculator;

    private CalculatorFactory(){};

    public static Calculator getCalculator(){
        if(calculator == null){
            calculator = new Calculator();
        }return calculator;
    }
}
