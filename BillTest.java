package ss.week2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BillTest {

    private Bill testBill;


    @BeforeEach
    public void setUp() {
        BillPrinter printerTest = new StringBillPrinter();
        testBill = new Bill(printerTest);
    }

    @Test
    void setUpTest() {
        assertEquals(0, testBill.getSum());
        StringBillPrinter printer = (StringBillPrinter) testBill.getBillPrinter(); // !! ОБЕРЕЖНО !! we are casting to StringBillPrinter !!!!!
        assertEquals("", printer.getResult());
    }


    @Test
    void getSumTest() {
        double price1 = 42.24;
        double price2 = 19.94;
        addTwoItems();
        double finalSum = price1 + price2;
        assertEquals(finalSum, testBill.getSum(),0.1);

    }


    @Test
    void closeTest() {
        addTwoItems();
        StringBillPrinter printer = (StringBillPrinter) testBill.getBillPrinter();
        String test = printer.getResult();
        assertTrue(test.contains("Name item test 1"));

    }


    void addTwoItems() {
        double price1 = 42.24;
        double price2 = 19.94;
        ItemForTests itemTest1 = new ItemForTests("Name item test 1 ", price1);
        ItemForTests itemTest2 = new ItemForTests("Name item test 2 ", price2);
        testBill.addItem(itemTest1);
        testBill.addItem(itemTest2);
    }

    static class ItemForTests implements Bill.Item {

        private final String name;
        private final double price;

        public ItemForTests(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override

        public double getPrice() {
            return this.price;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

}
