package ru.grenatom.aft.yandex.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class LoginPage extends HtmlElement {
    protected WebDriver driver;
    protected Logger log;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginPage(WebDriver driver, Logger log) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.log = log;
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

    @Step("Ввести логин и пароль пользователя")
    public void Login() {
        try {

            loginInput.sendKeys("user");
            loginInput.submit();

            //passwordInput.sendKeys("password");
            //logOnButton.click();

            /*
            MainPage mainPage = new MainPage(driver, log);
            mainPage.CheckPage();
            return mainPage;
             */
        } catch (Throwable ext) {
            Assert.fail("[A]Ошибка при вводе логина и пароля");
            log.info("[l]Ошибка при вводе логина и пароля.");
        }

    }

    @Step("Проверить, что страница логина открыта")
    public void CheckPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='passp-button passp-sign-in-button']/button") ));
            Assert.assertTrue (true,  "[A]Login page is opened.");
            log.info("[l]Login page is opened.");
        } catch (Throwable ext) {
            Assert.fail("[A]Login page is not opened.");
            log.info("[l]Login page is not opened.");
        }
    }
}
