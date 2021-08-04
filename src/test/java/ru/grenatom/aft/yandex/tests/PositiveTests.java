package ru.grenatom.aft.yandex.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.grenatom.aft.yandex.pages.LoginPage;
import ru.grenatom.aft.base.BaseTest;
import java.io.File;
import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import ru.grenatom.aft.yandex.pages.MainPage;
import ru.grenatom.aft.yandex.poi.ExcelWorker;


public class PositiveTests extends BaseTest {


    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser", "environment" })
    @Override
    protected void setUp(@Optional("chrome") String browser, @Optional("local") String environment, ITestContext ctx) {
        super.setUp(browser, environment, ctx);
    }

    @Step("Вход в систему 1-ым способом")
    @Description("Вход в систему 1-ым способом")
    protected void Login1() {

        log.info("[l]Executed PositiveTests->Login");


        String url = "https://passport.yandex.ru";
        driver.get(url);

        LoginPage loginPage = new LoginPage();
        loginPage.checkPage();
        loginPage.login();


    }

    @Step("Открытие ссылки для ввода формы авторизации")
    protected LoginPage startPassportURL() {
        String url = "https://passport.yandex.ru";
        driver.get(url);
       return new LoginPage();
    }

    @Step("Открытие ссылки на главную страницу")
    protected MainPage startMainURL() {
        String url = "https://yandex.ru";
        driver.get(url);
        return new MainPage();
    }


    @Step("Вход в систему 2-ым способом")
    @Description("Вход в систему 2-ым способом")
    protected void Login2() {
        startPassportURL().checkPage().login();
    }



    @Test
    @Description("Логин в систему 1-ым способом")
    public void test1()throws InterruptedException {
        Login1();
    }

    @Test
    @Description("Логин в систему 2-ым способом")
    public void test2() throws InterruptedException {
        Login2();
    }


    @Test
    @Description("Проверка работы AutoIt")
    public void test3() throws InterruptedException {

        String jacobDllVersionToUse;
        if (BaseTest.jvmBitVersion().contains("32")){
            jacobDllVersionToUse = "jacob-1.20-x86.dll";
        }
        else {
            jacobDllVersionToUse = "jacob-1.20-x64.dll";
        }

        File file = new File("lib", jacobDllVersionToUse);
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
        AutoItX x = new AutoItX();

        String sChromeTitle = "[REGEXPTITLE:data.*]";
        if (x.winWait(sChromeTitle, null, 5)) {
            log.info("Chrome появился");

            //x.sleep(1000);
            x.send("^s", false);

            String sDialogTitle = "[CLASS:#32770; INSTANCE:1]";

            if (x.winWait(sDialogTitle, null, 10 )) {
                log.info("Окно сохранения файла появилось");
                createAttachment();

                x.controlClick("Сохранение", null, "[CLASS:Button; INSTANCE:3]");


                int i=5; boolean res=false;
                do{

                    if (x.controlCommandIsVisible("Сохранение", null, "[CLASS:Button; INSTANCE:3]")==false){
                        res=true;
                        break;
                    }
                    i--;
                }while (i>0);

                if (res){
                    log.info("Окно сохранения файла закрыто");
                    createAttachment();
                }
                else{
                    createAttachment();
                    log.error("Окно сохранения файла не закрыто.");
                }

            }
            else{
                createAttachment();
                log.error("Окно сохранения файла не появилось.");
            }
        }
        else{
            createAttachment();
            log.error("Chrome не открылся");
        }
        createAttachment();
    }

    @Test
    @Description("Проверка HtmlElements")
    public void test4() throws InterruptedException {
        startMainURL().checkPage().search("hello world!!").checkPage().clickClearButton().search("Hi!").checkPage();
    }

    @Test

    public void test5() {
        ExcelWorker excel = new ExcelWorker("//Selenium//Testdata.xlsx");
        log.info(excel.readData(0,1));

    }

}