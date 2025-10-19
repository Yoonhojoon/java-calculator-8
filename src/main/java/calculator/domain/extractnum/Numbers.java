package calculator.domain.extractnum;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Numbers {
    private final List<BigDecimal> values;

    public Numbers(List<BigDecimal> values) {
        if (values == null) {
            throw new IllegalArgumentException("values must not be null");
        }
        for (BigDecimal value : values) {
            if (value == null) {
                throw new IllegalArgumentException("number must not be null");
            }
            if (value.signum() <= 0) {
                throw new IllegalArgumentException("non-positive number: " + value);
            }
        }
        this.values = List.copyOf(values);
    }

    public List<BigDecimal> getValues() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return values.equals(numbers.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}

