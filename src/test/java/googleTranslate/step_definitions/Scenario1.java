package googleTranslate.step_definitions;

import googleTranslate.pages.GoogleTranslatePage;
import googleTranslate.utilities.BrowserUtility;
import googleTranslate.utilities.ConfigurationReader;
import googleTranslate.utilities.Driver;
import googleTranslate.utilities.ExcelUtil;
import io.cucumber.java.en.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tags;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scenario1 {

    GoogleTranslatePage gTp = new GoogleTranslatePage();

    private FileInputStream fileInputStream;

    private Workbook workbook;

    private Sheet workSheet;

    String filePathLangDE = "src/test/resources/langDE.xlsx";
    String filePathLangES = "src/test/resources/langES.xlsx";


    @Given("User is on Google Translate website")
    public void user_is_on_google_translate_website() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));


    }
    @When("User select source language from the drop-down menu on the left as German")
    public void user_select_source_language_from_the_drop_down_menu_on_the_left_as() {

        BrowserUtility.waitForClickable(gTp.sourceLanguageButton,5);

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

        gTp.sourceTextArea.sendKeys();

    }
    @Then("The initial text should match the translated text")
    public void the_initial_text_should_match_the_translated_text() {

        ExcelUtil excelUtilDE = new ExcelUtil(filePathLangDE,"langDE");
        excelUtilDE.getCellData(0,1);

        ExcelUtil excelUtilES = new ExcelUtil(filePathLangES,"langES");
        excelUtilES.getCellData(0,1);

        Map<String,String> map = new HashMap<>();

        for (int i = 0; i < workSheet.getLastRowNum() ; i++) {

            Row row = workSheet.getRow(i);

            for (Cell eachCell : row){
                map.put(eachCell.getStringCellValue(),eachCell.getStringCellValue());
            }
        }
        System.out.println(map);


    }
}
