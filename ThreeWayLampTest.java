package ss.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ThreeWayLampTest {
    private ThreeWayLamp lamp;


    @BeforeEach
    public void setUp() {
        lamp = new ThreeWayLamp();
    }

    @Test
    void setSetting() {
        assertEquals(ThreeWayLamp.lampStatus.off, lamp.getLamplevel());
        lamp.setSetting(ThreeWayLamp.lampStatus.low);
        assertEquals(ThreeWayLamp.lampStatus.low, lamp.getLamplevel());
        lamp.setSetting(ThreeWayLamp.lampStatus.medium);
        assertEquals(ThreeWayLamp.lampStatus.medium, lamp.getLamplevel());
        lamp.setSetting(ThreeWayLamp.lampStatus.high);
        assertEquals(ThreeWayLamp.lampStatus.high, lamp.getLamplevel());
        lamp.setSetting(ThreeWayLamp.lampStatus.off);
        assertEquals(ThreeWayLamp.lampStatus.off, lamp.getLamplevel());
    }


    @Test
    void nextSettingLamp() {
        assertEquals(ThreeWayLamp.lampStatus.off, lamp.getLamplevel());
        lamp.changeLevel();
        assertEquals(ThreeWayLamp.lampStatus.low, lamp.getLamplevel());
        lamp.changeLevel();
        assertEquals(ThreeWayLamp.lampStatus.medium, lamp.getLamplevel());
        lamp.changeLevel();
        assertEquals(ThreeWayLamp.lampStatus.high, lamp.getLamplevel());
        lamp.changeLevel();
        assertEquals(ThreeWayLamp.lampStatus.off, lamp.getLamplevel());


    }
}