package ss.week2;

public class Guest {
    String name;
    Room room;

    /**
     * Constructor for class Guest
     * @param name takes name to initialize class , and sets room to null
     */
    Guest(String name) {
        this.name = name;
        this.room = null;
    }

    /**
     *
     * @param room
     * @return
     */

    public boolean checkin(Room room) {
        if (room.getGuest() == null) {
            this.room = room;
            room.setGuest(this);
            return true;
        } else return false;
    }


    public boolean checkout() {
        if (this.getRoom() == null) {
            return false;
        } else {
            this.getRoom().setGuest(null);
            this.room = null;
            return true;
        }
    }

    public String getName() {
        return this.name;
    }

    public Room getRoom() {
        return this.room;

    }


}