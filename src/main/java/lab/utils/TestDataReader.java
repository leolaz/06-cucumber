package lab.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

    public class TestDataReader {

    public TestData read(File xml){
        TestData testData = new TestData();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TestData.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            testData =  (TestData) unmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return testData;
    }
}