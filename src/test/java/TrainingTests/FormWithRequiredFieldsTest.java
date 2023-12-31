package TrainingTests;

import ChromeDriver.BaseForm;
import Person.Student;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FormWithRequiredFieldsTest extends BaseForm {

    private FormSteps steps = new FormSteps();
    private FormFrame frame = new FormFrame();
    private Student testData = Student.randomized();

    @Epic("Заполнение формы")
    @Test(description = "Заполнение обязательных полей формы", testName = "Заполнение обязательных полей формы")

    public void fillInTheRequiredFields() {

        /**
         * Шаг : Заполнение обязятельных полей
         * ОР : Введенные данные отображаются в полях
         */
        steps.fillInTheMandatoryFields(testData);

        /**
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Откроется модальное окно с введенными данными
         */
        steps.clickButton();

        if (frame.formElements.modalWindowBody.shouldHave(Condition.exist).isDisplayed()) {

            assertThat(frame.formElements.getModalData().getFirstName()).isEqualTo(testData.getFirstName());
            assertThat(frame.formElements.getModalData().getLastName()).isEqualTo(testData.getLastName());
            assertThat(frame.formElements.getModalData().getMobile()).isEqualTo(testData.getMobile());
            assertThat(frame.formElements.getModalData().getGender()).isEqualTo(testData.getGender());
        }
    }
}
