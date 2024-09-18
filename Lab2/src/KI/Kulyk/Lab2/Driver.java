package KI.Kulyk.Lab2;

/**
 * Клас-драйвер для тестування класу Telephone.
 */
public class Driver {
    public static void main(String[] args) {
        // Створюємо телефон за замовчуванням
        Telephone phone1 = new Telephone();

        // Використовуємо кілька методів
        phone1.setDisplayType("LCD");
        phone1.setBatteryCapacity(4500);
        phone1.setProcessorType("Exynos");
        phone1.makeCall("+380631234567");
        phone1.endCall();

        // Отримуємо значення
        System.out.println("Display type: " + phone1.getDisplayType());
        System.out.println("Battery capacity: " + phone1.getBatteryCapacity());
        System.out.println("Processor type: " + phone1.getProcessorType());

        // Закриваємо лог
        phone1.closeLog();

        // Створюємо телефон з кастомними параметрами
        Display display = new Display("AMOLED", 6.5);
        Battery battery = new Battery(5000);
        Processor processor = new Processor("Apple A15", 6);

        Telephone phone2 = new Telephone(display, battery, processor);
        phone2.closeLog();
    }
}
