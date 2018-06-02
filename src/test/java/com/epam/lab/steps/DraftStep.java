package com.epam.lab.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lab.businessobjects.gmail.GmailDraftsBO;
import lab.businessobjects.gmail.GmailLoginBO;
import lab.utils.PropertyReader;
import lab.utils.WebDriverUtils;

public class DraftStep {
    final private GmailDraftsBO draftsBO = new GmailDraftsBO();
    final private GmailLoginBO loginBO = new GmailLoginBO();

    @Before
    public void setUp(){
        WebDriverUtils.load(PropertyReader.get("gmail_url"));
    }


    @Given("^I login into gmail\\.com by \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginIntoGmailComByAnd(String login, String password) throws Throwable {
        loginBO.login(login, password);
    }

    @When("^I fill 'New Message' form to \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iFillNewMessageFormToWithAnd(String sendTo, String subject, String message) throws Throwable {
        draftsBO.openNewMessageForm();
        draftsBO.fillNewMessageForm(sendTo,subject,message);
    }

    @And("^I close it$")
    public void closeIt() throws Throwable {
        draftsBO.closeNewMessageForm();
    }

    @Then("^my message saved in drafts as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void myMessageSavedInDraftsAsAnd(String subject, String message) throws Throwable {
        draftsBO.checkLastDraft(subject, message);
    }

    @And("^I send it$")
    public void iSendIt() throws Throwable {
        draftsBO.sendLastDraft();
    }

    @After
    public void cleanUp(){
        WebDriverUtils.close();
    }

}
