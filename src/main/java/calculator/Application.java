package calculator;

import calculator.application.CalculatorService;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        calculatorService.calculateAndPrint();
    }
}
