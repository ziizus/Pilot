package ru.grenatom.aft.yandex.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import ru.grenatom.aft.base.SuperPageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;


public class PassportPage extends SuperPageFactory {

    public PassportPage(){
        initElements(getDriver(), this);
    }
    @Name("Текст «Добро пожаловать»")
    @FindBy(id= "welcomeText")
    private WebElement welcomeText;

    @Step("Проверить открытие личной страницы пользователя")
    public PassportPage checkPage() {
        try {
            Assert.assertTrue(new FluentWait<WebDriver>(getDriver()).until(ExpectedConditions.elementToBeClickable(welcomeText)).isDisplayed(), "Личная страница пользователя открыта");
            createAttachment();
            return this;
        } catch (Throwable ext) {
            Assert.fail("Личная страница пользователя не открыта");
            createAttachment();
            return null;
        }
    }

}
