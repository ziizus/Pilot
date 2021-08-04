package ru.grenatom.aft.yandex.pages;

import org.openqa.selenium.support.FindBy;
import ru.grenatom.aft.base.SuperPageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Search form")
@FindBy(xpath = "//form[starts-with(@class, 'search2')]")
public class SearchArrow extends SuperPageFactory {

    @Name("Search request input")
    @FindBy(xpath = "//input[@id='input__control input__input mini-suggest__input']")
    private TextInput requestInput;

    @Name("Search button")
    @FindBy(xpath = "//div[@class='search2__button']/button")
    private Button searchButton;

    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }
}