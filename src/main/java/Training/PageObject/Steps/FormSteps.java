package Training.PageObject.Steps;

import Training.DataGeneration.NumberGeneration;
import Training.DataGeneration.RandomStringGeneration;
import Training.PageObject.Frame.FormFrame;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import java.io.File;

public class FormSteps {
    public static FormFrame frame = new FormFrame();
    public static RandomStringGeneration generation = new RandomStringGeneration();
    private static NumberGeneration numberGeneration = new NumberGeneration();

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

    @Step("Выбрать 'Gender'")
    public void selectGender() {
        frame.formElements.getGender(generation.randomize(frame.formElements.gender, "id")).click();
    }


    @Step("Заполнение поля 'Mobile'")
    public void fillInThePhoneNumber() {
        frame.formElements.phoneNumber.val(numberGeneration.numberGeneration());
    }

    @Step("Выбрать 'Date of Birth'")
    public void chooseAYearOfBirth() {
        frame.formElements.dateOfBirth.click();

        frame.formElements.yearField.click();
        frame.formElements.chooseYearOfBirth.click();

        frame.formElements.mounthField.click();
        frame.formElements.chooseOfMonthOfBirth.click();

        frame.formElements.chooseOfDayOfBirth.click();
    }

    @Step("Выбрать 'Subjects'")
    public void chooseOfSubjects(String symbol) {

        frame.formElements.subject.val(symbol);
        if (frame.formElements.themeDropDownMenu.isDisplayed()) {
            frame.formElements.getSubject(generation.randomize(frame.formElements.subjectList, "class")).click();
        }
    }

    @Step("Выбрать 'Hobbies'")
    public void chooseHobbies() {
        frame.formElements.getHobbies(generation.randomize(frame.formElements.hobbies, "id")).click();
    }

    @Step("Загрузить файл")
    public void fileUpload() {
        File file = new File("src/main/resources/file/Resume.doc");
        frame.formElements.fileUpload.sendKeys(file.getAbsolutePath());
    }

    @Step("Заполнение поля 'Current Address'")
    public void enterAddress(String adress) {
        frame.formElements.currentAddress.setValue(adress);
    }

    @Step("Выбрать 'State'")
    public void chooseState() {
        frame.formElements.statesField.click();

        if (frame.formElements.stateAndCityFieldDropDownMenu.isDisplayed()) {
            frame.formElements.getState(generation.randomize(frame.formElements.state, "id")).click();
        }
    }

    @Step("Выбрать 'City'")
    public void chooseCity() {
        frame.formElements.cityField.click();

        if (frame.formElements.stateAndCityFieldDropDownMenu.isDisplayed()) {
            frame.formElements.getCity(generation.randomize(frame.formElements.city, "id")).click();
        }
    }

    @Step("Клик по кнопке 'Submit'")
    public void clickButton() {
        executeJavaScript("document.getElementsByTagName(\"footer\").item(0).remove()");
        frame.formElements.button.shouldBe(visible).click();
    }

}
