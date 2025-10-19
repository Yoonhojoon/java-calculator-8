package calculator.domain.operation;

import java.math.BigDecimal;
import java.util.List;

public class AddOperation implements Operation {
    public AddOperation() {}

    @Override
    public BigDecimal calculate(List<BigDecimal> numbers){
        if (numbers == null) {
            throw new IllegalArgumentException("numbers must not be null");
        }
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal number : numbers) {
            if (number == null) {
                throw new IllegalArgumentException("number must not be null");
            }
            sum = sum.add(number);
        }
        return sum;
    }
}
