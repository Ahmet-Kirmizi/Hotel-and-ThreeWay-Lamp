package ss.week2;


public class Bill {
    private BillPrinter billPrinter;

    private double sum;
    String description;

    public Bill(BillPrinter billPrinter) {
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
        StringBillPrinter printer = (StringBillPrinter) this.billPrinter;
        String billStringItems = printer.getResult();
        String billTotal = "the sum of the items is " + this.sum;
        String res = billStringItems + billTotal;
        System.out.println(res);
    }

    public double getSum() {
        return this.sum;

    }

    public BillPrinter getBillPrinter() {
        return billPrinter;
    }

    public interface Item {


        double getPrice();

        @Override
        String toString();
    }

}