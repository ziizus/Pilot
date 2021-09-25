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

public class SearchResults extends SuperPageFactory {
    private SearchArrow searchArrow;

    @FindBy(xpath = "//ul[@id='search-result']//li[@data-cid][2]")
    private SearchResultRow row1;

    @FindBy(className = "main__content")
    @Name("Результаты поиска")
    private WebElement mainContent;

    public SearchResults() {
        initElements(getDriver(), this);
    }

    @Step("Проверить открытие списка с результатами поиска")
    public SearchResults checkPage(){
        try {
            Assert.assertTrue(new FluentWait<WebDriver>(getDriver()).until(ExpectedConditions.elementToBeClickable(mainContent)).isDisplayed(), "Открыт список с результатами поиска");
            createAttachment();
            return this;
        } catch (Throwable ext) {
            Assert.fail( "Не открыт список с результатами поиска. Ошибка:" + ext.getMessage() );
            createAttachment();
            return null;
        }

    }

    public SearchResults search(String request) {return searchArrow.search(request);
    }

    public SearchResults clickClearButton() {
            searchArrow.clickClearButton();
            return this;
    }

    public void getSearchResultFirstRowText(){
        log.info(row1.getLinkText());
    }
}
