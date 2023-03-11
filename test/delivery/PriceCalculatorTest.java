package delivery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceCalculatorTest {

    private final PriceCalculator priceCalculator = new PriceCalculator();

    @Test
    public void shouldThrowExceptionWhenBikeAndDistanceIs0Km() {
        IllegalArgumentException ex = Assertions.assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.BIKE, 0)
        );

        assertEquals("Distance should be more than 0 km", ex.getMessage());
    }

    @Test
    public void shouldThrowForTruckWhenDistanceIs0() {
        assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.TRUCK, 0)
        );
    }

    @Test
    public void shouldThrowForCarWhenDistanceIs0() {
        assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.CAR, 0)
        );
    }

    @Test
    public void shouldReturnCorrectPriceForBike() {
        internalAssert(10 * 10, TransportType.BIKE, 10);
    }

    @Test
    public void shouldReturnCorrectPriceForTruck() {
        internalAssert(5 * 10000, TransportType.TRUCK, 10000);
    }

    @Test
    public void shouldReturnCorrectPriceForCar() {
        internalAssert(7 * 500, TransportType.CAR,500);
    }

    @Test
    public void shouldThrowExceptionForCarWhenDistanceGt1000() {
        assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.CAR, 1001)
        );
    }

    @Test
    public void shouldThrowExceptionForBikeWhenDistanceGt20() {
        assertThrows(
                IllegalArgumentException.class,
                generateExecutable(TransportType.BIKE, 21)
        );
    }

    @Test
    public void shouldThrowExceptionForDrone() {
        assertThrows(
                UnsupportedOperationException.class,
                generateExecutable(TransportType.DRONE, 10)
        );
    }


    private void internalAssert(int expected, TransportType type, int distance) {
        int price = priceCalculator.calculatePrice(type, distance);
        assertEquals(expected, price);
    }

    private Executable generateExecutable(TransportType type, int distance) {
        return () -> priceCalculator.calculatePrice(type, distance);
    }
}