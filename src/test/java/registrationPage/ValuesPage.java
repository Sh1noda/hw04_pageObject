package registrationPage;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ValuesPage {
    public ValuesPage firstName() {
        $("#firstName").setValue("Пёс");
        return this;
    }

    public void lastName() {
        $("#lastName").setValue("Шарик");
    }

    public void email() {
        $("#userEmail").setValue("DogsHeart@google.com");
    }

    public void gender() {
        $(byText("Other")).shouldBe(Condition.visible).click();
    }

    public void mobile() {
        $("#userNumber").setValue("1234567890");
    }

    public void mobile() {
        $("#firstName").setValue("1234567890");
    }



}
