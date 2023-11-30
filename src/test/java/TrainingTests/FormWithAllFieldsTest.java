package TrainingTests;

import ChromeDriver.BaseForm;
import Person.Student;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

public class FormWithAllFieldsTest extends BaseForm {
    private FormSteps steps = new FormSteps();
    private FormFrame frame = new FormFrame();
    private Student testData = Student.randomized();

    @Epic("Заполнение формы")
    @Test(description = "Заполнение обязательных и дополнительных полей формы", testName = "Заполнение обязательных и дополнительных полей формы")

    public void fillInTheRequiredAndAdditionalFields() {

        /*
         * Шаг : Заполнение поля 'FirstName'
         * ОР : Отображается введенное значение
         */
        steps.fillingInTheName("Александр");

        /*
         * Шаг : Заполнение поля 'LastName'
         * ОР : Отображается введенное значение
         */
        steps.fillingInTheLastName("Шилов");

        /*
         * Шаг : Зполнение поля 'Email'
         * ОР : Отображается введенное значение
         */
        steps.fillingInTheEmail("Shilov77alex@gmail.com");

        /*
         * Шаг : Выбрать 'Gender'
         * ОР : Выбрана радиокнопка(элемент становится активным)
         */
        steps.selectGender(testData.getGender().getGender());

        /*
         * Шаг : Заполнение поля 'Mobile'
         * ОР :  Отображается введенное значение
         */
        steps.fillInThePhoneNumber(testData.getMobile());

        /*
         * Шаг : Выбрать дату рождения
         * ОР : В поле 'Date of Birth' отобразится полная дата
         */
        steps.chooseAYearOfBirth();

        /*
         * Шаг : Выбрать элемент 'Subjects' из выпадающего списка
         * ОР : В поле отобразится выбранный элемент
         */
        steps.chooseOfSubjects("o");

        /*
         * Шаг : Выбрать 'Hobbies'
         * ОР : Выбранный чекбокс активен
         */
        steps.chooseHobbies();

        /*
         * Шаг : Загрузить файл
         * ОР : Отображается название выбранного файла
         */
        steps.fileUpload();

        /*
         * Шаг : Заполнение поля 'Current Address'
         * ОР : Отображается введенное значение
         */
        steps.enterAddress("Кострома");

        /*
         * Шаг : Выбрать 'State'
         * ОР : Отображается выбранное значение
         */
        steps.chooseState();

        /*
         * Шаг : Выбрать 'City'
         * ОР : Отображается выбранное значение
         */
        steps.chooseCity();

        /*
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Откроется модальное окно с введенными данными
         */
        steps.clickButton();

        frame.formElements.buttonClose.shouldHave();
    }

}
