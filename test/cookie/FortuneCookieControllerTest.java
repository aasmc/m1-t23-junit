package cookie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FortuneCookieControllerTest {

    private FortuneConfig config;
    private FortuneController controller;
    private FortuneCookieFactory factory;

    @Test
    public void shouldReturnPositiveFortune() {
        setup(true);
        FortuneCookie fortuneCookie = controller.tellFortune();
        Assertions.assertEquals("positive", fortuneCookie.getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        setup(false);
        FortuneCookie fortuneCookie = controller.tellFortune();
        Assertions.assertEquals("negative", fortuneCookie.getFortuneText());
    }

    private void setup(boolean isPositive) {
        config = new FortuneConfig(isPositive);
        factory = new FortuneCookieFactory(config, List.of("positive"), List.of("negative"));
        controller = new FortuneController(factory);
    }

}
