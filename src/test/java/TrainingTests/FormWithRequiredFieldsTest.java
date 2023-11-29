package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class FormWithRequiredFieldsTest extends BaseForm {
    public FormSteps steps = new FormSteps();
    public static FormFrame frame = new FormFrame();

    @Epic("Заполнение формы")
    @Test(description = "Заполнение обязательных полей формы", testName = "Заполнение обязательных полей формы")

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
         * ОР : Выбрана радиокнопка(элемент становится активным)
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

        frame.formElements.modalWindowBody.shouldHave(Condition.exist);
//        Assertions.assertThat(frame.formElements.buttonClose.isEnabled()).as("Кнопка модального окна активна");
    }

}
