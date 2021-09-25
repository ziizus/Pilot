package ru.grenatom.aft.yandex.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

//Типизированный элемент - первая строка из списка с результатами поиска
public class SearchResultRow extends TypifiedElement{
    @FindBy(xpath = "//h2[1]")
    @Name("Ссылка на первую строку")
    private Link link;


    public SearchResultRow(WebElement wrappedElement) {
        super(wrappedElement);
        link = new Link(wrappedElement);
    }

    public String getLinkText(){
        return link.getText();
    }
}
