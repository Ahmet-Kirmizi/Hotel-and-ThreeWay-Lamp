package ss.week2;


import java.util.Scanner;

public class ThreeWayLampTUI {


    public void run() {
        Scanner input = new Scanner(System.in);

        ThreeWayLamp lamp1 = new ThreeWayLamp();
        System.out.println("Hello and welcome to the lamp program, would you like a tutorial (yes/no)");
        String tutorial = input.nextLine();

        if (tutorial.toLowerCase().equals("yes")) {
            System.out.println("This program is a lamp that has 4 settings, off, low,\n" +
                    " medium and high. You can change the settings one by one but,\n" +
                    " You can also set the lamp to a specific setting by typing in the setting you want.\n" +
                    " You can also check the current setting of the lamp.");
        } else {
            System.out.println("Ok, let's get started");
        }

        System.out.println("now that we figured this out, let's start");
        boolean answer = true;

        while (answer) {
            System.out.println("What do you want to do? (change, set, check or exit)");
            String action = input.nextLine();

            if (action.toLowerCase().equals("change")) {
                lamp1.changeLevel();
                System.out.println("The lamp is now " + lamp1.getLamplevel());


            } else if (action.toLowerCase().equals("set")) {
                System.out.println("What do you want to set the lamp to? (off, low, medium, high)");
                String setting = input.nextLine();

                if (setting.toLowerCase().equals("low")) {
                    lamp1.setSetting(ThreeWayLamp.lampStatus.low);
                    System.out.println("Your lamp is now on " + lamp1.getLamplevel());
                } else if (setting.toLowerCase().equals("medium")) {
                    lamp1.setSetting(ThreeWayLamp.lampStatus.medium);
                    System.out.println("Your lamp is now on " + lamp1.getLamplevel());
                } else if (setting.toLowerCase().equals("high")) {
                    lamp1.setSetting(ThreeWayLamp.lampStatus.high);
                    System.out.println("Your lamp is now on " + lamp1.getLamplevel());
                } else if (setting.toLowerCase().equals("off")) {
                    lamp1.setSetting(ThreeWayLamp.lampStatus.off);
                    System.out.println("Your lamp is now on " + lamp1.getLamplevel());
                }


            }


            if (action.toLowerCase().equals("check")) {
                System.out.println("The lamp is currently " + lamp1.getLamplevel());
            }


            if (action.toLowerCase().equals("exit")) {
                System.out.println("Thank you for using the lamp program");
                answer = false;
            }

        }


    }

    public static void main(String[] args) {
        ThreeWayLampTUI lamp1 = new ThreeWayLampTUI();
        lamp1.run();

    }
}