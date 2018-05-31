package lab.decoratorimpl;

import lab.decorator.Name;
import lab.decorator.PageElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.*;
import java.util.List;

public class MyDefaultFieldDecorator extends DefaultFieldDecorator {


    public MyDefaultFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {

        if (PageElement.class.isAssignableFrom(field.getType())) {

            PageElement pageElement = new PageElement((WebElement) super.decorate(loader, field));

            if (field.isAnnotationPresent(Name.class)) {
                pageElement.setName(
                        field.getAnnotation(Name.class).value()
                );
            }

            return pageElement;
        } else if (isDecorablePageElementList(field)) {

            return proxyForPageElementList(loader, factory.createLocator(field));

        } else {

            return super.decorate(loader, field);
        }
    }

    private List<PageElement> proxyForPageElementList(ClassLoader loader, ElementLocator locator) {
        InvocationHandler handler = new PageElementListHandler(locator);

        List<PageElement> proxy;
        proxy = (List<PageElement>) Proxy.newProxyInstance(
                loader, new Class[]{List.class}, handler);
        return proxy;
    }

    protected boolean isDecorablePageElementList(Field field) {
        if (!List.class.isAssignableFrom(field.getType())) {
            return false;
        }

        // Type erasure in Java isn't complete. Attempt to discover the generic
        // type of the list.
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return false;
        }

        Type listType = ((ParameterizedType) genericType).getActualTypeArguments()[0];

        if (!PageElement.class.equals(listType)) {
            return false;
        }

        return field.getAnnotation(FindBy.class) != null ||
                field.getAnnotation(FindBys.class) != null ||
                field.getAnnotation(FindAll.class) != null;
    }
}
