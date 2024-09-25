package KI.Kulyk.Lab3;

import java.util.Scanner;

/**
 * Клас Driver для демонстрації роботи класу MobilePhone.
 */
public class Driver {
    public static void main(String[] args) {
        // Створення об'єкта MobilePhone
        Display display = new Display("AMOLED", 6.5);
        Battery battery = new Battery(4500);
        Processor processor = new Processor("Exynos", 8);

        // Введіть номер телефону для демонстрації
        String phoneNumber = "+380634567890";
        MobilePhone mobilePhone = new MobilePhone(display, battery, processor, phoneNumber);

        // Демонстрація методів
        System.out.println("Display Type: " + mobilePhone.getDisplayType());
        System.out.println("Battery Capacity: " + mobilePhone.getBatteryCapacity() + " mAh");
        System.out.println("Processor Type: " + mobilePhone.getProcessorType());

        // Виклик дзвінка
        mobilePhone.makeCall("+38063456154");

        // Надсилання SMS
        mobilePhone.sendSMS("+38063456154", "Hello, how are you?");

        // Отримання SMS
        mobilePhone.receiveSMS("I'm good, thanks!");

        // Закриття лог-файлу
        mobilePhone.closeLog();
    }
}