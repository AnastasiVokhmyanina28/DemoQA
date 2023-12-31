package TrainingTests;

import ChromeDriver.BaseForm;
import Person.Student;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckFormWithAllFieldsTest extends BaseForm {

    private FormSteps steps = new FormSteps();
    private FormFrame formFrame = new FormFrame();
    private Student testData = Student.randomized();

    @Step("Проверка формы")
    @Test(description = "Проверка формы на валидацию полей", testName = "Проверка формы со всеми полями")
    public void checkFormWithAllFields() {

        /**
         * Шаг : Заполнение обязятельных полей
         * ОР : Введенные данные отображаются в полях
         */
        steps.checkingAFormWithMandatoryFieldsTest(testData);

        /**
         * Шаг : Заполнение дополнительных полей
         * ОР : Введенные данные отображаются в полях
         */
        steps.checkingAFormAdditionalFields();

        /**
        Проверка, что выбран только 1 гендер
         */
        assertThat(formFrame.formElements.maleGenderRadioButton.isSelected())
                .isNotEqualTo(formFrame.formElements.femaleGenderRadioButton.isSelected());

        /**
         Проверка, что количество символов в поле равняется maxlength
         */
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
