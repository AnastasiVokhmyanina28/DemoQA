package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Frame.FormFrame;
import Training.PageObject.Steps.FormSteps;


import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FormWithRequiredFieldsTest extends BaseForm {
    public FormSteps steps = new FormSteps();
    public static FormFrame frame = new FormFrame();

    @Epic("Заполнение формы")
    @Story("Обязательные поля")
    @Test
    public void test() {
        steps.fillingInTheName();
        steps.fillingInTheLastName();
        steps.selectGender();
        steps.fillInThePhoneNumber();
        steps.clickButton();
        Assertions.assertThat(frame.formElements.modalWindowBody.isEnabled()).as("Body модального окна");
//        Assertions.assertThat(frame.formElements.buttonClose.isEnabled()).as("Кнопка модального окна активна");
    }

}
