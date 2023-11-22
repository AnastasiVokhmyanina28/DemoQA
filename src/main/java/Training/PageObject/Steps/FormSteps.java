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

    @Step("Заполнение поля 'FirstName'")
    public void fillingInTheName(String name) {
        frame.formElements.firstName.val(name);
    }

    @Step("Заполнение поля 'LastName'")
    public void fillingInTheLastName(String lastName) {
        frame.formElements.lastName.val(lastName);
    }

    @Step("Заполнение поля 'Email'")
    public void fillingInTheEmail(String email) {
        frame.formElements.email.val(email);
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

    @Step("Выбрать 'Gender'")
    public void selectGender() {
        $x("//label[@for = '" + getIdGender() + "']").click();
    }

    private String numberGeneration() {
        return RandomStringUtils.randomNumeric(10);
    }

    @Step("Заполнение поля 'Mobile'")
    public void fillInThePhoneNumber() {
        frame.formElements.phoneNumber.val(numberGeneration());
    }

    @Step("Клик по полю 'Date of Birth'")
    public void clickOnTheBirthdayField() {
        frame.formElements.dateOfBirth.click();
    }

    @Step("Выбрать год рождения")
    public void chooseAYearOfBirth() {
        frame.formElements.yearField.click();

        List year = new ArrayList();
        frame.formElements.chooseYearOfBirth.stream().forEach(x -> year.add(x.getAttribute("value")));

        $x("//option[@value = '" + year.stream().filter(x -> x.equals("1998")).findFirst().get() + "']").click();
    }

    @Step("Выбрать месяц рождения")
    public void chooseAMonthOfBirth() {
        frame.formElements.mounthField.click();

        List mounth = new ArrayList();
        frame.formElements.chooseOfMonthOfBirth.stream().forEach(x -> mounth.add(x.getAttribute("value")));

//        $x("//option[@value = '" + mounth.stream().filter(x -> x.equals("1998")).findFirst().get() + "']").click();
    }

    @Step("Клик по кнопке 'Submit'")
    public void clickButton() {
        executeJavaScript("document.getElementsByTagName(\"footer\").item(0).remove()");
        frame.formElements.button.shouldBe(visible).click();
    }

}
