package ru.grenatom.aft.yandex.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


public class MainPage extends HtmlElement {
    protected WebDriver driver;
    protected Logger log;

    @FindBy(id= "welcomeText")
    private WebElement welcomeText;

    public MainPage(WebDriver driver, Logger log) {
        //initElements(driver, this);
        this.driver = driver;
        this.log = log;
    }


    public void CheckPage() {
        try {
            Assert.assertTrue(new FluentWait<WebDriver>(driver).until(ExpectedConditions.elementToBeClickable(welcomeText)).isDisplayed(), "[A]Main page is opened.");
            log.info("[l]Main page is opened.");
        } catch (Throwable ext) {
            log.info("[l]Main page is not opened.");
            Assert.fail("[l]Main page is not opened.");
        }
    }

}
