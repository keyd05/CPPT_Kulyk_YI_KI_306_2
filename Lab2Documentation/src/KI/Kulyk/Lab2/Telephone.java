package KI.Kulyk.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Клас Telephone описує телефон.
 * Він складається з кількох частин: дисплея, батареї та процесора.
 */
public class Telephone {

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
     * @param display дисплей телефону
     * @param battery батарея телефону
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
     * @param message повідомлення для логування
     */
    private void log(String message) {
        if (logWriter != null) {
            logWriter.println(message);
        }
    }

    /**
     * Метод для завершення роботи з файлом логів.
     */
    public void closeLog() {
        log("Closing log file.");
        if (logWriter != null) {
            logWriter.close();
        }
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

    // Внутрішні класи для частин телефону

    /**
     * Клас для опису дисплея.
     */
    class Display {
        private String type;
        private double size;

        public Display(String type, double size) {
            this.type = type;
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getSize() {
            return size;
        }
    }

    /**
     * Клас для опису батареї.
     */
    class Battery {
        private int capacity;

        public Battery(int capacity) {
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
    }

    /**
     * Клас для опису процесора.
     */
    class Processor {
        private String model;
        private int cores;

        public Processor(String model, int cores) {
            this.model = model;
            this.cores = cores;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getCores() {
            return cores;
        }

        public void setCores(int cores) {
            this.cores = cores;
        }
    }
}
