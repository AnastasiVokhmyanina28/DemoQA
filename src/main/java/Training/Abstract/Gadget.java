package Training.Abstract;

public abstract class Gadget {

    private String modelName;
    private String modelNumber;
    private String brand;

    public Gadget(String modelName, String modelNumber, String brand) {
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.brand = brand;
    }

    public Gadget() {
    }

    public abstract String getModelName();

    public abstract String getModelNumber();

    public abstract String getBrand();
}
