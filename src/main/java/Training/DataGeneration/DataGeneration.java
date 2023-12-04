package Training.DataGeneration;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;

import static com.codeborne.selenide.Selenide.*;

import java.util.*;

public class DataGeneration {

    public static String randomize(ElementsCollection elements, String attribute) {
        Random random = new Random();
        int i = random.nextInt(elements.size() - 1);

        List list = new ArrayList();
        elements.stream().forEach(x -> list.add(x.getAttribute(attribute)));
        return list.get(i).toString();
    }

    public static void deleteFooter() {
        executeJavaScript("document.getElementsByTagName(\"footer\").item(0).remove()");
    }

    public static void clearTheField(SelenideElement element){
        element.clear();
    }

}
