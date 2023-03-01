package ss.hotel.bill;


public class Bill {
    private final BillPrinter billPrinter;
    private double sum;

    public Bill(ss.hotel.bill.StringBillPrinter billPrinter) {
        this.billPrinter = billPrinter;
        this.sum = 0;

    }

    public void addItem(Bill.Item item) {
        double tempPrice = item.getPrice();
        this.sum = this.sum + tempPrice;
        String tempsDescription = item.toString();
        this.billPrinter.printLine(tempsDescription, tempPrice); // printLine -> 2 dif print
    }

    public void close() {
        StringBillPrinter printer = (StringBillPrinter) this.billPrinter; // !! ОБЕРЕЖНО !! we are casting to StringBillPrinter !!!!!
        String billStringItems = printer.getResult();
        String billTotal = "The sum of the items is ";

        printer.printLine(billTotal, getSum());
    }

    public double getSum() {
        return this.sum;

    }

    public BillPrinter getBillPrinter() {   // for BillTest
        return this.billPrinter;
    }

    public interface Item {


        double getPrice();

        @Override
        String toString();
    }

}