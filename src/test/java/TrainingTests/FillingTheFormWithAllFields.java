package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FillingTheFormWithAllFields extends BaseForm {
    private FormSteps steps = new FormSteps();
    private FormFrame frame = new FormFrame();


    @Epic("Заполнение формы")
    @Test(description = "Заполнение формы", testName = "Заполнение всех полей формы")

    public void fillInTheRequiredAndAdditionalFields() {

        /**
         * Шаг : Заполнение обязятельных полей
         * ОР : Введенные данные отображаются в полях
         */
        steps.fillInTheMandatoryFields();

        /**
         * Шаг : Заполнение дополнительных полей
         * ОР : Введенные данные отображаются в полях
         */
        steps.fillInAdditionalFields();

        /**
         * Шаг : Клик по кнопке 'Submit'
         * ОР : Откроется модальное окно с введенными данными
         */
        steps.clickButton();

        if (frame.formElements.modalWindowBody.shouldHave(Condition.exist).isDisplayed()) {

            assertThat(frame.formElements.getModalData().getFirstName()).isEqualTo(steps.testData.getFirstName());
            assertThat(frame.formElements.getModalData().getLastName()).isEqualTo(steps.testData.getLastName());
            assertThat(frame.formElements.getModalData().getMobile()).isEqualTo(steps.testData.getMobile());
            assertThat(frame.formElements.getModalData().getGender()).isEqualTo(steps.testData.getGender());
        }
    }

}
