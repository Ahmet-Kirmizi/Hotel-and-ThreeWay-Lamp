package ss.week2;

public class StringBillPrinter implements BillPrinter {


    private String allLines = "";


    @Override
    public void printLine(String text, double price) {
        allLines = allLines + format(text, price) + "\n";
    }


    public String getResult() {
        return this.allLines;
    }
}
