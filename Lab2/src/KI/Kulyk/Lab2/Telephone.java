package KI.Kulyk.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Telephone {
    private Screen screen;
    private Battery battery;
    private Processor processor;
    private FileWriter logFile;

    // Constructor without parameters
    public Telephone() throws IOException {
        this.screen = new Screen(6.0, "1080p");
        this.battery = new Battery(3000);
        this.processor = new Processor("Qualcomm", 2.0);
        openLogFile();
        log("Telephone created with default values.");
    }

    // Constructor with parameters
    public Telephone(Screen screen, Battery battery, Processor processor) throws IOException {
        this.screen = screen;
        this.battery = battery;
        this.processor = processor;
        openLogFile();
        log("Telephone created with custom values.");
    }

    // Method to open the log file
    private void openLogFile() throws IOException {
        logFile = new FileWriter("telephone_log.txt", true);
        log("Log file opened.");
    }

    // Method to log activities
    private void log(String message) throws IOException {
        logFile.write(LocalDateTime.now() + ": " + message + "\n");
    }

    // Getter for screen
    public Screen getScreen() {
        return screen;
    }

    // Setter for screen
    public void setScreen(Screen screen) throws IOException {
        this.screen = screen;
        log("Screen updated.");
    }

    // Getter for battery
    public Battery getBattery() {
        return battery;
    }

    // Setter for battery
    public void setBattery(Battery battery) throws IOException {
        this.battery = battery;
        log("Battery updated.");
    }

    // Getter for processor
    public Processor getProcessor() {
        return processor;
    }

    // Setter for processor
    public void setProcessor(Processor processor) throws IOException {
        this.processor = processor;
        log("Processor updated.");
    }

    // Method to simulate turning on the phone
    public void turnOn() throws IOException {
        log("Telephone turned on.");
    }

    // Method to simulate turning off the phone
    public void turnOff() throws IOException {
        log("Telephone turned off.");
        closeLogFile();
    }

    // Method to close the log file
    private void closeLogFile() throws IOException {
        logFile.write(LocalDateTime.now() + ": Log file closed.\n");
        logFile.close();
    }

    // Method to simulate a call
    public void makeCall(String number) throws IOException {
        log("Calling " + number + "...");
    }

    // Method to check battery status
    public int checkBattery() {
        return battery.getCapacity();
    }

}

class Screen {
    private double size;
    private String resolution;

    public Screen(double size, String resolution) {
        this.size = size;
        this.resolution = resolution;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
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
    private String brand;
    private double speed;

    public Processor(String brand, double speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}

