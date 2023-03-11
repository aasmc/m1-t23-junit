package discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountCalculatorTest {

    DiscountCalculator discountCalculator = new DiscountCalculator();

    @Test
    public void shouldGiveNoDiscountForValue999() {
        testInternal(999, 999);
    }

    @Test
    public void shouldGiveNoDiscountForValue1() {
        testInternal(1, 1);
    }

    @Test
    public void shouldGiveNoDiscountForValue333() {
        testInternal(333, 333);
    }

    @Test
    public void shouldGive2PercentDiscountForValue1000() {
        testInternal(1000, 980);
    }

    @Test
    public void shouldGive2PercentDiscountForValue2000() {
        testInternal(2000, 1960);
    }

    private void testInternal(int buySum, int expected) {
        int result = discountCalculator.sumAfterDiscount(buySum);
        Assertions.assertEquals(expected, result);
    }
}