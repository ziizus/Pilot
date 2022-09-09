package ru.ziizus.base;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.io.ByteArrayInputStream;

public class SuperPageFactory extends HtmlElement {
    static private WebDriver driver;
    static private Logger log;


    static public void setWebDriver(WebDriver newDriver){
        driver = newDriver;
    }

    static public void setLoger(Logger newLog){
        log = newLog;
    }

    static public void setDriver(WebDriver newDriver) {
        driver = newDriver;
    }

    static public void initElements(WebDriver newDriver, Object page){
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(newDriver)), page);
    }



    static public WebDriver getDriver(){
        return driver;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    protected byte[] createAttachment() {
        String content = "attachmentContent";
        Allure.addAttachment("Screenshot:", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        return content.getBytes();

    }
}
