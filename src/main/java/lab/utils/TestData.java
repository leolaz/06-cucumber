package lab.utils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "testData")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestData {

    @XmlElement
    private String login;
    @XmlElement
    private String pass;
    @XmlElement(name = "send_to")
    private String sendTo;
    @XmlElement
    private String subject;
    @XmlElement
    private String message;
    @XmlElement
    private String search1;
    @XmlElement
    private String search2;
    @XmlElement(name = "test_tag")
    private String testTag;

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getSendTo() {
        return sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getSearch1() {
        return search1;
    }

    public String getSearch2() {
        return search2;
    }

    public String getTestTag() {
        return testTag;
    }
}

