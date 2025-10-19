package calculator.domain.io.inputparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.domain.delimiter.Delimiter;
import calculator.domain.io.calcinput.CalcInput;

public final class InputParser {

    private static final Pattern LAST_NL =
            Pattern.compile("^//(.*?)(\\\\n|\\n)(.*)$", Pattern.DOTALL);

    public record Parsed(Delimiter delimiter, String body) {}

    private InputParser() {}

    public static Parsed parse(CalcInput input) {
        String s = input.getInput();
        Matcher m = LAST_NL.matcher(s);
        if (m.matches()) {
            String rawDelimiter = m.group(1); // "//"와 "마지막 개행" 사이 전부
            String body = m.group(3); // 그룹 3이 실제 body
            return new Parsed(Delimiter.ofCustom(rawDelimiter), body);
        }
        return new Parsed(Delimiter.defaultDelimiter(), s);
    }
}
