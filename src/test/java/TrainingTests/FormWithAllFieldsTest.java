package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Steps.FormSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class FormWithAllFieldsTest extends BaseForm {

    private FormSteps steps = new FormSteps();
    @Epic("Заполнение формы")
    @Story("Все поля")
    @Test
    public void test(){
        steps.fillingInTheName();
        steps.fillingInTheLastName();
        steps.fillingInTheEmail();
        steps.selectGender();
        steps.fillInThePhoneNumber();




    }


}
