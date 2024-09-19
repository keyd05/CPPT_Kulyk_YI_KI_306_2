package KI.Kulyk.Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Клас Telephone описує телефон.
 * Він складається з кількох частин: дисплея, батареї та процесора.
 */
public abstract class Telephone {

    private Display display;
    private Battery battery;
    private Processor processor;
    private PrintWriter logWriter;

    /**
     * Конструктор за замовчуванням.
     */
    public Telephone() {
        this.display = new Display("OLED", 6.1);
        this.battery = new Battery(4000);
        this.processor = new Processor("Snapdragon", 8);
        initializeLogger();
        log("Telephone created with default values.");
    }

    /**
     * Конструктор з параметрами.
     *
     * @param display   дисплей телефону
     * @param battery   батарея телефону
     * @param processor процесор телефону
     */
    public Telephone(Display display, Battery battery, Processor processor) {
        this.display = display;
        this.battery = battery;
        this.processor = processor;
        initializeLogger();
        log("Telephone created with custom values.");
    }

    /**
     * Ініціалізація логера.
     */
    private void initializeLogger() {
        try {
            logWriter = new PrintWriter(new FileWriter("telephone_log.txt", true));
        } catch (IOException e) {
            System.out.println("Unable to open log file.");
        }
    }

    /**
     * Метод для логування повідомлень.
     *
     * @param message повідомлення для логування
     */
    protected void log(String message) {
        if (logWriter != null) {
            logWriter.println(LocalDateTime.now() + " - " + message);
        }
    }

    /**
     * Метод для завершення роботи з файлом логів.
     */
    protected void closeLog() {
        log("Closing log file.");
        if (logWriter != null) {
            logWriter.close();
        }
    }

    /**
     * Зробити дзвінок.
     */
    public void makeCall(String number) {
        log("Calling to " + number + '.');
    }

    /**
     * Завершити дзвінок.
     */
    public void endCall() {

        log("Call is ended.");
    }

    /**
     * Отримати тип дисплея.
     * @return тип дисплея
     */
    public String getDisplayType() {
        log("Getting display type.");
        return display.getType();
    }

    /**
     * Задати тип дисплея.
     * @param type тип дисплея
     */
    public void setDisplayType(String type) {
        log("Setting display type to " + type);
        display.setType(type);
    }

    /**
     * Отримати ємність батареї.
     * @return ємність батареї
     */
    public int getBatteryCapacity() {
        log("Getting battery capacity.");
        return battery.getCapacity();
    }

    /**
     * Задати ємність батареї.
     * @param capacity ємність батареї
     */
    public void setBatteryCapacity(int capacity) {
        log("Setting battery capacity to " + capacity);
        battery.setCapacity(capacity);
    }

    /**
     * Отримати тип процесора.
     * @return тип процесора
     */
    public String getProcessorType() {
        log("Getting processor type.");
        return processor.getModel();
    }

    /**
     * Задати тип процесора.
     * @param model тип процесора
     */
    public void setProcessorType(String model) {
        log("Setting processor type to " + model);
        processor.setModel(model);
    }
}