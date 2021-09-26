package ru.grenatom.aft.yandex.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.grenatom.aft.base.SuperPageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

//Типизированный элемент - первая строка из списка с результатами поиска
public class SearchResultRow extends TypifiedElement{
    @FindBy(xpath = "//a[@class='Link Link_theme_normal OrganicTitle-Link organic__url link i-bem']")
    @Name("Ссылка на первую строку")
    private Link link;


    //Конструктор для создания самого типизированного элемента
    public SearchResultRow(WebElement wrappedElement) {
        super(wrappedElement);
        link = new Link(wrappedElement);
    }


    public String getLinkText(){
        return link.getText();
    }

    @Override
    public void click() {
        Logger log = (Logger) SuperPageFactory.getLogger();
        log.info("Нажатие по ссылке");
        link.click();
    }
}
