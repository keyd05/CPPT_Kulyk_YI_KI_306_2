package KI.Kulyk.Lab2;

/**
 * Клас для опису процесора.
 */
public class Processor {
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
