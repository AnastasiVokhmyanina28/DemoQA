package TrainingTests;

import ChromeDriver.BaseForm;
import Person.Student;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckingAFormWithMandatoryFieldsTest extends BaseForm {

    private FormSteps steps = new FormSteps();
    private FormFrame formFrame = new FormFrame();
    private Student testData = Student.randomized();


    @Epic("Проверка формы")
    @Test(description = "Проверка формы - обязательные поля", testName = "Проверка формы с обязательными полями")

    public void CheckingAForm() {

        /**
         * Шаг : Заполнение обязятельных полей
         * ОР : Введенные данные отображаются в полях
         */
        steps.checkingAFormWithMandatoryFieldsTest(testData);

        /**
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Откроется модальное окно с введенными данными
         */
        steps.clickButton();

        /**
         Проверка, что выбран только 1 гендер
         */
        assertThat(formFrame.formElements.maleGenderRadioButton.isSelected())
                .isNotEqualTo(formFrame.formElements.femaleGenderRadioButton.isSelected());

        /**
         Проверка, что количество символов в поле равняется maxlength
         */
        assertThat(formFrame.formElements.phoneNumber.getValue().length()).isEqualTo(Integer.valueOf(formFrame.formElements.phoneNumber.getAttribute("maxlength")));

        if (formFrame.formElements.modalWindowBody.shouldHave(Condition.exist).isDisplayed()) {
            assertThat(formFrame.formElements.getModalData().getFirstName()).isEqualTo(testData.getFirstName());
            assertThat(formFrame.formElements.getModalData().getLastName()).isEqualTo(testData.getLastName());
        }
    }
}
