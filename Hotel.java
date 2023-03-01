package ss.week2;


public class Hotel {


    private final String nameHotel;
    private final Room room1;
    private final Room room2;

    /**
     * Constructor of a hotel name required as arg
     * Create 2 rooms (1,2)
     * @param name Name of a  hotel
     */
    Hotel(String name) {
        this.nameHotel = name;
        this.room1 = new Room(1);
        this.room2 = new Room(2);
    }

    /**
     * getRoom method that iterates over the room object checking first if the room is empty or not then if the name of the guest equals to the name
     * @param name of the guest
     * @return result
     */
    //@requires name != null;
    //@ensures room1.getGuest() != null || room1.getGuest().getName().equals(name) || room2.getGuest() != null || room2.getGuest().getName().equals(name);
    public Room getRoom(String name) {
        Room result = null;
        Room[] rooms = {room1, room2};
        for (Room room : rooms) {
            if (room.getGuest() != null) {
                if (room.getGuest().getName().equals(name)) {
                    result = room;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * getFreeRoom() looks for first empty room
     * @return first empty room or null if  no free rooms in a hotel
     */
    //@ensures room1.getGuest() == null || room1 == null || room2.getGuest() == null || room2 == null;
    public Room getFreeRoom() {
        Room result = null;
        Room[] rooms = {room1, room2};
        for (Room room : rooms) {
            if (room.getGuest() == null) {
                result = room;
                break;
            }
        }
        return result;


    }
    /**
     * checkIn(name)
     * @param name looks for free room  , and than  takes a name creates new guest and assigned to room and room to guest
     * @return
     */
    //@requires  name != null;
    //@ensures room1.getGuest().getName().equals(name) ||room2.getGuest().getName().equals(name)  || \result == null;
    public Room checkIn(String name) {
        Room room = getFreeRoom();
        if (room != null && getRoom(name) == null) {
            Guest guest = new Guest(name);
            guest.checkin(room);
            return room;

        } else {
            return null;
        }


    }

    /**
     * Looks for a guest with given name (as arg) and check him out if found
     * @param name
     */
    //@requires name != null;
    //@ensures room1.getGuest() == null && room2.getGuest() == null;
    public void checkOut(String name) {
        Room[] rooms = {room1, room2};
        for (Room room : rooms) {
            if (room.getGuest() != null) {
                if (room.getGuest().getName().equals(name)) {
                    room.getGuest().checkout();
                    room.setGuest(null);
                    room.getSafe().deactivate();

                }
            }

        }

    }

    /**
     * Prints all information regarding hotel, rooms , guests , and status of a safe
     * @return
     */
    public String toString() {
        Room[] rooms = {room1, room2};
        String result = "";
        result = result + "Name of a hotel " + this.nameHotel + "\n";
        int i = 1;
        for (Room room : rooms) {
            if (room.getGuest() != null) {
                result = result + "In room  " + i + " guest is " + room.getGuest().getName() + " Safe status " + room.getSafe().isActive() + "\n";
                i++;
            } else {
                result = result + "In room  " + i + " " + "room is empty" + " Safe status " + room.getSafe().isActive() + "\n";
                i++;
            }
        }
        return result;
    }


}

