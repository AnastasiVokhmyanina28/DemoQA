package TrainingTests;

import ChromeDriver.BaseForm;
import Person.Student;
import Training.DataGeneration.DataGeneration;
import Training.Matchers.CustomMatchers;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckFormWithAllFieldsTest extends BaseForm {

    private FormSteps steps = new FormSteps();
    private FormFrame formFrame = new FormFrame();
    private Student testData = Student.randomized();
    private DataGeneration generation = new DataGeneration();

    @Step("Проверка формы")
    @Test(description = "Проверка формы на валидацию полей", testName = "Проверка формы со всеми полями")
    public void checkFormWithAllFields() {

        /**
         * Шаг : Клик по кнопке 'Submit'
         * ОР :  Незаполненные обязательные поля подсвечиваются красным(Модальное окно не открывается)
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        /**
         * Шаг : Заполнение поля 'FirstName'
         * ОР : Отображается введенное значение
         */
        steps.fillingInTheName(testData.getFirstName());

        /**
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Незаполненный обязательные поля подсвечиваются красным(Модальное окно не открывается)
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        /**
         * Шаг : Заполнение поля 'LastName'
         * ОР : Отображается введенное значение
         */
        steps.fillingInTheLastName(testData.getLastName());

        /**
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Незаполненный обязательные поля подсвечиваются красным(Модальное окно не открывается)
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        /**
         * Шаг : Заполнение поля 'Email' некорректными данными (присутствуют символы кириллицы)
         * ОР : Поле подсвечивается красным
         */
        steps.fillingInTheEmail("email@exаmplе.com");

        /**
         * Шаг : Выбрать 2 гендера
         * ОР : Возможность выбрать только 1 гендер
         */
        steps.genderCheckTheSelection();
        assertThat(formFrame.formElements.maleGenderRadioButton.isSelected())
                .isNotEqualTo(formFrame.formElements.femaleGenderRadioButton.isSelected());

        /**
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Незаполненный обязательные поля подсвечиваются красным(Модальное окно не открывается)
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        /**
         * Шаг : Заполнение поля 'Mobile'(количество символов в строке превышает максимально допустимое - введено 16 символов)
         * ОР :  Отображаются только первые 10 символов от вводимой строки
         */
        steps.fillInThePhoneNumber("1234567890123");
        assertThat(formFrame.formElements.phoneNumber.getValue().length()).isEqualTo(Integer.valueOf(formFrame.formElements.phoneNumber.getAttribute("maxlength")));

        /**
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Поле 'Email' подсвечивается красным(Модальное окно не открывается)
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        /**
         * Шаг : Очистить поле 'Email' и заполнить корректными данными
         * ОР : Поле 'Email' подсвечивается зеленым
         */
        generation.clearTheField(formFrame.formElements.email);

        /**
         * Шаг : Заполнение поля 'Email' корректными данными
         * ОР : Поле подсвечивается зеленым
         */
        steps.fillingInTheEmail("name@example.com");

        /**
         * Шаг : Выбрать дату рождения, у которой год больше текущего
         * ОР : В поле 'Date of Birth' отобразится полная дата(но сохранение невозможно)
         */
        steps.chooseAYearOfBirth(2024);
//        MatcherAssert.assertThat(
//                Integer.parseInt(formFrame.formElements.dateOfBirth.getValue().split(" ")[2].toString()),
//                new CustomMatchers(1920, LocalDate.now().getYear())
//        );

        /**
         * Шаг : Клик по кнопке 'Submit'
         * ОР :  Отсутствует возможность сохранить форму, так как указан год, больше текущего(Модальное окно не открывается)
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        if (formFrame.formElements.modalWindowBody.shouldHave(Condition.exist).isDisplayed()) {
            assertThat(formFrame.formElements.getModalData().getLastName()).isEqualTo(testData.getLastName());
            assertThat(formFrame.formElements.getModalData().getFirstName()).isEqualTo(testData.getFirstName());
        }
    }
}
