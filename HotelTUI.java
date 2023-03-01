package ss.week2;


import java.util.Scanner;

public class HotelTUI {

    private Hotel hotel;

    HotelTUI(String name) {
        this.hotel = new Hotel(name);
    }


    public static void main(String[] args) {
        HotelTUI hotel = new HotelTUI("Test hotel");
        hotel.run();
    }

    public void run() {
        boolean runStatus = true;
        System.out.println(uInterface());
        while (runStatus) {
            String[] commandArray = userInput();
            switch (commandArray[0].toLowerCase()) {
                case "in":
                    inCommand(commandArray);
                    break;
                case "out":
                    outCommand(commandArray);
                    break;

                case "room":
                    roomCommand(commandArray);
                    break;

                case "activate":
                    activateCommand(commandArray);
                    break;

                case "help":
                    System.out.println(uInterface());
                    break;
                case "print":
                    System.out.println(hotel);
                    break;
                case "exit":
                    runStatus = false;
                    break;
                default:
                    System.out.println("invalid input");
            }

        }

    }

    public void inCommand(String[] commandArray) {
        if (isSecondItemExist(commandArray) && hotel.getRoom(commandArray[1]) == null) {
            Room room = hotel.checkIn(commandArray[1]);
            if (room != null) {
                System.out.println("Guest " + room.getGuest().getName() + " gets room " + room.getNumber());

            } else {
                System.out.println("No free rooms");
            }

        } else {
            System.out.println("Guest already in hotel try different name  ");
        }

    }

    public void outCommand(String[] commandArray) {
        if (isSecondItemExist(commandArray)) {
            if (hotel.getRoom(commandArray[1]) != null) {
                hotel.checkOut(commandArray[1]);
                System.out.println("Check out is successful ");
            } else {
                System.out.println("Check out is not  successful guest with the name  " + commandArray[1] + " not found ");
            }
        } else {
            System.out.println("TEST 2");
        }
    }

    public void roomCommand(String[] commandArray) {
        if (isSecondItemExist(commandArray)) {
            Room room = hotel.getRoom(commandArray[1]);
            if (room != null) {
                System.out.println("Guest " + commandArray[1] + " have a room " + room.getNumber());
            } else {
                System.out.println("Guest " + commandArray[1] + " doesn't have a room");
            }
        }

    }

    public void activateCommand(String[] commandArray) {
        if (isSecondItemExist(commandArray)) {
            Room room = hotel.getRoom(commandArray[1]);
            if (room != null) {
                room.getSafe().activate();
                if (room.getSafe().isActive()) {
                    System.out.println("safe of guest " + room.getGuest().getName() + " is activated");
                } else {
                    System.out.println("safe is not activated");
                }
            } else {
                System.out.println("Guest " + commandArray[1] + " doesn 't have a room");
            }


        } else {
            System.out.println("Test 4");
        }
    }

    public static boolean isSecondItemExist(String[] arg) {
        if (arg[1] != null) {
            return true;
        } else {
            return false;
        }

    }


    public static String[] userInput() {
        String[] result;
        String[] finalResult = new String[2]; // change for 3 for password later
        Scanner input = new Scanner(System.in);
        System.out.print("Command :");
        String stringInput = input.nextLine();
        result = stringInput.split("\\s+");
        int i = 0;
        for (String word : result) {
            String tempWord = word.replace(" ", "");
            if (!tempWord.equals("")) {
                finalResult[i] = tempWord;
                i++;
            }

        }
        return finalResult;
    }


    public static String uInterface() {
        String textInterface = "Welcome to the Hotel management system of the \"Hotel Twente\"\n";
        textInterface = textInterface + "Commands :  \n";
        textInterface = textInterface + "in name ................. check in guest with name \n";
        textInterface = textInterface + "out name ................ check out guest with name\n";
        textInterface = textInterface + "room name ............... request room of guest with name\n";
        textInterface = textInterface + "activate name ........... activate safe of guest with name \n";
        textInterface = textInterface + "help .................... help (this menu)\n";
        textInterface = textInterface + "print ................... print state\n";
        textInterface = textInterface + "exit .................... exit";
        return textInterface;
    }

}
