package googleTranslate.step_definitions;

import googleTranslate.pages.GoogleTranslatePage;
import googleTranslate.utilities.BrowserUtility;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;

public class Scenario3 {

    GoogleTranslatePage gTp = new GoogleTranslatePage();

    @When("User clears the input field")
    public void user_clears_the_input_field() {

        //gTp.sourceTextArea.clear();

        gTp.clearSourceTextButton.click();

    }
    @When("User clicks select input tool button")
    public void user_clicks_select_input_tool_button() {

        BrowserUtility.waitForVisibility(gTp.inputTools,5);
        gTp.inputTools.click();

    }
    @When("User selects screen keyboard")
    public void user_selects_screen_keyboard() {

        gTp.inputToolsEngKeyboard.click();

    }
    @Then("User should enter Hi! and verify the source text")
    public void user_should_enter() {

        BrowserUtility.waitForVisibility(gTp.capsButton,5);

        gTp.capsButton.click();
        gTp.upperCaseLetter_H.click();
        gTp.lowerCaseLetter_i.click();
        gTp.capsButton.click();
        gTp.exclamationPoint.click();
        gTp.closeKeyboardButton.click();

        Assertions.assertEquals("Hi!",gTp.actualTextFromSourceArea.getText());

    }

}
