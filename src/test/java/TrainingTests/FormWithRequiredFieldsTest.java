package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FormWithRequiredFieldsTest extends BaseForm {
    public FormSteps steps = new FormSteps();
    public static FormFrame frame = new FormFrame();

    @Epic("Заполнение формы")
    @Description("Заполнение обязательных полей формы")
    @DisplayName("Заполнение обязательных полей формы")
    @Test
    public void fillInTheRequiredFields() {
        /*
         * Шаг : Заполнение поля 'FirstName'
         * ОР : Отображается введенное значение
         */
        steps.fillingInTheName("Марина");

        /*
         * Шаг : Заполнение поля 'LastName'
         * ОР : Отображается введенное значение
         */
        steps.fillingInTheLastName("Булычева");
        /*
         * Шаг : Зполнение поля 'Email'
         * ОР : Отображается введенное значение
         */
        steps.fillingInTheEmail("mari77n@gmail.com");
        /*
         * Шаг : Выбрать 'Gender'
         * ОР : Выбран чекбокс(элемент становится активным)
         */
        steps.selectGender();
        /*
         * Шаг : Заполнение поля 'Mobile'
         * ОР :  Отображается введенное значение
         */
        steps.fillInThePhoneNumber();

        /*
         * Шаг : Выбрать дату рождения
         * ОР : В поле 'Date of Birth' отобразится полная дата
         */
        steps.chooseAYearOfBirth();

        /*
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Откроется модальное окно с введенными данными
         */
        steps.clickButton();

        frame.formElements.modalWindowBody.shouldHave();
//        Assertions.assertThat(frame.formElements.buttonClose.isEnabled()).as("Кнопка модального окна активна");
    }

}
