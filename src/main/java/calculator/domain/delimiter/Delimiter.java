package calculator.domain.delimiter;

import java.util.Arrays;
import java.util.regex.Pattern;

public final class Delimiter {
    private static final Pattern DEFAULT = Pattern.compile("[,:]");
    private final Pattern pattern;

    private Delimiter(Pattern pattern) {
        this.pattern = pattern;
    }

    public static Delimiter defaultDelimiter() {
        return new Delimiter(DEFAULT);
    }

    public static Delimiter ofCustom(String raw) {
        // 모든 문자를 개별 구분자로 처리
        StringBuilder patternBuilder = new StringBuilder();
        for (int i = 0; i < raw.length(); i++) {
            if (i > 0) patternBuilder.append("|");
            patternBuilder.append(Pattern.quote(String.valueOf(raw.charAt(i))));
        }
        return new Delimiter(Pattern.compile(patternBuilder.toString(), Pattern.DOTALL));
    }

    public String[] split(String body) {
        // 빈 토큰 제거
        String[] tokens = pattern.split(body, -1);
        return Arrays.stream(tokens)
                .filter(token -> !token.isEmpty())
                .toArray(String[]::new);
    }
}
