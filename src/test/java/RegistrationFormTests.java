import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "760x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void formTestDemoqa() {

        open("/automation-practice-form");

        $("#firstName").setValue("Olga");
        $("#lastName").setValue("Kas");
        $("#userEmail").setValue("Kas@mail.ru");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("78887677717");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--005").click();
        $("#subjectsInput").setValue("ma").pressEnter();
        $("label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("kit.jpg");
        $("#currentAddress").setValue("test_address");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("delhi").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Olga Kas"),
                text("Kas@mail.ru"),
                text("Female"),
                text("7888767771"),
                text("05 April,1995"),
                text("Maths"),
                text("Reading"),
                text("kit.jpg"),
                text("test_address"),
                text("NCR Delhi")
        );

    }
}
