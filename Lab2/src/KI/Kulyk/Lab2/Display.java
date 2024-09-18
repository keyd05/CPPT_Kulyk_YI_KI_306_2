package KI.Kulyk.Lab2;

/**
 * Клас для опису дисплея.
 */
public class Display {
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