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

    /*
     * Шаг : заполняется поле 'Name'
     * ОР : Поле будет заполнено
     */
    @Step("Заполнение поля FirstName")
    public void fillingInTheName(String name) {
        frame.formElements.firstName.val(name);
    }

    /*
     * Шаг : заполняется поле 'LastName'
     * ОР : Поле будет заполнено строковым значением
     */
    @Step("Заполнение поля LastName")
    public void fillingInTheLastName(String lastName) {
        frame.formElements.lastName.val(lastName);
    }

    /*
     * Шаг : заполняется поле 'Email'
     * ОР : Поле будет заполнено строковым значением
     */
    @Step("Заполнение поля Email")
    public void fillingInTheEmail(String email) {
        frame.formElements.email.val(email);
    }


    /*
     * Шаг : Рандомно выбираем индекс элемента из возможных
     *       Получаем id элементов
     *       Добавляем в список
     *       Получаем id гендера по индексу
     * ОР :  Получаем строковое значение - id гендера
     */
    private String getIdGender() {
        Random random = new Random();
        int i = random.nextInt(frame.formElements.gender.size() - 1);
        List elements = new ArrayList();

        frame.formElements.gender
                .stream()
                .forEach(x -> elements.add(x.getAttribute("id")));
        return elements.get(i).toString();
    }

    /*
     * Шаг : в xPath подставляется id элемента 'гендер'
     *       Клик по SelenideElement
     * ОР : Выбран чекбокс(элемент становится активным)
     */
    @Step("Выбрать гендер")
    public void selectGender() {
        $x("//label[@for = '" + getIdGender() + "']").click();
    }

    /*
     * Шаг : Генерируется строка, состоящая из 10 цифровых символов
     * ОР : Получаем строковое значение - номер телефона
     */
    private String numberGeneration() {
        return RandomStringUtils.randomNumeric(10);
    }

    //todo переименовать поле
    /*
     * Шаг : Заполняется поле 'Phone'
     * ОР :  Поле  номер телефона заполнено
     */
    @Step("Заполнение поля Mobile")
    public void fillInThePhoneNumber() {
        frame.formElements.phoneNumber.val(numberGeneration());
    }

    //todo переименовать поле
    /*
     * Шаг : Клик по полю 'День рождения'
     * ОР : Откроется календарь
     */
    @Step("Клик по полю 'День Рождения'")
    public void clickOnTheBirthdayField() {
        frame.formElements.dateOfBirth.click();
    }

    /*
     * Шаг : Клик по "год"
     *       Выбрать 1 значение из списка
     * ОР :  В поле появится выбранная дата
     */
    @Step("Выбрать год рождения")
    public void chooseAYearOfBirth() {
        frame.formElements.yearField.click();

        List year = new ArrayList();
        frame.formElements.chooseYearOfBirth.stream().forEach(x -> year.add(x.getAttribute("value")));

        $x("//option[@value = '" + year.stream().filter(x -> x.equals("1998")).findFirst().get() + "']").click();
    }


    /*
     * Шаг : Клик по "месяц"
     *       Выбрать 1 значение из списка
     * ОР :  В поле появится выбранная дата
     */
    @Step("Выбрать месяц рождения")
    public void chooseAMonthOfBirth() {
        frame.formElements.mounthField.click();

        List mounth = new ArrayList();
        frame.formElements.chooseOfMonthOfBirth.stream().forEach(x -> mounth.add(x.getAttribute("value")));

//        $x("//option[@value = '" + mounth.stream().filter(x -> x.equals("1998")).findFirst().get() + "']").click();
    }


    /*
     * Шаг : Клик по кнопке 'Submit'
     * ОР : Появится модальное окно с указанными данными
     */
    @Step("Клик по кнопке 'Submit'")
    public void clickButton() {
        executeJavaScript("document.getElementsByTagName(\"footer\").item(0).remove()");
        frame.formElements.button.shouldBe(visible).click();
    }

}
