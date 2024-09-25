package KI.Kulyk.Lab3;

/**
 * Інтерфейс для функціональності мобільного пристрою.
 */
interface MobileDevice {
    void sendSMS(String number, String message);
    void takePhoto();
}

/**
 * Клас MobilePhone, який розширює абстрактний клас Telephone та реалізує інтерфейс MobileDevice.
 */
public class MobilePhone extends Telephone implements MobileDevice {
    private String operatingSystem;
    private int cameraResolution;

    /**
     * Конструктор за замовчуванням.
     */
    public MobilePhone() {
        super();
        this.operatingSystem = "Android";
        this.cameraResolution = 12;
        log("MobilePhone created with default values.");
    }

    /**
     * Конструктор з параметрами.
     *
     * @param display дисплей телефону
     * @param battery батарея телефону
     * @param processor процесор телефону
     * @param operatingSystem операційна система
     * @param cameraResolution роздільна здатність камери в мегапікселях
     */
    public MobilePhone(Display display, Battery battery, Processor processor,
                       String operatingSystem, int cameraResolution) {
        super(display, battery, processor);
        this.operatingSystem = operatingSystem;
        this.cameraResolution = cameraResolution;
        log("MobilePhone created with custom values.");
    }

    /**
     * Реалізація методу для відправки SMS.
     *
     * @param number номер отримувача
     * @param message текст повідомлення
     */
    @Override
    public void sendSMS(String number, String message) {
        log("Sending SMS to " + number + ": " + message);
    }

    /**
     * Реалізація методу для фотографування.
     */
    @Override
    public void takePhoto() {
        log("Taking photo with " + cameraResolution + "MP camera.");
    }

    /**
     * Отримати операційну систему телефону.
     * @return операційна система
     */
    public String getOperatingSystem() {
        log("Getting operating system.");
        return operatingSystem;
    }

    /**
     * Задати операційну систему телефону.
     * @param operatingSystem операційна система
     */
    public void setOperatingSystem(String operatingSystem) {
        log("Setting operating system to " + operatingSystem);
        this.operatingSystem = operatingSystem;
    }

    /**
     * Отримати роздільну здатність камери.
     * @return роздільна здатність камери в мегапікселях
     */
    public int getCameraResolution() {
        log("Getting camera resolution.");
        return cameraResolution;
    }

    /**
     * Задати роздільну здатність камери.
     * @param cameraResolution роздільна здатність камери в мегапікселях
     */
    public void setCameraResolution(int cameraResolution) {
        log("Setting camera resolution to " + cameraResolution + "MP");
        this.cameraResolution = cameraResolution;
    }

    /**
     * Перевизначений метод для завершення дзвінка.
     */
    @Override
    public void endCall() {
        super.endCall();
        log("MobilePhone: Call ended and resources freed.");
    }
}