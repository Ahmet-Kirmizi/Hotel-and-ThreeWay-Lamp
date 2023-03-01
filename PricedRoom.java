package ss.week2;


public class PricedRoom extends Room implements Bill.Item {
    private double price;
    private Room room;
    private PricedSafe safePrice;
    private Safe safe;
    private int number = super.getNumber();

    public PricedRoom(int number, double roomPrice, double safePrice) {
        super(number, new PricedSafe(safePrice));
        this.price = roomPrice;

    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "price per night is "+ this.price;
    }
}