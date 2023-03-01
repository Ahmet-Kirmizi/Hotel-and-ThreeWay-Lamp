package ss.week2.hotel;

import ss.hotel.bill.Bill;

public class PricedRoom extends Room implements Bill.Item {

    double price;

    /**
     * Constructor for PricedRoom
     * @param number number of  a room
     * @param price price of  a room
     * @param cost price of a safe
     */
    PricedRoom(int number, double price, double cost) {
        super(number, new PricedSafe(cost));
        this.price = price;

    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Price per night " ;
    }
}
