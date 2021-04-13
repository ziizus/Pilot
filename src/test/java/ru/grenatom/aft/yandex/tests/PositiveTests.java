package ru.grenatom.aft.yandex.tests;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.grenatom.aft.yandex.pages.LoginPage;
import ru.grenatom.aft.base.BaseTest;

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
        String url = "passport.yandex.ru";

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

}