package lab.businessobjects.gmail;

import lab.pageobjects.gmail.GmailLoginPage;
import lab.pageobjects.gmail.GmailPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GmailLoginBO {

    private Logger logger = LogManager.getLogger(GmailLoginBO.class);

    public void login(String email, String password) {
        logger.info("Login to gmail");
        GmailLoginPage loginPage = new GmailLoginPage();
        GmailPage gmail = loginPage.login(email, password);
    }
}
