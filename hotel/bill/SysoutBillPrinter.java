package ss.hotel.bill;

public class SysoutBillPrinter implements BillPrinter {
    @Override
    public void printLine(String text, double price) {
        System.out.println(this.format(text, price));
    }
}
