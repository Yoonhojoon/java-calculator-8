package calculator.domain.io.calcinput;

import camp.nextstep.edu.missionutils.Console;

public class CalcInput {
    private String input;

    public CalcInput(String input) {
        validateInput(input);
        this.input = input;
    }

    private void validateInput(String input) {
        if (input == null ) {
            throw new IllegalArgumentException("input cannot be null");
        }
    }

    public String getInput() {
        return input;
    }

    public static String read() {
        return Console.readLine();
    }

}
