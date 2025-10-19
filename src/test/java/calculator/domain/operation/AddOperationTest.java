package calculator.domain.operation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AddOperationTest {

    @Test
    @DisplayName("빈 리스트면 0 반환")
    void sum_emptyList_returnsZero() {
        AddOperation op = new AddOperation();
        BigDecimal result = op.calculate(List.of());
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    @DisplayName("한 개 값 합산")
    void sum_singleValue() {
        AddOperation op = new AddOperation();
        BigDecimal result = op.calculate(List.of(new BigDecimal("7")));
        assertEquals(new BigDecimal("7"), result);
    }

    @Test
    @DisplayName("여러 값 합산")
    void sum_multipleValues() {
        AddOperation op = new AddOperation();
        BigDecimal result = op.calculate(List.of(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3")));
        assertEquals(new BigDecimal("6"), result);
    }

    @Test
    @DisplayName("null 리스트는 예외")
    void null_list_throws() {
        AddOperation op = new AddOperation();
        assertThrows(IllegalArgumentException.class, () -> op.calculate(null));
    }

    @Test
    @DisplayName("내부 원소 null이면 예외")
    void null_element_throws() {
        AddOperation op = new AddOperation();
        assertThrows(IllegalArgumentException.class, () -> op.calculate(Arrays.asList(new BigDecimal("1"), null)));
    }
}


