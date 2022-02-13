package googleTranslate.pages;

import googleTranslate.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleTranslatePage {

    public GoogleTranslatePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//button[@aria-label='More source languages'])[1]")
    public WebElement moreSourceLanguageButton;

    @FindBy(xpath = "(//button[@aria-label='More target languages'])[1]")
    public WebElement moreTargetLanguagesButton;

    @FindBy(xpath = "(//button[@aria-label='Swap languages (Cmd+Shift+S)'])[1]")
    public WebElement swapLangButton;

    @FindBy(xpath = "//span//div/textarea[@aria-label='Source text']")
    public WebElement sourceTextArea;

    @FindBy(xpath = "//button[@aria-label='Clear source text']")
    public WebElement clearSourceTextButton;

    @FindBy(xpath = "//div[@class='A3dMNc']/span")
    public WebElement actualTextFromSourceArea;

    @FindBy(xpath = "(//div[@class='J0lOec']/span)[1]")
    public WebElement actualTextFromTranslationsArea;

    @FindBy(xpath = "//div[@class='J0lOec']//span[@jsname='W297wb']")
    public WebElement actualTextFromTranslationsAreaAfterSwap;

    @FindBy(xpath = "//a[@aria-label='Show the Input Tools menu']")
    public WebElement inputTools;

    @FindBy(xpath = "(//ul[@class='ita-kd-dropdown-menu']/li)[3]//span[.='US International']")
    public WebElement inputToolsEngKeyboard;

    @FindBy(xpath = "(//div[@id='kbd']//button[@id='K16'])[1]")
    public WebElement capsButton;

    @FindBy(xpath = "//div[@id='kbd']//button[@id='K72']")
    public WebElement upperCaseLetter_H;

    @FindBy(xpath = "//div[@id='kbd']//button[@id='K73']")
    public WebElement lowerCaseLetter_i;

    @FindBy(xpath = "//div[@id='kbd']//button[@id='K49']")
    public WebElement exclamationPoint;

    @FindBy(xpath = "//div[@id='kbd']//div[@class='vk-t-btns']/div")
    public WebElement closeKeyboardButton;

}
