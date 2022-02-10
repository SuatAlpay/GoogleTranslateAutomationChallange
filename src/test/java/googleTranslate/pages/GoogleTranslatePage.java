package googleTranslate.pages;

import googleTranslate.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleTranslatePage {

    public GoogleTranslatePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//button[@aria-label='More source languages'])[1]")
    public WebDriver sourceLanguageButton;

    @FindBy(xpath = "(//div[@class='dykxn MeCBDd j33Gae']/div/div[3]//div[@class='qSb8Pe RCaXn'])[2]//div[.='German']")
    public WebDriver sourceLangGermanOption;

    @FindBy(xpath = "(//button[@aria-label='More target languages'])[1]")
    public WebDriver targetLanguagesButton;

    @FindBy(xpath = "(//div[@class='ykTHSe']//div[@class='F29iQc']//div[@class='qSb8Pe RCaXn'])[2]//div[.='Spanish']")
    public WebDriver targetLangSpanishOption;

    @FindBy(xpath = "(//button[@aria-label='Swap languages (Cmd+Shift+S)'])[1]")
    public WebDriver swapLangButton;

    @FindBy(xpath = "//span//div/textarea[@aria-label='Source text']")
    public WebDriver sourceTextArea;

    @FindBy(xpath = "//a[@aria-label='Show the Input Tools menu']")
    public WebDriver inputTools;




}
