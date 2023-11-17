package Training.Polymorphism;

public class Rectangle extends Square {
    @Override
    public void calculateTheArea(int l, int d) {
        System.out.println("Площадь прямоугольника = " + l * d);
    }
}
