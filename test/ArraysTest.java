import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraysTest {

    @Test
    public void arrays_should_be_equal() {
        String[] arrayOne = new String[] {"hello", "world", null };
        String[] arrayTwo = new String[] {"hello", "world", null };

        Assertions.assertArrayEquals(arrayTwo, arrayOne);
    }
}
