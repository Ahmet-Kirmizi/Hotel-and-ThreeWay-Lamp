package ss.week2.hotel;

public class Guest {
    private final String name;

    private Room room;

    /**
     * Constructor for class Guest
     *
     * @param name takes name to initialize class , and sets room to null
     */
    Guest(String name) {
        this.name = name;

    }

    /**
     * checkin(Room room)
     *
     * @param room takes arg of a type Room
     *             Than it checks if room is empty , and if its is the case its set this room to Guest and guest to that Room
     * @return True if checkin passed and  False if it is not successful
     * @ensures room.getGuest() == null
     */

    public boolean checkin(Room room) {
        if (room.getGuest() == null && this.room == null) {
            this.room = room;
            room.setGuest(this);
            return true;
        } else {
            return false;
        }
    }


    /**
     * checkout() Checking out guest
     * Try to check out Guest from the room by setting it to null
     *
     * @return If Guest  do not have room return false , otherwise (successful checkout ) returns True
     * @ensures this.getRoom() == null
     */

    public boolean checkout() {
        if (this.getRoom() == null) {
            return false;
        } else {
            this.getRoom().setGuest(null);
            this.room = null;
            return true; // true
        }
    }

    public String getName() {
        return this.name;
    }

    /**
     * getRoom()
     *
     * @return room of this guest
     */
    public Room getRoom() {
        return this.room;

    }

    public String toString() {
        return this.name;


    }


}
