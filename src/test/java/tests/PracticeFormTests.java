package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void formTest() {

        registrationPage
                .openPage()
                .setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setEmail(TestData.Email)
                .choiceGender(TestData.gender)
                .setPhone(TestData.phone)
                .setBirthDate("19","November","1998")
                .setSubjects("Physics")
                .setSubjects("English")
                .choiceCheckbox("Sports")
                .choiceCheckbox("Reading")
                .choiceCheckbox("Music")
                .setCurrentAddress(TestData.fullAddress)
                .uploadPicture("Gordon.jpg")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .sendFormButton();

// Validation form
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table").shouldHave(text(TestData.firstName + " " + TestData.lastName),
                text(TestData.Email),
                text(TestData.gender),
                text(TestData.phone),
                text("19 November,1998"),
                text("Physics, English"),
                text("Sports, Reading, Music"),
                text("Gordon.jpg"),
                text(TestData.fullAddress),
                text("Rajasthan Jaiselmer"));

// Close form
        registrationPage.closeModal();
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
}
