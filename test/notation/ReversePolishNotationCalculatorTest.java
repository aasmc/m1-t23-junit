package notation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReversePolishNotationCalculatorTest {

    private ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();

    @Test
    public void shouldCalculateAddition() {
        String input = "2 2 +";
        testInternal(input, 4);
    }

    @Test
    public void shouldCalculateAdditionWhenOneDigitIsNegative() {
        String input = "-2 2 +";
        testInternal(input, 0);
    }

    @Test
    public void shouldOverflowWhenAddingLargeIntegers() {
        String input = String.format("%d %d +", Integer.MAX_VALUE, 1);
        testInternal(input, Integer.MAX_VALUE + 1);
    }

    @Test
    public void shouldCalculateSubtractionNegativeNumbersOrderOfOperandsCorrect() {
        String input = "-2 2 -";
        testInternal(input, -4);
    }

    @Test
    public void shouldCalculateSubtractionPositiveNumbersOrderOfOperandsCorrect() {
        String input = "2 4 -";
        testInternal(input, -2);
    }

    @Test
    public void shouldCalculateMultiplicationPositiveNumbers() {
        String input = "3 4 *";
        testInternal(input, 12);
    }

    @Test
    public void shouldCalculateMultiplicationNegativeNumbers() {
        String input = "-1 -9 *";
        testInternal(input, 9);
    }

    @Test
    public void shouldCalculateMultiplicationOneOperandNegative() {
        String input = "-2 10 *";
        testInternal(input, -20);
    }

    @Test
    public void shouldCalculateComplexExpression() {
        String input = "2 4 - 8 * 10 +";
        testInternal(input, -6);
    }

    @Test
    public void shouldCalculateComplexExpressionWithVariableSpaces() {
        String input = "2   4 -     8 *     10 + ";
        testInternal(input, -6);
    }

    private void testInternal(String input, int expected) {
        int result = calculator.calculatePolishNotation(input);
        assertEquals(expected, result);
    }
}