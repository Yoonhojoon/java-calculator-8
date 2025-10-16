package calculator.domain.io.calcinput;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;


class CalcInputTest {

    @Test
    @DisplayName("빈 문자열 입력 시 IllegalArgumentException 반환")
    void calcInput_fail() {
        //given&&when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {new CalcInput(null);});
        //then
        assertEquals("input cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("성공적 문자열 입력 시 CalcInput 객체 반환")
    void calcInput_success() {
        //given
        CalcInput calcInput = new CalcInput("//123");
        //when&then
        assertEquals("//123", calcInput.getInput());
    }

}