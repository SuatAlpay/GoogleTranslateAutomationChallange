package googleTranslate.step_definitions;

import googleTranslate.pages.GoogleTranslatePage;
import googleTranslate.utilities.BrowserUtility;
import io.cucumber.java.en.*;

public class Scenario2 {

    GoogleTranslatePage gTp = new GoogleTranslatePage();

    @When("User clicks swap languages button")
    public void user_clicks_swap_languages_button() {

        BrowserUtility.waitForVisibility(gTp.swapLangButton,5);

        gTp.swapLangButton.click();
    }
    @Then("The source language text should match translated text")
    public void the_source_language_text_should_match_translated_text() {

    }
}
