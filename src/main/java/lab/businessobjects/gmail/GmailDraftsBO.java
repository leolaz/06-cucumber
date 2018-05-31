package lab.businessobjects.gmail;

import lab.pageobjects.gmail.GmailPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class GmailDraftsBO {

    private Logger logger = LogManager.getLogger(GmailDraftsBO.class);

    private GmailPage gmail = new GmailPage();

    public void openNewMessageForm(){
        logger.info("Click 'Compose'");
        gmail.clickComposeBtn();
    }

    public void fillNewMessageForm(String sendTo, String subject, String message) {
        logger.info("Fill “To”, “Subject” & “message” fields");
        gmail.fillNewEmailForm(sendTo, subject, message);
    }

    public void closeNewMessageForm(){
        logger.info("Close “new message” window");
        gmail.closeNewEmailForm();
    }

    public void checkLastDraft(String subject, String message) {
        logger.info("Verify that message is saved as draft");
        gmail.goToDraft();
        Assert.assertEquals(gmail.getLastDraftCredential(), subject + " - " + message);
    }

    public void sendLastDraft() {
        logger.info("Open message from the draft folder & send");
        gmail.openLastDraft();
        gmail.sendEmail();
    }
}
