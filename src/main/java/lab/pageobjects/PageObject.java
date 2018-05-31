package lab.pageobjects;

import lab.decoratorimpl.MyDefaultFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import static lab.utils.WebDriverUtils.getDriver;

public abstract class PageObject {

    public PageObject() {

        PageFactory.initElements(
                new MyDefaultFieldDecorator(
                        new DefaultElementLocatorFactory(getDriver())
                ), this);
    }
}
