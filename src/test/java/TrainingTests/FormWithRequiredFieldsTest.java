package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class FormWithRequiredFieldsTest extends BaseForm {
    public FormSteps steps = new FormSteps();
    public static FormFrame frame = new FormFrame();

    @Epic("Заполнение формы")
    @Description("Заполнение обязательных полей формы")
    @Test
    public void fillInTheRequiredFields() {
        steps.fillingInTheName("Марина");
        steps.fillingInTheLastName("Булычева");
        steps.fillingInTheEmail("mari77n@gmail.com");
        steps.selectGender();
        steps.fillInThePhoneNumber();
        steps.clickButton();
        frame.formElements.modalWindowBody.shouldHave();
//        Assertions.assertThat(frame.formElements.buttonClose.isEnabled()).as("Кнопка модального окна активна");
    }

}
