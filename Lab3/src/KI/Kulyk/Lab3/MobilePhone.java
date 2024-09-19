package KI.Kulyk.Lab3;

/**
 * Інтерфейс з додатковими функціями мобільного телефону.
 */
interface MobileFunctions {
    void sendSMS(String number, String message);
    void browseInternet(String url);
}

/**
 * Клас MobilePhone розширює абстрактний клас Telephone
 * і реалізує інтерфейс MobileFunctions.
 */
public class MobilePhone extends Telephone implements MobileFunctions {

    private String phoneNumber;

    /**
     * Конструктор за замовчуванням.
     */
    public MobilePhone() {
        super();
        this.phoneNumber = "Unknown";
        log("MobilePhone created with default phone number.");
    }

    /**
     * Конструктор з параметрами.
     * @param display дисплей телефону
     * @param battery батарея телефону
     * @param processor процесор телефону
     * @param phoneNumber номер телефону
     */
    public MobilePhone(Display display, Battery battery, Processor processor, String phoneNumber) {
        super(display, battery, processor);  // Спочатку викликається конструктор суперкласу
        this.phoneNumber = phoneNumber;
        log("MobilePhone created with custom phone number: " + phoneNumber);
    }

    /**
     * Встановити номер телефону.
     * @param phoneNumber номер телефону
     */
    public void setPhoneNumber(String phoneNumber) {
        log("Setting phone number to: " + phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Отримати номер телефону.
     * @return номер телефону
     */
    public String getPhoneNumber() {
        log("Getting phone number.");
        return phoneNumber;
    }

    /**
     * Реалізація абстрактного методу для здійснення дзвінка.
     * @param number номер телефону, на який здійснюється дзвінок
     */
    @Override
    public void makeCall(String number) {
        setBatteryCapacity(getBatteryCapacity() - 30);
        log("Making call to: " + number);
        System.out.println("Calling " + number + " from " + phoneNumber);
    }

    /**
     * Відправити SMS.
     * @param number номер отримувача
     * @param message текст повідомлення
     */
    @Override
    public void sendSMS(String number, String message) {
        setBatteryCapacity(getBatteryCapacity() - 10);
        log("Sending SMS to: " + number + " with message: " + message);
        System.out.println("Sending SMS to " + number + ": " + message);
    }

    /**
     * Перегляд веб-сторінки.
     * @param url URL сторінки
     */
    @Override
    public void browseInternet(String url) {
        setBatteryCapacity(getBatteryCapacity() - 50);
        log("Browsing internet at: " + url);
        System.out.println("Browsing " + url);
    }
}
