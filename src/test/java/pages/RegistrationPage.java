package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FormResultComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderChoice = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            photoUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitForm = $("#submit"),
            closeModal = $("#closeLargeModal"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            modalTitle = $("#example-modal-sizes-title-lg"),
            stateInput = $("#state"),
            cityInput = $("#city");

    public CalendarComponent calendar = new CalendarComponent();
    public FormResultComponent formResult = new FormResultComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage makeGenderChoice(String value) {
        genderChoice.$(byText(value)).click();

        return this;
    }

    public RegistrationPage typePhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage typeDateOfBirth(String day, String mouth, String year){
        dateOfBirthInput.click();
        calendar.setDate(day, mouth, year);

        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage typeHobby(String value) {
        hobbyInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadImage(String value) {
        photoUpload.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage typeStateAndCity(String state, String city) {
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();

        return this;
    }

    public RegistrationPage submitRegistration() {
        submitForm.click();

        return this;
    }

    public RegistrationPage checkModalTitle(String value) {
        modalTitle.shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkRegistrationResults(String label, String value) {
        formResult.checkRegistrationResults(label, value);

        return this;
    }

    public RegistrationPage closeModalWidow() {
        closeModal.click();

        return this;
    }

    public RegistrationPage checkEmailTyping(String key, String value) {
        emailInput.shouldHave(cssValue(key, value));

        return this;
    }

    public RegistrationPage checkPhoneTyping(String key, String value) {
        phoneInput.shouldHave(cssValue(key, value));

        return this;
    }
}
