package calculator.domain.delimiter;

import calculator.domain.io.calcinput.CalcInput;
import calculator.domain.io.inputparser.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DelimiterTest {

    @Test
    @DisplayName("커스텀 구분자가 있을 때 - 마지막 개행 규칙으로 파싱")
    void extractDelimeters_withCustom() {
        // given
        CalcInput input = new CalcInput("//;./\n1;./2;./3");

        // when
        InputParser.Parsed parsed = InputParser.parse(input);

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, parsed.delimiter().split(parsed.body()));
    }

    @Test
    @DisplayName(" 커스텀 구분자가 없을 때 - 기본 규칙으로 파싱")
    void extractDelimeters_withDefault() {
        // given
        CalcInput input = new CalcInput("1,2:3");

        // when
        InputParser.Parsed parsed = InputParser.parse(input);

        // then
        String[] tokens = parsed.delimiter().split(parsed.body());
        assertArrayEquals(new String[]{"1", "2", "3"}, tokens);

        String[] tokens2 = parsed.delimiter().split("10,20:30");
        assertArrayEquals(new String[]{"10", "20", "30"}, tokens2);
    }
}