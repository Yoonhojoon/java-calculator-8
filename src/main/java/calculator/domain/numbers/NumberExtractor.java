package calculator.domain.numbers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import calculator.domain.io.parser.InputParser;

public final class NumberExtractor {
    public NumberExtractor() {}

    public Numbers extract(InputParser.Parsed parsed) {
        String body = parsed.body();
        if (body.isBlank()) {
            return new Numbers(List.of());
        }
        String[] tokens = parsed.delimiter().split(body);
        List<BigDecimal> numbers = Arrays.stream(tokens)
                .map(String::trim)
                .filter(token -> !token.isEmpty())  // 빈 토큰 제거
                .map(this::parseToBigDecimal)
                .collect(Collectors.toList());

        return new Numbers(numbers);
    }

    private BigDecimal parseToBigDecimal(String token) {
        try {
            return new BigDecimal(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("non-numeric value: " + token);
        }
    }
}

