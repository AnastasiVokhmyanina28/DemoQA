package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class CheckingAFormWithMandatoryFieldsTest extends BaseForm {

    private static FormSteps steps = new FormSteps();
    private static FormFrame formFrame = new FormFrame();

    @Epic("Проверка формы")
    @Test(description = "Проверка формы с обязательными полями", testName = "Проверка формы с обязательными полями")

    public void CheckingAForm() {

        /*
         * Шаг : Клик по кнопке 'Submit'
         * ОР :  Незаполненный обязательные поля выделяются красной рамкой(Модальное окно не открывается)
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        /*
         * Шаг : Заполнение поля 'FirstName'
         * ОР : Отображается введенное значение
         */
        steps.fillingInTheName("Андрей");

        /*
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Незаполненный обязательные поля выделяются красной рамкой(Модальное окно не открывается)
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        /*
         * Шаг : Заполнение поля 'LastName'
         * ОР : Отображается введенное значение
         */
        steps.fillingInTheLastName("Корев");

        /*
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Незаполненный обязательные поля выделяются красной рамкой(Модальное окно не открывается)
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        /*
         * Шаг : Выбрать 2 гендера
         * ОР : Возможность выбрать только 1 гендер
         */
        steps.genderCheckTheSelection();
        Assertions.assertThat(formFrame.formElements.maleGenderRadioButton.isSelected())
                .isNotEqualTo(formFrame.formElements.femaleGenderRadioButton.isSelected());

        /*
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Незаполненный обязательные поля выделяются красной рамкой(Модальное окно не открывается)
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        /*
         * Шаг : Заполнение поля 'Mobile'(количество символов в строке превышает максимально допустимое - введено 16 символов)
         * ОР :  Отображаются только первые 10 символов от вводимой строки
         */
        steps.fillInThePhoneNumber("1234567890123");
        Assertions.assertThat(formFrame.formElements.phoneNumber.getValue().length()).isEqualTo(Integer.valueOf(formFrame.formElements.phoneNumber.getAttribute("maxlength")));

        /*
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Откроется модальное окно с введенными данными
         */
        steps.clickButton();
        formFrame.formElements.buttonClose.shouldBe(Condition.visible);
    }

}
