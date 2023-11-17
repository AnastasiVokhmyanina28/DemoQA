package Training.Polymorphism;

public class Circle extends Square {

    @Override
    public void calculateTheArea(int r) {
        System.out.println("Площадь круга = " + 3.14 * r * r);
    }
}
