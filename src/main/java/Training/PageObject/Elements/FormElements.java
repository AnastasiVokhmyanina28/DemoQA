package Training.PageObject.Elements;

import Person.Student;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;

import static com.codeborne.selenide.Selenide.*;

public class FormElements {
    public static final SelenideElement firstName = $("#firstName").as("firstName");
    public static final SelenideElement lastName = $("#lastName").as("lastName");
    public static final SelenideElement email = $("#userEmail").as("userEmail");
    public static final SelenideElement phoneNumber = $("#userNumber").as("userNumber");
    public static final SelenideElement subject = $x("//div[@class = 'subjects-auto-complete__input']/input").as("subjectsContainer");
    public static final SelenideElement currentAddress = $("#currentAddress").as("currentAddress");
    public static final SelenideElement button = $("#submit").as("Submit");
    public static final SelenideElement dateOfBirth = $("#dateOfBirthInput").as("dateOfBirth");
    public static final SelenideElement yearField = $(".react-datepicker__year-select").as("year");
    public static final SelenideElement mounthField = $(".react-datepicker__month-select").as("mounth");
    public static final SelenideElement buttonClose = $("#closeLargeModal").as("closeLargeModal");
    public static final SelenideElement fileUpload = $x("//input[@id = 'uploadPicture']").as("uploadPicture");
    public static final SelenideElement footer = $x("//footer").as("footer");
    public static final SelenideElement modalWindowBody = $(".modal-body").as("modalWindow");
    public static final ElementsCollection hobbies = $$x("//div[@class = 'custom-control custom-checkbox custom-control-inline']/input");
    public static final SelenideElement cityField = $("#city");
    public static final ElementsCollection city = $$x("//div[contains(@id, \"react-select-4-option-\")]").as("Список элементов 'State'");
    public static final SelenideElement statesField = $("#state");
    public static final SelenideElement stateAndCityFieldDropDownMenu = $x("//div[@class = ' css-11unzgr']");
    public static final ElementsCollection state = $$x("//div[contains(@id, \"react-select-3-option-\")]").as("Элементы выпадающего списка 'State'");
    public static final ElementsCollection gender = $$x("//input[contains(@id, 'gender-radio-')]");
    public static final SelenideElement maleGender = $x("//label[@for='gender-radio-1']");
    public static final SelenideElement maleGenderRadioButton = $x("//input[@id='gender-radio-1']");
    public static final SelenideElement femaleGender = $x("//label[@for='gender-radio-2']");
    public static final SelenideElement femaleGenderRadioButton = $x("//input[@id='gender-radio-2']");
    public static final SelenideElement chooseYearOfBirth = $x("//select[@class='react-datepicker__year-select']/option[@value='1981']");
    public static final SelenideElement chooseOfMonthOfBirth = $x("//select[@class='react-datepicker__month-select']/option[@value='5']");
    public static final SelenideElement chooseOfDayOfBirth = $x("//div[contains(@class, 'react-datepicker__day react-datepicker__day--018')]");
    public static final ElementsCollection subjectList = $$x("//div[contains(@class, 'subjects-auto-complete__option')]").as("элементы в выпадающем списке");
    public static final SelenideElement themeDropDownMenu = $x("//div[@class = 'subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr']").as("выпадающий список поля 'Subject'");
    public static ElementsCollection getModalWindowValues = $$x("//table[@class = 'table table-dark table-striped table-bordered table-hover']//td[2]").as("Список values в модальном окне");

    public static SelenideElement getState(String id) {
        return $x("//div[@id = '" + id + "']");
    }

    public static Student getModalData() {
        Student result = new Student();
        result.setFirstName(getModalWindowValues.get(ROWS.Student_name.tabIndex).getText().split(" ")[0]);
        result.setLastName(getModalWindowValues.get(ROWS.Student_name.tabIndex).getText().split(" ")[1]);
        result.setGender(Student.GENDERS.valueOf(getModalWindowValues.get(ROWS.Student_gender.tabIndex).getText()));
        result.setMobile(getModalWindowValues.get(ROWS.Student_Mobile.tabIndex).getText());

        return result;
    }

    public static SelenideElement getGenderRadio(String value) {
        return $x(String.format("//div[@id='genterWrapper']//input[@value='%s']/following-sibling::label", value));
    }

    @AllArgsConstructor
    private enum ROWS {
        Student_name(0),
        Student_email(1),
        Student_gender(2),
        Student_Mobile(3);
        final Integer tabIndex;
    }

    public static void selectGender(String value) {
        getGenderRadio(value).click();

    }

    public static SelenideElement getSubject(String elementClass) {
        return $x("//div[@class = '" + elementClass + "']");
    }

    public static SelenideElement getCity(String id) {
        return $x("//div[@id = '" + id + "']");
    }

    public static SelenideElement getHobbies(String id) {
        return $x("//label[@for = '" + id + "']");
    }

}


