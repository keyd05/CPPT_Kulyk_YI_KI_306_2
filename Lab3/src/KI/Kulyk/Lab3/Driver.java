package KI.Kulyk.Lab3;

/**
 * Клас-драйвер для тестування класу MobilePhone.
 */
public class Driver {
    public static void main(String[] args) {
        // Створення мобільного телефону за замовчуванням
        MobilePhone phone = new MobilePhone();

        // Використання методів
        phone.setPhoneNumber("+380123456789");
        phone.makeCall("+380987654321");
        phone.sendSMS("+380987654321", "Hello, this is a test SMS!");
        phone.browseInternet("www.example.com");

        // Закриття лог-файлу
        phone.closeLog();

        // Створення мобільного телефону з кастомними параметрами
        MobilePhone.Display display = phone.new Display("AMOLED", 6.5);
        MobilePhone.Battery battery = phone.new Battery(5000);
        MobilePhone.Processor processor = phone.new Processor("Exynos", 8);

        MobilePhone customPhone = new MobilePhone(display, battery, processor, "+380987654321");
        customPhone.makeCall("+380123456789");
        customPhone.closeLog();
    }
}
