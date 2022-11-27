package tests;

import org.junit.jupiter.api.*;
import registrationPage.OpenRegistrationPage;
import config.ConfigurationBrowser;
import registrationPage.ValuesPage;
import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest extends ConfigurationBrowser {



    @Test
    void fillStudentRegistrationFormTest() {
        //Open Browser Chrome
        new OpenRegistrationPage().openPage();

        //Name
        new ValuesPage().firstName();
        new ValuesPage().lastName();

        //Email
        new ValuesPage().email();

        //Gender
        new ValuesPage().gender();

        //Mobile
        new ValuesPage().mobile();

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1988");
        $x("//div[@aria-label='Choose Monday, February 29th, 1988']").click();

        //Subject
        $("#subjectsInput").setValue("Computer").pressTab();

        //Hobbies
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

        //Picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/sharik.jpeg"));

        //Current Address
        $("#currentAddress").setValue("Moscow, Prechistenka str, 24/1");

        //State and city
        $("#react-select-3-input").setValue("Haryana").pressTab();
        $("#react-select-4-input").setValue("Panipat").pressTab();

        //Submit button
        $("#submit").click();

        //Final Check
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text("Student Name"), text("Пёс Шарик"));
        $(".modal-content").shouldHave(text("Student Email"), text("DogsHeart@google.com"));
        $(".modal-content").shouldHave(text("Gender"), text("Other"));
        $(".modal-content").shouldHave(text("Mobile"), text("1234567890"));
        $(".modal-content").shouldHave(text("Date of Birth"), text("29 February,1988"));
        $(".modal-content").shouldHave(text("Subjects"), text("Computer Science"));
        $(".modal-content").shouldHave(text("Hobbies"), text("Sports, Reading, Music"));
        $(".modal-content").shouldHave(text("Picture"), text("sharik.jpeg"));
        $(".modal-content").shouldHave(text("Address"), text("Moscow, Prechistenka str, 24/1"));
        $(".modal-content").shouldHave(text("State and City"), text("Haryana Panipat"));
    }
}


