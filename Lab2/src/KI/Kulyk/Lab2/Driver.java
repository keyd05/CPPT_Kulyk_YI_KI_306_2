package KI.Kulyk.Lab2;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) {
        try {
            // Create default telephone
            Telephone defaultPhone = new Telephone();
            defaultPhone.turnOn();
            defaultPhone.makeCall("+123456789");
            System.out.println("Battery status: " + defaultPhone.checkBattery() + "mAh");
            defaultPhone.turnOff();

            // Create custom telephone
            Screen customScreen = new Screen(6.5, "1440p");
            Battery customBattery = new Battery(4000);
            Processor customProcessor = new Processor("Apple", 3.0);

            Telephone customPhone = new Telephone(customScreen, customBattery, customProcessor);
            customPhone.turnOn();
            customPhone.makeCall("+987654321");
            System.out.println("Battery status: " + customPhone.checkBattery() + "mAh");
            customPhone.turnOff();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
