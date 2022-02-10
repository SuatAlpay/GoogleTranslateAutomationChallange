package googleTranslate.pages;

import googleTranslate.utilities.Driver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleTranslatePage {

    public GoogleTranslatePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
