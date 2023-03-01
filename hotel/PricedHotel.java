package ss.week2.hotel;

import ss.hotel.bill.Bill;
import ss.hotel.bill.StringBillPrinter;

public class PricedHotel extends Hotel {

    public static final int ROOM_PRICE = 532;
    public static final double SAFE_PRICE = 31.32;

    PricedHotel(String name) {
        super(name);
        room1 = new PricedRoom(1, ROOM_PRICE, SAFE_PRICE);
        room2 = new Room(2);

    }

    public Bill getBill(String nameGuest, int numberOfNights, StringBillPrinter printer) {
        Room room = this.getRoom(nameGuest);
        Bill bill = new Bill(printer);
        if (room == null) {
            return null;
        } else {
            if (room instanceof PricedRoom) {
                for (int i = 0; i < numberOfNights; i++) {
                    bill.addItem((PricedRoom) room);
                }
                Safe safe = room.getSafe();
                if (safe.isActive()) {
                    bill.addItem((PricedSafe) safe);
                }
                bill.close();
                return bill;

            } else {
                return null;
            }
        }
    }

}
