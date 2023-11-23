package Training.PageObject.Elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class FormElements {
    public static final SelenideElement firstName = $("#firstName").as("firstName");
    public static final SelenideElement lastName = $("#lastName").as("lastName");
    public static final SelenideElement email = $("#userEmail").as("userEmail");
    public static final SelenideElement phoneNumber = $("#userNumber").as("userNumber");
    //date of birth
    public static final SelenideElement subject = $x("//div[@class = 'subjects-auto-complete__input']/input").as("subjectsContainer");
    public static final SelenideElement currentAddress = $("#currentAddress").as("currentAddress");
    public static final SelenideElement button = $("#submit").as("Submit");
    public static final SelenideElement dateOfBirth = $("#dateOfBirthInput").as("dateOfBirth");
    public static final SelenideElement yearField = $(".react-datepicker__year-select").as("year");
    public static final SelenideElement mounthField = $(".react-datepicker__month-select").as("mounth");
    public static final SelenideElement buttonClose = $("#closeLargeModal").as("closeLargeModal");
    public static final SelenideElement fileUpload = $("//div[@class = 'form-file']").as("uploadPicture");

    public static final SelenideElement modalWindowBody = $(".modal-body").as("modalWindow");

    public static final ElementsCollection hobbies = $$x("//div[@class = 'custom-control custom-checkbox custom-control-inline']/input");
    public static final ElementsCollection city = $$x("//div[contains(@id, \"react-select-4-option-\")]");
    public static final ElementsCollection state = $$x("//div[contains(@id, \"react-select-3-option-\")]");


    //div[@class =' css-1gtu0rj-indicatorContainer']
    public static final SelenideElement statesField  = $x("//div[@class =' css-1gtu0rj-indicatorContainer']");
//input[@id ='react-select-3-input']


    public static final ElementsCollection gender = $$x("//input[contains(@id, 'gender-radio-')]");
    public static final SelenideElement chooseYearOfBirth = $x("//select[@class='react-datepicker__year-select']/option[@value='1981']");
    public static final SelenideElement chooseOfMonthOfBirth = $x("//select[@class='react-datepicker__month-select']/option[@value='5']");
    public static final SelenideElement chooseOfDayOfBirth = $x("//div[contains(@class, 'react-datepicker__day react-datepicker__day--018')]");
    public static final ElementsCollection subjectList = $$x("//div[contains(@class, 'subjects-auto-complete__option')]").as("элементы в выпадающем списке");
    public static final SelenideElement themeDropDownMenu = $x("//div[@class = 'subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr']").as("выпадающий список");
}


