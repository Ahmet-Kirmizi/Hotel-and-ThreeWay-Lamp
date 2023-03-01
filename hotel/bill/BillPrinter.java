package ss.hotel.bill;

public interface BillPrinter {

    default String format(String text, double price) {
        return String.format("%-25s %25.2f", text, price);
    }

    void printLine(String text, double price);

}
