package registrationPage;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;

public class OpenRegistrationPage {
    String titleText = "Student Registration Form";
    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('center').remove()");
        executeJavaScript("$('#banner-eta-vanilla').remove()");
        $(".practice-form-wrapper").shouldHave(Condition.text(titleText));
    }
}