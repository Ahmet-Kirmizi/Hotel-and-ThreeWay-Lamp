package ss.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";

    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;


    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getInitPass();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    @Test
    public void testIsBillItem() throws Exception {
        assertTrue(safe instanceof Bill.Item,
                "safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getPrice(), 0,
                "GetPrice should return the price of the safe.");
    }


    @Test
    public void testGetPrice() throws Exception {
        assertEquals(PRICE, safe.getPrice());
    }

    @Test
    void testToString() {
        assertTrue(safe.toString().contains("Priced safe"));
    }

    @Test
    void testCorrectPassword() {
        safe.activate(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }
    @Test
    void testIncorrectPassword(){
        safe.activate(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

//Test if after trying to open a deactivated safe with the correct password the safe
//is indeed deactivated and closed;
    @Test
    void testDeactivatedAndClosed(){
        safe.open(CORRECT_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

//Test if after trying to open a deactivated safe with an incorrect password the safe
//is indeed deactivated and closed
    @Test
    void incorrectTestDeactivatedAndClosed(){
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
}


//Test that after activating a safe with the correct password it cannot be opened
//with an incorrect password, but after being opened with the correct password it is
//activated and open;

    @Test
    void testActivButCantOpen(){
        safe.activate(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
        safe.open(WRONG_PASSWORD);
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
        safe.open(CORRECT_PASSWORD);
        assertTrue(safe.isOpen());
    }


    //Test if after activating and opening a safe with the correct password, and closing it,
    //the safe is closed and activated;

    @Test
    void testActivOpenClose(){
        safe.activate(CORRECT_PASSWORD);
        safe.open(CORRECT_PASSWORD);
        safe.close();
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());

    }




    //Test if after closing a deactivated safe, it is closed and deactivated
    @Test
    void closedDeactivated(){
        safe.activate(CORRECT_PASSWORD);
        safe.open(CORRECT_PASSWORD);
        safe.close();
        safe.deactivate();
        assertFalse(safe.isOpen());
        assertFalse(safe.isActive());
    }
}
