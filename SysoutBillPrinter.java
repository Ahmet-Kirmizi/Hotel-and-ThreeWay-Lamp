package ss.week2;

public class SysoutBillPrinter implements BillPrinter {
    public static void main(String[] args) {
        SysoutBillPrinter s = new SysoutBillPrinter();
        s.printLine("Some text ", 23.32);
        s.printLine("Some text try 2  ", 1233.32);

    }

    @Override
    public void printLine(String text, double price) {
        System.out.println(this.format(text, price));
    }

}
