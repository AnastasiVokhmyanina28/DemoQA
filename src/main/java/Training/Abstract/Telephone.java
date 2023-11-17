package Training.Abstract;

public class Telephone extends Gadget{
    private String modelName;
    private String modelNumber;
    private String brand;
    private boolean cameraMegapixelCount;


    public Telephone(String modelName, String modelNumber, String brand) {
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

    public boolean cameraDefinition(String type){
        if (type.equals("Стационарный")){
            System.out.println("Камера отсутствует");
            cameraMegapixelCount = false;
        } else if (type.equals("Смартфон")){
            System.out.println("Камера присутствует");
            cameraMegapixelCount = true;
        }
        return cameraMegapixelCount;
    }


}
