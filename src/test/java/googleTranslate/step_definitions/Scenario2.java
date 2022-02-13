package googleTranslate.step_definitions;

import googleTranslate.pages.GoogleTranslatePage;
import googleTranslate.utilities.BrowserUtility;
import io.cucumber.java.en.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;

import java.io.FileReader;
import java.io.IOException;

public class Scenario2 {

    GoogleTranslatePage gTp = new GoogleTranslatePage();

    JSONParser parser = new JSONParser();
    FileReader reader;
    Object obj;
    JSONObject jsonObject;

    String initialText="";
    String expectedResult="";

    {
        try {
            reader = new FileReader("src/test/resources/lang.json");
            obj = parser.parse(reader);
            jsonObject = (JSONObject) obj;
            initialText= (String) jsonObject.get("InitialText");
            expectedResult= (String) jsonObject.get("ExpectedResult");
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    @When("User clicks swap languages button")
    public void user_clicks_swap_languages_button() {

        gTp.swapLangButton.click();
    }

    @Then("Verify that the  translated text is {string}")
    public void verifyThatTheTranslatedTextIs(String text) {
        text= initialText;

        String actualResult = gTp.actualTextFromTranslationsAreaAfterSwap.getText();

        Assertions.assertTrue(text.equalsIgnoreCase(actualResult));
    }
}
