package lab.decoratorimpl;

import lab.decorator.PageElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

public class PageElementListHandler implements InvocationHandler {

  private final ElementLocator locator;

  public PageElementListHandler(ElementLocator locator) {
    this.locator = locator;
  }

  public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
    List<PageElement> elements =
            locator.findElements()
                    .stream()
                    .map(PageElement::new)
                    .collect(Collectors.toList());

    try {
      return method.invoke(elements, objects);
    } catch (InvocationTargetException e) {
      // Unwrap the underlying exception
      throw e.getCause();
    }
  }
}