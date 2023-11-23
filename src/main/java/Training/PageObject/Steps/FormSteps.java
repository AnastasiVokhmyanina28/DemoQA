package Training.PageObject.Steps;

import Training.PageObject.Frame.FormFrame;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Step("Выбрать дату дня рождения")
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
            List subjectList = new ArrayList();

            frame.formElements.subjectList.stream()
                    .forEach(x -> subjectList.add(x.getAttribute("class")));
            $x("//div[@class = '" + subjectList.get(1) + "']").click();
        }
    }

    @Step("Выбрать 'Hobbies'")
    public void chooseHobbies() {
        List hobbiesList = new ArrayList();
        frame.formElements.hobbies.stream().forEach(x -> hobbiesList.add(x.getAttribute("id")));
        $x("//label[@for = '" + hobbiesList.get(0) + "']").click();
        $x("//label[@for = '" + hobbiesList.get(2) + "']").click();

        System.out.println(hobbiesList);
    }

//    @Step("Загрузить файл")
//    public void fileUpload(){
//        frame.formElements.fileUpload.click();
////                uploadFromClasspath("src/main/resources/file/Resume.doc");
//    }

    @Step("Заполнение поля 'Current Address'")
    public void enterAddress(String adress) {
        frame.formElements.currentAddress.setValue(adress);
    }

    //todo переделать  локатор
    @Step
    public void chooseState() {
        frame.formElements.statesField.click();

        List stateList = new ArrayList();

        frame.formElements.state.stream().forEach(x -> stateList.add(x.getAttribute("id")));

        $("//div[@class = '" + stateList.get(0)).click();
    }


    @Step("Клик по кнопке 'Submit'")
    public void clickButton() {
        executeJavaScript("document.getElementsByTagName(\"footer\").item(0).remove()");
        frame.formElements.button.shouldBe(visible).click();

    }

}
