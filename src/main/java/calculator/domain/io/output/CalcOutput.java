package calculator.domain.io.output;

import java.math.BigDecimal;

public final class CalcOutput {

    public CalcOutput() {}

    public String formatResult(BigDecimal result) {
        if (result == null) {
            throw new IllegalArgumentException("result must not be null");
        }
        return "결과 : " + result.toPlainString();
    }

    public void printResult(BigDecimal result) {
        System.out.println(formatResult(result));
    }
}
