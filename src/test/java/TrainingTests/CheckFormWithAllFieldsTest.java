package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckFormWithAllFieldsTest extends BaseForm {

    private FormSteps steps = new FormSteps();
    private FormFrame formFrame = new FormFrame();

    @Step("Проверка формы")
    @Test(description = "Проверка формы на валидацию полей", testName = "Проверка формы со всеми полями")
    public void checkFormWithAllFields() {

        steps.checkingAFormWithMandatoryFieldsTest();
        steps.checkingAFormAdditionalFields();

        assertThat(formFrame.formElements.maleGenderRadioButton.isSelected())
                .isNotEqualTo(formFrame.formElements.femaleGenderRadioButton.isSelected());

        assertThat(formFrame.formElements.phoneNumber.getValue().length()).isEqualTo(Integer.valueOf(formFrame.formElements.phoneNumber.getAttribute("maxlength")));

        formFrame.formElements.buttonClose.shouldNotBe(Condition.visible);

        /**проверка, что значение входит в промежуток
         */
//        MatcherAssert.assertThat(
//                Integer.parseInt(formFrame.formElements.dateOfBirth.getValue().split(" ")[2].toString()),
//                new CustomMatchers(1920, LocalDate.now().getYear())
//        );
    }
}
