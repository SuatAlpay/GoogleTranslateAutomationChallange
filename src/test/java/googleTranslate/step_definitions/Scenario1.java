package googleTranslate.step_definitions;

import googleTranslate.pages.GoogleTranslatePage;
import googleTranslate.utilities.BrowserUtility;
import googleTranslate.utilities.ConfigurationReader;
import googleTranslate.utilities.Driver;
import io.cucumber.java.en.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scenario1 {

    GoogleTranslatePage gTp = new GoogleTranslatePage();

    JSONParser parser = new JSONParser();
    FileReader reader;
    Object obj;
    JSONObject jsonObject;
    String sourceLang = "";
    String translationLanguage = "";
    String initialText="";
    String expectedResult="";

    {
        try {
            reader = new FileReader("src/test/resources/lang.json");
            obj = parser.parse(reader);
            jsonObject = (JSONObject) obj;
            sourceLang = (String) jsonObject.get("SourceLanguage");
            translationLanguage = (String) jsonObject.get("TranslationLanguage");
            initialText= (String) jsonObject.get("InitialText");
            expectedResult= (String) jsonObject.get("ExpectedResult");
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }



    @Given("User is on Google Translate website")
    public void user_is_on_google_translate_website() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @When("User select source language from the drop-down menu on the left as {string}")
    public void user_select_source_language_from_the_drop_down_menu_on_the_left_as(String sourceLang) {

        WebElement sLang = Driver.getDriver().findElement(By.xpath("(//div[@class='qSb8Pe']//div[contains(text(),'"+ sourceLang +"')])[1]"));

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

        sLang.click();


    }
    @When("Users select translation language from the drop-down menu on the right as {string}")
    public void users_select_translation_language_from_the_drop_down_menu_on_the_right_as(String translationLanguage) {

        WebElement tLang = Driver.getDriver().findElement(By.xpath("(//div[@class='qSb8Pe']//div[contains(text(),'"+ translationLanguage +"')])[1]"));

        BrowserUtility.waitForClickable(gTp.targetLanguagesButton,5);

        gTp.targetLanguagesButton.click();

        BrowserUtility.waitFor(1);

        tLang.click();

    }
    @When("User enters the initial text in the input field on the left")
    public void user_enters_the_initial_text_in_the_input_field_on_the_left() {

        gTp.sourceTextArea.sendKeys(initialText);

    }
    @Then("The initial text should match the translated text")
    public void the_initial_text_should_match_the_translated_text() {

        Assertions.assertEquals(expectedResult,"verano");

    }
}
