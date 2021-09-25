package ru.grenatom.aft.yandex.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import ru.grenatom.aft.base.SuperPageFactory;
import ru.grenatom.aft.yandex.blocks.SearchArrow;
import ru.grenatom.aft.yandex.elements.SearchResultRow;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class MainPage extends SuperPageFactory {

    private SearchArrow searchArrow;



    @Name("Сейчас в СМИ")
    @FindBy(xpath="//a[@id='news_tab_news']")
    private WebElement newsTabText;


    public MainPage() {
            initElements(getDriver(), this);
    }

    @Step("Проверить открытие главной страницы пользователя")
    public MainPage checkPage(){
        try {
            Assert.assertTrue(new FluentWait<WebDriver>(getDriver()).until(ExpectedConditions.elementToBeClickable(newsTabText)).isDisplayed(), "Главная страница открыта");
            createAttachment();
            return this;
        } catch (Throwable ext) {
            createAttachment();
            Assert.fail( "Главная страница не открыта. Ошибка:" + ext.getMessage() );
            return null;
        }

    }


    public SearchResults search(String request) {
        return searchArrow.search(request);
    }



}