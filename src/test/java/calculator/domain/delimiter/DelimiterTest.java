package calculator.domain.delimiter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.domain.io.input.CalcInput;
import calculator.domain.io.parser.InputParser;

class DelimiterTest {
    private final InputParser inputParser = new InputParser();

    @Test
    @DisplayName("커스텀 구분자가 있을 때 - 각 문자를 개별 구분자로 처리")
    void extractDelimeters_withCustom() {
        // given
        CalcInput input = new CalcInput("//;./\n1;./2;./3");

        // when
        InputParser.Parsed parsed = inputParser.parse(input);

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, parsed.delimiter().split(parsed.body()));
    }

    @Test
    @DisplayName(" 커스텀 구분자가 없을 때 - 기본 규칙으로 파싱")
    void extractDelimeters_withDefault() {
        // given
        CalcInput input = new CalcInput("1,2:3");

        // when
        InputParser.Parsed parsed = inputParser.parse(input);

        // then
        String[] tokens = parsed.delimiter().split(parsed.body());
        assertArrayEquals(new String[]{"1", "2", "3"}, tokens);

        String[] tokens2 = parsed.delimiter().split("10,20:30");
        assertArrayEquals(new String[]{"10", "20", "30"}, tokens2);
    }

    @Test
    @DisplayName("여러 커스텀 구분자 사용 - 각 문자를 개별 구분자로")
    void extractDelimeters_withMultipleCustom() {
        // given
        CalcInput input = new CalcInput("//\\;\\\\\n1;2\\3");

        // when
        InputParser.Parsed parsed = inputParser.parse(input);

        // then
        String[] tokens = parsed.delimiter().split(parsed.body());
        assertArrayEquals(new String[]{"1", "2", "3"}, tokens);
    }

    @Test
    @DisplayName("사용자 요청 케이스 - //;\\n1;2\\3")
    void extractDelimeters_userRequestCase() {
        // given
        CalcInput input = new CalcInput("//\\;\\\n1;2\\3");

        // when
        InputParser.Parsed parsed = inputParser.parse(input);

        // then
        String[] tokens = parsed.delimiter().split(parsed.body());
        assertArrayEquals(new String[]{"1", "2", "3"}, tokens);
    }
}