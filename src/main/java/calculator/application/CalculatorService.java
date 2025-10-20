package calculator.application;

import java.math.BigDecimal;

import calculator.domain.numbers.NumberExtractor;
import calculator.domain.numbers.Numbers;
import calculator.domain.io.input.CalcInput;
import calculator.domain.io.output.CalcOutput;
import calculator.domain.io.parser.InputParser;
import calculator.domain.operation.AddOperation;
import calculator.domain.operation.Operation;

public class CalculatorService {
    private final InputParser inputParser;
    private final NumberExtractor numberExtractor;
    private final CalcOutput calcOutput;

    public CalculatorService() {
        this.inputParser = new InputParser();
        this.numberExtractor = new NumberExtractor();
        this.calcOutput = new CalcOutput();
    }

    public CalculatorService(InputParser inputParser, NumberExtractor numberExtractor, CalcOutput calcOutput) {
        this.inputParser = inputParser;
        this.numberExtractor = numberExtractor;
        this.calcOutput = calcOutput;
    }

    public void calculateAndPrint() {
        CalcInput input = new CalcInput(CalcInput.read());
        InputParser.Parsed parsed = inputParser.parse(input);

        Numbers numbers = numberExtractor.extract(parsed);

        Operation operation = new AddOperation();
        BigDecimal result = operation.calculate(numbers.getValues());

        calcOutput.printResult(result);
    }
}

