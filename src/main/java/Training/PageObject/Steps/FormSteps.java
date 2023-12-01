package Training.PageObject.Steps;

import Training.DataGeneration.DataGeneration;
import Training.PageObject.Frame.FormFrame;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

import java.io.File;

public class FormSteps {
    public static FormFrame frame = new FormFrame();
    public static DataGeneration generation = new DataGeneration();

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
    public void selectGender(String value) {
        frame.formElements.selectGender(value);
    }

    @Step("Некорректное заполнение поля 'Mobile'")
    public void fillInThePhoneNumber(String number) {
        frame.formElements.phoneNumber.val(number);
    }

    @Step("Выбрать 'Date of Birth'")
    public void chooseAYearOfBirth(String year) {
        frame.formElements.dateOfBirth.click();

        frame.formElements.yearField.click();
        frame.formElements.chooseYearOfBirth(year).click();

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
        if (frame.formElements.footer.isDisplayed()) {
            generation.deleteFooter();
        }
        frame.formElements.button.shouldBe(visible).click();
    }

    @Step("Попытка выбрать 2 гендера")
    public void genderCheckTheSelection() {
        frame.formElements.maleGender.click();
        frame.formElements.femaleGender.click();
    }

}
