package Training;

import Training.Abstract.TV;
import Training.Abstract.Telephone;
import Training.PageObject.Steps.HistoryOfOperationsSteps;
import Training.Polymorphism.Circle;
import Training.Polymorphism.Rectangle;

public class Main {
    public static void main(String[] args) {
//  todo     List, HashMap, HashSet
        HistoryOfOperationsSteps.currentMonthThirdMethod();
        HistoryOfOperationsSteps.currentMonthFourthMethod(7);
        HistoryOfOperationsSteps.currentMonthHashSet();

// todo
// Абстракция
        Telephone telephone = new Telephone("Galaxy S23", "SM-S9110", "Samsung");
        String a = telephone.getModelNumber();
        System.out.println(a);

        TV tv = new TV("Philips 6908", "32PFS6908/05", "Philips");
        String brand = tv.getBrand();
        if (tv.wallMounting(brand)) {
            System.out.println(tv.getModelName());
            System.out.println(tv.getModelNumber());
        }
        System.out.println(brand);

        //полиморфизм
        Circle circle = new Circle();
        circle.calculateTheArea(4);
        Rectangle rectangle = new Rectangle();
        rectangle.calculateTheArea(4, 6);
    }
}
