package ss.week2;

public interface BillPrinter {

    default String format(String text, double price) {
        String line = String.format("%-25s %,25.2f !", text, price);
        return line;
    }


    void printLine(String text, double price);


}
