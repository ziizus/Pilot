package ru.grenatom.aft.yandex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.grenatom.aft.base.SuperPageFactory;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Table;

public class WikiHi extends SuperPageFactory {
    @Name("Таблица с информацией о веществе")
    @FindBy(xpath = "//table[@class='infobox']")
    public Table infobox;


    public WikiHi() {
        initElements(getDriver(), this);
    }


    public boolean CheckPage(){
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='infobox']") ));
            createAttachment();
            return true;
        } catch (Throwable ext) {
            createAttachment();
            Assert.fail( "Не открыта страница Wiki c информацией о химическом элементе Hi. Ошибка:" + ext.getMessage() );
            return false;
        }
    }

}
