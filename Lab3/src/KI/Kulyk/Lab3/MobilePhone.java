package KI.Kulyk.Lab3;

/**
 * Інтерфейс з функціоналом для мобільного телефону.
 */
interface MobileDevice {
    void sendSMS(String number, String message);
    void receiveSMS(String message);
}

/**
 * Клас MobilePhone розширює Telephone і реалізує інтерфейс MobileDevice.
 */
public class MobilePhone extends Telephone implements MobileDevice {

    private String phoneNumber;

    /**
     * Конструктор з параметрами.
     *
     * @param display   дисплей телефону
     * @param battery   батарея телефону
     * @param processor процесор телефону
     * @param phoneNumber номер телефону
     */
    public MobilePhone(Display display, Battery battery, Processor processor, String phoneNumber) {
        super(display, battery, processor);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void makeCall(String number) {
        setBatteryCapacity(getBatteryCapacity() - 30);
        log("Calling to " + number + " from " + phoneNumber + ".");
    }

    @Override
    public void sendSMS(String number, String message) {
        setBatteryCapacity(getBatteryCapacity() - 15);
        log("Sending SMS to " + number + ": " + message);
    }

    @Override
    public void receiveSMS(String message) {
        setBatteryCapacity(getBatteryCapacity() - 5);
        log("Received SMS: " + message);
    }
}