package ru.ziizus.yandex.blocks;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.ziizus.base.SuperPageFactory;
import ru.ziizus.yandex.pages.SearchResults;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Search form")
@FindBy(xpath = "//form[starts-with(@class, 'search2')]")
public class SearchArrow extends SuperPageFactory {

    @Name("Search request input")
    @FindBy(xpath = "//div[@class='search2__input']//input[starts-with(@class, 'input__control')]")
    private TextInput requestInput;

    @Name("Search button")
    @FindBy(xpath = "//div[@class='search2__button']/button")
    private Button searchButton;

    @Name("Clear button")
    @FindBy(xpath = "//span[starts-with(@class, 'input__clear')]")
    private Button clearButton;


    @Step("Ввод текста {request} в форму поиска")
    public SearchResults search(String request) {
        try {
            requestInput.sendKeys(request);
            searchButton.click();
            createAttachment();
            return new SearchResults();
        } catch (Throwable ext) {
            Assert.fail("Ошибка при вводе данных поиска:" + ext.getLocalizedMessage());
            createAttachment();
            return null;
        }
    }

    @Step("Очистить поле поиска")
    public SearchArrow clickClearButton(){
        try {
            clearButton.click();
            return this;
        } catch (Throwable ext) {
            Assert.fail("Ошибка при очистке поля поиска" + ext.getLocalizedMessage());
            createAttachment();
            return null;
        }

    }
}