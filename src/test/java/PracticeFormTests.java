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
                .setFirstName("Gordon")
                .setLastName("Freeman")
                .setEmail("freeman_g@black.mesa")
                .choiceGender("Male")
                .setPhone("9998887766")
                .setBirthDate("19","November","1998")
                .setSubjects("Physics")
                .setSubjects("English")
                .choiceCheckbox("Sports")
                .choiceCheckbox("Reading")
                .choiceCheckbox("Music")
                .setCurrentAddress("10400 Northeast Fourth Street Floor 14 Bellevue, WA 98004 USA")
                .uploadPicture("Gordon.jpg")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .sendFormButton();

// Validation form
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table").shouldHave(text("Gordon Freeman"),
                text("freeman_g@black.mesa"),
                text("Male"),
                text("9998887766"),
                text("19 November,1998"),
                text("Physics"),
                text("Sports, Reading, Music"),
                text("Gordon.jpg"),
                text("10400 Northeast Fourth Street Floor 14 Bellevue, WA 98004 USA"),
                text("Rajasthan Jaiselmer"));

// Close form
        registrationPage.closeModal();
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
}
