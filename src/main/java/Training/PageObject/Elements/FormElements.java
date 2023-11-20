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
    public static final SelenideElement subject = $("#subjectsContainer").as("subjectsContainer");
    public static final SelenideElement currentAddress = $("#currentAddress").as("currentAddress");
    public static final SelenideElement button = $("#submit").as("Submit");
    public static final SelenideElement dateOfBirth = $("#dateOfBirthInput").as("dateOfBirth");
    public static final SelenideElement yearField = $(".react-datepicker__year-select").as("year");
    public static final SelenideElement mounthField = $(".react-datepicker__month-select").as("mounth");
    public static final SelenideElement buttonClose = $("#closeLargeModal").as("closeLargeModal");
    public static final SelenideElement modalWindowBody = $(".modal-body").as("modalWindow");

    public static final ElementsCollection hobbies = $$x("//div[@class = 'custom-control custom-checkbox custom-control-inline']");
    public static final ElementsCollection city = $$x("//div[contains(@id, \"react-select-4-option-\")]");
    public static final ElementsCollection state = $$x("//div[contains(@id, \"react-select-3-option-\")]");
    public static final ElementsCollection gender = $$x("//input[contains(@id, 'gender-radio-')]");
    public static final ElementsCollection chooseYearOfBirth = $$x("//select[@class='react-datepicker__year-select']/option");
    public static final ElementsCollection chooseOfMonthOfBirth = $$x("//select[@class='react-datepicker__month-select']/option");
}
