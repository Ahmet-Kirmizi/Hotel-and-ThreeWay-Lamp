package ss.hotel.bill;

public class StringBillPrinter implements BillPrinter {

    String allLines;

    public StringBillPrinter() {
        this.allLines = "";
    }

    @Override
    public void printLine(String text, double price) {
        allLines = allLines + format(text, price) + "\n";
    }

    public String getResult() {
        return this.allLines;
    }

}
