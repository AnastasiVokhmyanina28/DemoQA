package Training.Abstract;

public class TV extends Gadget{
    private String modelName;
    private String modelNumber;
    private String brand;
    private boolean wallMount;


    public TV(String modelName, String modelNumber, String brand) {
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.brand = brand;
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public String getModelNumber() {
        return modelNumber;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    //переделать
    public boolean wallMounting(String brand){
        if (brand.equals("Sumsung")){
            return true;
        } else
            return false;
    }
}
