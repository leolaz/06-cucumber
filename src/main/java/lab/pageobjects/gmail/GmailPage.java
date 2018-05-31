package lab.pageobjects.gmail;

import lab.decorator.Name;
import lab.decorator.PageElement;
import lab.pageobjects.PageObject;
import lab.utils.WebDriverUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailPage extends PageObject {

    @Name("Compose button")
    @FindBy(css = "div[gh='cm']")
    private PageElement composeBtn;

    @Name("'Send to' input")
    @FindBy(css = "textarea[name='to']")
    private PageElement sendToInput;

    @Name("'Subject' input")
    @FindBy(css = "input[name='subjectbox']")
    private PageElement subjecInput;

    @Name("'Message' text box")
    @FindBy(className = "LW-avf")
    private PageElement messageTextBox;

    @Name("Close button")
    @FindBy(className = "Ha")
    private PageElement closeBtn;

    @Name("Draft button")
    @FindBy(xpath = "(//div[@class='aim'])[4]//a")
    private PageElement draftBtn;

    @Name("Last draft")
    @FindBy(xpath = "//div[@gh='tl']//tr[1]/td[@tabindex='-1']")
    private PageElement lastDraft;

    @FindBy(xpath = "//div[@gh='tl']//tr[1]/td[@tabindex='-1']//span[@class='bog']")
    private PageElement lastDraftSubject;

    @FindBy(xpath = "//div[@gh='tl']//tr[1]/td[@tabindex='-1']//span[@class='y2']")
    private PageElement lastDraftMessage;

    @Name("Send button")
    @FindBy(xpath = "//tr[@class='btC']/td[1]")
    private PageElement sendBtn;

    @FindBy(xpath = "//div[@gh='tl']//tr[1]/td[5]//font")
    private PageElement draftMarker;

    @FindBy(css = "div.vh span")
    private PageElement sended;

    public void clickComposeBtn() {
        composeBtn.waitUntilVisible().click();
    }

    public void fillNewEmailForm(String to, String subject, String message) {
        sendToInput.waitUntilVisible().sendKeys(to);
        subjecInput.sendKeys(subject);
        messageTextBox.sendKeys(message);
    }

    public void closeNewEmailForm() {
        closeBtn.click();
    }

    public void sendEmail() {
        sendBtn.waitUntilVisible().click();
        sended.waitUntilVisible();
    }

    public void goToDraft() {
        draftBtn.click();
    }

    public String getLastDraftCredential() {
        WebDriverUtils.newWait().until(ExpectedConditions.attributeToBe(draftMarker, "color", "#DD4B39"));
        return lastDraftSubject.getText() + lastDraftMessage.getText();
    }

    public void openLastDraft() {
        lastDraft.click();
    }


}
