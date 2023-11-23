package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Steps.FormSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FormWithAllFieldsTest extends BaseForm {

    private FormSteps steps = new FormSteps();

    @Epic("Заполнение формы")
    @Description("Заполнение обязательных и дополнительных полей формы")
    @DisplayName("Заполнение обязательных и дополнительных полей формы")
    @Test
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
         * Шаг : Выбрать элемент 'Subjects' из выпадающего списка
         * ОР : В поле отобразится выбранный элемент
         */
        steps.chooseOfSubjects("o");
        /*
         * Шаг : Выбрать 'Hobbies'
         * ОР : Выбранный чекбокс активен
         */
        steps.chooseHobbies();

        //todo не срабатывает клик(переделать селектор)
        /*
         * Шаг : Загрузить файл
         * ОР :
         */
//        steps.fileUpload();
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
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Откроется модальное окно с введенными данными
         */
        steps.clickButton();


    }


}
