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
        

        /*
        File file = new File("lib", "jacob-1.15-M4-x64.dll"); //path to the jacob dll
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

        /*
        AutoItX x = new AutoItX();
        String notepad = "Untitled - Notepad";
        String testString = "this is a test.";
        x.run("notepad.exe");
        x.winActivate(notepad);
        x.winWaitActive(notepad);
        x.send(testString);
        Assert.assertTrue(x.winExists(notepad, testString));
        x.winClose(notepad, testString);
        x.winWaitActive("Notepad");
        x.send("{ALT}n");
        Assert.assertFalse(x.winExists(notepad, testString));
         */
    }

}