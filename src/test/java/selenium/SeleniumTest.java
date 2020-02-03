package selenium;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SeleniumTest {

    @Test
    public void automateTest() {
        open("http://explorecalifornia.org/contact.htm");

        $("#name").should(appear);
        $("#comments").should(appear);

        $("#name").setValue("Marvelous Marvin");
        $("#comments").setValue("This is only for testing");
        $("#state").selectOptionContainingText("Texas");
        $("#backpack").click();
        $(By.name("newsletter")).selectRadio("yes");

        $("#name").shouldHave(value("Marvelous Marvin"));
        var state = $("#state").getSelectedText();

        assert (state).equals("Texas");

        $("#backpack").shouldBe(selected);
        $(By.name("newsletter")).shouldHave(value("yes"));
    }
}
