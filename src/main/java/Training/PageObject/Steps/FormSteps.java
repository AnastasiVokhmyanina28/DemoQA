package Training.PageObject.Steps;

import Training.PageObject.Frame.FormFrame;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

import static com.codeborne.selenide.Condition.visible;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormSteps {
    public static FormFrame frame = new FormFrame();

    @Step("Заполнение поля FirstName")
    public void fillingInTheName() {
        frame.formElements.firstName.val("Александр");
    }

    @Step("Заполнение поля LastName")
    public void fillingInTheLastName() {
        frame.formElements.lastName.val("Шилов");
    }

    @Step("Заполнение поля Email")
    public void fillingInTheEmail() {
        frame.formElements.email.val("Shilov77alex@gmail.com");
    }


    private String getIdGender() {
        Random random = new Random();
        int i = random.nextInt(frame.formElements.gender.size() - 1);
        List elements = new ArrayList();

        frame.formElements.gender
                .stream()
                .forEach(x -> elements.add(x.getAttribute("id")));
        return elements.get(i).toString();
    }

    @Step("Выбрать гендер")
    public void selectGender() {
        $x("//label[@for = '" + getIdGender() + "']").click();
    }

    private String numberGeneration() {
        return RandomStringUtils.randomNumeric(10);
    }

    @Step("Заполнение поля Mobile")
    public void fillInThePhoneNumber() {
        frame.formElements.phoneNumber.val(numberGeneration());
    }

    @Step("Клик по кнопке 'Submit'")
    public void clickButton() {
        executeJavaScript("document.getElementsByTagName(\"footer\").item(0).remove()");
        frame.formElements.button.shouldBe(visible).click();
    }

}
