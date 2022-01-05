package pages;

import pages.components.CalendarComponent;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.CalendarComponent.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        emailInput = $("#userEmail"),
        phoneInput = $("#userNumber"),
        genderRadio = $("#genterWrapper"),
        subjectsInput = $("#subjectsInput"),
        uploadPicture = $("input[id='uploadPicture']"),
        currentAddressInput = $("#currentAddress"),
        stateInput = $("#react-select-3-input"),
        cityInput = $("#react-select-4-input"),
        submitButton = $("#submit"),
        hobbiesCheckbox = $("#hobbiesWrapper");


    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String name){
        lastNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setEmail(String email){
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage choiceGender(String gender){
        genderRadio.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhone(String phone){
        phoneInput.setValue(phone);
        return this;
    }

    public RegistrationPage setSubjects(String subjects){
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage choiceCheckbox(String hobby){
        hobbiesCheckbox.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String namePicture){
        uploadPicture.uploadFromClasspath(namePicture);
        return this;
    }

        public RegistrationPage setCurrentAddress(String address){
            currentAddressInput.setValue(address);
        return this;
    }

        public RegistrationPage setState(String state){
            stateInput.setValue(state).pressEnter();
        return this;
    }

        public RegistrationPage setCity(String city){
            cityInput.setValue(city).pressEnter();
        return this;
    }

        public RegistrationPage sendFormButton(){
            submitButton.scrollTo().click();
        return this;
    }
}
