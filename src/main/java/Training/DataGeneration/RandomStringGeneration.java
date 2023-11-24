package Training.DataGeneration;

import com.codeborne.selenide.ElementsCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStringGeneration {
    public static String randomize(ElementsCollection elements, String attribute) {
        Random random = new Random();
        int i = random.nextInt(elements.size() - 1);

        List list = new ArrayList();
        elements.stream().forEach(x -> list.add(x.getAttribute(attribute)));
        return list.get(i).toString();
    }
}
