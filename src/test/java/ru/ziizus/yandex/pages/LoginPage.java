package ru.ziizus.yandex.pages;


import io.qameta.allure.Step;

import org.openqa.selenium.By;


import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.ziizus.base.SuperPageFactory;
import ru.ziizus.yandex.blocks.SearchArrow;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;


public class LoginPage extends SuperPageFactory {

    public LoginPage(){
        initElements(getDriver(), this);
    }
    @Name("Логин")
    @FindBy(id = "passp-field-login")
    private TextInput loginInput;

    @Name("Пароль")
    @FindBy(id = "passp-field-passwd")
    private TextInput passwordInput;

    @Name("Войти")
    @FindBy(xpath = "//div[@class='passp-button passp-sign-in-button']/button")
    private Button logOnButton;

    private SearchArrow searchArrow;

    public void search(String request) {
        searchArrow.search(request);
    }


    @Step("Ввести логин и пароль пользователя")
    public void login() {
        try {
            loginInput.sendKeys("user");
            loginInput.submit();

        } catch (Throwable ext) {
            Assert.fail("Ошибка при вводе логина и пароля");
        }
    }

    @Step("Проверить, что страница логина открыта")
    public LoginPage checkPage() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='passp-button passp-sign-in-button']/button") ));
            Assert.assertTrue (true,  "Открыта страница логина");
            createAttachment();
            return this;
        } catch (Throwable ext) {
            Assert.fail("Не открыта страница логина");
            createAttachment();
            return null;
        }
    }
}
