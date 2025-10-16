package calculator.domain.delimiter;

import java.util.regex.Pattern;

public final class Delimiter {
    private static final Pattern DEFAULT = Pattern.compile("[,:]"); // 쉼표|콜론
    private final Pattern pattern;

    private Delimiter(Pattern pattern) {
        this.pattern = pattern;
    }

    public static Delimiter defaultDelimiter() {
        return new Delimiter(DEFAULT);
    }

    public static Delimiter ofCustom(String raw) {
        // 메타문자·개행 안전화: "raw 전체"를 리터럴로 취급
        return new Delimiter(Pattern.compile(Pattern.quote(raw), Pattern.DOTALL));
    }

    public String[] split(String body) {
        // -1: 빈 토큰 보존 → 잘못된 입력 검출 가능
        return pattern.split(body, -1);
    }
}
