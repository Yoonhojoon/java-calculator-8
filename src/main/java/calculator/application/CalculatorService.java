package calculator.application;

import java.math.BigDecimal;

import calculator.domain.extractnum.NumberExtractor;
import calculator.domain.extractnum.Numbers;
import calculator.domain.io.calcinput.CalcInput;
import calculator.domain.io.calcoutput.CalcOutput;
import calculator.domain.io.inputparser.InputParser;
import calculator.domain.operation.AddOperation;
import calculator.domain.operation.Operation;

public class CalculatorService {

    public void calculateAndPrint() {
        CalcInput input = new CalcInput(CalcInput.read());
        InputParser.Parsed parsed = InputParser.parse(input);

        Numbers numbers = NumberExtractor.extract(parsed);

        Operation operation = new AddOperation();
        BigDecimal result = operation.calculate(numbers.getValues());

        CalcOutput.printResult(result);
    }
}

