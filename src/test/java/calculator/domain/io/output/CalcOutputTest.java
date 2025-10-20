package calculator.domain.io.output;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalcOutputTest {
    private final CalcOutput calcOutput = new CalcOutput();

    @Test
    @DisplayName("포맷 - 결과 접두사와 값 출력")
    void format_prefix_and_value() {
        String formatted = calcOutput.formatResult(new BigDecimal("123"));
        assertEquals("결과 : 123", formatted);
    }

    @Test
    @DisplayName("포맷 - null은 예외")
    void format_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> calcOutput.formatResult(null));
    }
}


