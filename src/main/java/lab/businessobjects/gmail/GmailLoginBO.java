package lab.businessobjects.gmail;

import lab.pageobjects.gmail.GmailLoginPage;
import lab.pageobjects.gmail.GmailPage;
import lab.utils.WebDriverUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailLoginBO {

    private Logger logger = LogManager.getLogger(GmailLoginBO.class);

    public void login(String email, String password) {
        logger.info("Login to gmail");
        GmailLoginPage loginPage = new GmailLoginPage();
        //if (isAlertPresent())
        //    WebDriverUtils.getDriver().switchTo().alert().accept();
        GmailPage gmail = loginPage.login(email, password);
    }

    private boolean isAlertPresent() {
        try {
            WebDriverUtils.newWait().until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
