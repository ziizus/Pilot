package ru.grenatom.aft.yandex.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

public class LoginPage extends PageFactory {
    protected WebDriver driver;
    protected Logger log;

    public LoginPage(WebDriver driver) {
        initElements(driver, this);
        this.driver = driver;
    }

    public LoginPage(WebDriver driver, Logger log) {
        initElements(driver, this);
        this.driver = driver;
        this.log = log;
    }


    public void CheckPage() {
        try {
            Assert.assertTrue(new FluentWait<WebDriver>(driver).until(ExpectedConditions.elementToBeClickable(logOnButton)).isDisplayed(), "[A]Login page is opened.");
            log.info("[l]Login page is opened.");
        } catch (Throwable ext) {
            Assert.fail("[A]Login page is not opened.");
            log.info("[l]Login page is not opened.");
        }
    }


    @FindBy(id = "passp-field-login")
    private WebElement loginInput;

    @FindBy(id = "passp-field-passwd")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@class='passp-button passp-sign-in-button']/button")
    private WebElement logOnButton;


    public void setDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage Login() {

        loginInput.sendKeys("zenyajan");
        loginInput.submit();

        initElements(driver, this);

        passwordInput.sendKeys("andbazan");
        logOnButton.click();
        MainPage mainPage = new MainPage(driver, log);
        mainPage.CheckPage();
        return mainPage;
    }
}
