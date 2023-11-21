package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Steps.FormSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class FormWithAllFieldsTest extends BaseForm {

    private FormSteps steps = new FormSteps();
    @Epic("Заполнение формы")
    @Description("Заполнение обязательных и дополнительных полей формы")
    @Test
    public void fillInTheRequiredAndAdditionalFields(){
        steps.fillingInTheName("Александр");
        steps.fillingInTheLastName("Шилов");
        steps.fillingInTheEmail("Shilov77alex@gmail.com");
        steps.selectGender();
        steps.fillInThePhoneNumber();
// клик по полю день рождения
        steps.clickOnTheBirthdayField();
        steps.chooseAMonthOfBirth();



        steps.chooseAYearOfBirth();




    }


}
