package TrainingTests;

import ChromeDriver.BaseForm;
import Training.PageObject.Steps.FormSteps;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

public class FormWithAllFieldsTest extends BaseForm {

    private FormSteps steps = new FormSteps();
    @Epic("Заполнение формы")
    @Story("Обязательные поля формы с дополнительными")
    @Test
    public void test(){
        steps.fillingInTheName();
        steps.fillingInTheLastName();
        steps.fillingInTheEmail();
        steps.selectGender();
        steps.fillInThePhoneNumber();
// клик по полю день рождения
        steps.clickOnTheBirthdayField();
        steps.chooseAMonthOfBirth();



        steps.chooseAYearOfBirth();




    }


}
