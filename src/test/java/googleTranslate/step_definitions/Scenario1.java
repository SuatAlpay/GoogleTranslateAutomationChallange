package googleTranslate.step_definitions;

import googleTranslate.pages.GoogleTranslatePage;
import googleTranslate.utilities.BrowserUtility;
import googleTranslate.utilities.ConfigurationReader;
import googleTranslate.utilities.Driver;
import io.cucumber.java.en.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scenario1 {

    GoogleTranslatePage gTp = new GoogleTranslatePage();

    @Given("User is on Google Translate website")
    public void user_is_on_google_translate_website() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @When("User select source language from the drop-down menu on the left as German")
    public void user_select_source_language_from_the_drop_down_menu_on_the_left_as() {

        BrowserUtility.waitForClickable(gTp.sourceLanguageButton,5);

        /**
         *  Could also be implemented as below during DataBaseTesting.
         *  We can use a reusable WebElement locator such that it will select the Source Language as that option.
         *
            * Inside Feature File:
                    *  When User select source language from the drop-down menu on the left as <langSource>
            * Method inside Step-Definitions Package
                    * @When ("User select source language from the drop-down menu on the left as {string}")
                    * public void user_select_source_language_from_the_drop_down_menu_on_the_left_as(String sourceLang) {
            * Re-Usable WebElement:
                    * Driver.findElement(By.xpath("(//div[@class='qSb8Pe']//div[contains(text(),'"+ sourceLang +"')])[1]"))
         */

        gTp.sourceLanguageButton.click();

        BrowserUtility.waitFor(1);

        gTp.sourceLangGermanOption.click();


    }
    @When("Users select translation language from the drop-down menu on the right as Spanish")
    public void users_select_translation_language_from_the_drop_down_menu_on_the_right_as() {

        BrowserUtility.waitForVisibility(gTp.targetLanguagesButton,5);

        gTp.targetLanguagesButton.click();

        BrowserUtility.waitFor(1);

        gTp.targetLangSpanishOption.click();

    }
    @When("User enters the initial text in the input field on the left")
    public void user_enters_the_initial_text_in_the_input_field_on_the_left() {

        gTp.sourceTextArea.sendKeys("democratie");

    }
    @Then("The initial text should match the translated text")
    public void the_initial_text_should_match_the_translated_text() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader("src/test/java/com/cybertek/JsonFiles/langDE.json");

        Object obj = jsonParser.parse(reader);

        JSONObject jsonObject = (JSONObject) obj;

        //String sourceLAng = (String) jsonObject.get("langDE[0].SourceLanguage");

        JSONArray jsonArray = (JSONArray) jsonObject.get("langDE");

        Map<String,String> map = new LinkedHashMap<>();

        for (int i = 0; i < jsonArray.size(); i++) {

            JSONObject lanDE = (JSONObject) jsonArray.get(i);

            String sourceLang = (String) lanDE.get("SourceLanguage");
            String initialText = (String) lanDE.get("InitialText");

            map.put(sourceLang,initialText);
        }


    }
}
