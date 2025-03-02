import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {

    @Test
    void successfulMainPageTest() {
        Configuration.holdBrowserOpen = true;

        open("https://info.daxtra.com/daxtra-request-a-demo");
        $(".form-title").shouldHave(text("Contact us for a demo"));
        $("[name=email]").setValue("avt@mvideo.com");
        $("[name=company]").setValue("Test");
        $("[name=firstname]").setValue("Test");
        $("[name=lastname]").setValue("Test");
        $("[name=phone]").setValue("+447898744737");
        $("[type='submit']").click();
        $(".hs_error_rollup").shouldHave(text("Please complete all required fields."));
        $("div.grecaptcha-badge").$("div.grecaptcha-logo").$("iframe[title='reCAPTCHA']").shouldBe(visible);
    }
}