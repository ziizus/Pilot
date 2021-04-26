package ru.grenatom.aft.yandex.tests;

import org.testng.Assert;
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

import java.io.File;
import java.nio.file.Path;

public class PositiveTests extends BaseTest {


    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser", "environment" })
    @Override
    protected void setUp(@Optional("chrome") String browser, @Optional("local") String environment, ITestContext ctx) {
        super.setUp(browser, environment, ctx);
    }

    protected void Login() {

        log.info("[l]Executed PositiveTests->Login");

        // open the page
        String url = "https://passport.yandex.ru";
        driver.get(url);

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.CheckPage();
        loginPage.Login() ;
    }

    protected void Login2() {

        log.info("[l]Executed PositiveTests->Login");

        // open the page
        String url = "https://passport.yandex.ru";
        driver.get(url);

        LoginPage loginPage = new LoginPage(driver, log);
        loginPage.CheckPage();
        loginPage.Login() ;
    }

    @Test
    public void Test1()throws InterruptedException {
        log.info("[l]Executed PositiveTests->Test1");
        Login();
    }

    @Test
    public void Test2() throws InterruptedException {

        log.info("[l]Executed PositiveTests->Test2");
        Login2();
    }

    @Test
    public void Test3() throws InterruptedException {

        String jacobDllVersionToUse;
        if (jvmBitVersion().contains("32")){
            jacobDllVersionToUse = "jacob-1.20-x86.dll";
        }
        else {
            jacobDllVersionToUse = "jacob-1.20-x64.dll";
        }

        File file = new File("lib", jacobDllVersionToUse);
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

        AutoItX x = new AutoItX();

        /*
        x.run("calc.exe");
        x.winActivate("Калькулятор");
        x.winWaitActive("Калькулятор");
//Enter 3
        x.controlClick("Калькулятор", "", "133") ;
        Thread.sleep(1000);
//Enter +
        x.controlClick("Калькулятор", "", "93") ;
        Thread.sleep(1000);
//Enter 3
        x.controlClick("Калькулятор", "", "133") ;
        Thread.sleep(1000);
//Enter =
        x.controlClick("Калькулятор", "", "121") ;
         */

        String sChromeTitle = "[REGEXPTITLE:data:.*]";
        if (x.winWait(sChromeTitle, null, 5)) {
            log.info("Chrome появился");

            x.sleep(1000);
            x.send("^s", false);

            String sDialogTitle = "[CLASS:#32770; INSTANCE:1]";
            if (x.winWait(sDialogTitle, null, 5 )) {
                log.info("Окно сохранения файла появилось");


                x.controlClick(sDialogTitle, null, "[CLASS:Button; INSTANCE:3]");

                if (x.winWaitClose(sChromeTitle, null, 5)){
                    log.info("Окно сохранения файла закрыто");
                }
                else{
                    log.error("Окно сохранения файла не закрыто.");
                }

            }
            else{
                log.error("Окно сохранения файла не появилось.");
            }
        }
        else{
            log.error("Chrome не открылся");
        }




    }

}