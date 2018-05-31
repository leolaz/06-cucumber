package lab.pageobjects.gmail;

import lab.decorator.Name;
import lab.decorator.PageElement;
import lab.pageobjects.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends PageObject {
    @Name("Login input")
    @FindBy(id = "identifierId")
    private PageElement loginInput;

    @Name("Password input")
    @FindBy(name = "password")
    private PageElement passInput;

    public GmailPage login(String login, String password) {
        loginInput.sendKeys(login, Keys.ENTER);
        passInput.waitUntilVisible().sendKeys(password, Keys.ENTER);
        return new GmailPage();
    }

}
