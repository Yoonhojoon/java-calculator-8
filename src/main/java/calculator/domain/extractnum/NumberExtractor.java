package calculator.domain.extractnum;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import calculator.domain.io.inputparser.InputParser;

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
                .peek(token -> {
                    if (token.isEmpty()) {
                        throw new IllegalArgumentException("null token is not allowed");
                    }
                    if (!token.chars().allMatch(Character::isDigit)) {
                        throw new IllegalArgumentException("non-numeric value: " + token);
                    }
                })
                .map(BigDecimal::new)
                .collect(Collectors.toList());

        return new Numbers(numbers);
    }
}

