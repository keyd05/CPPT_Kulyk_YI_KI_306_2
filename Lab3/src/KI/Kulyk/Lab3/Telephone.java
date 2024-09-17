package KI.Kulyk.Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Абстрактний клас Telephone описує основні частини телефону.
 * Він містить дисплей, батарею та процесор.
 */
public abstract class Telephone {

    protected Display display;
    protected Battery battery;
    protected Processor processor;
    protected PrintWriter logWriter;

    /**
     * Конструктор за замовчуванням.
     */
    public Telephone() {
        this.display = new Display("OLED", 6.1);
        this.battery = new Battery(4000);
        this.processor = new Processor("Snapdragon", 8);
        initializeLogger();
        log("Abstract Telephone created with default values.");
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
        log("Abstract Telephone created with custom values.");
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
    protected void log(String message) {
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

    // Абстрактний метод для конкретних підкласів
    public abstract void makeCall(String number);

    // Внутрішні класи для частин телефону

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
