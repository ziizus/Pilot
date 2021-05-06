package ru.grenatom.aft.yandex.tests;


import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.grenatom.aft.base.BaseTest;


public class PositiveTestsOnDevices extends BaseTest {


    @BeforeMethod(alwaysRun = true)
    @Parameters({ "browser", "environment" })
    @Override
    protected void setUp(@Optional("android") String browser, @Optional("local") String environment, ITestContext ctx) {
        super.setUp(browser, environment, ctx);
    }

    @Step
    @Description("Step: Login1")
    protected void Login() {

        log.info("[l]Executed PositiveTestsOnDevices->Login");


    }

    @Test
    @Description("This is Test 1")
    public void Test1()throws InterruptedException {
        log.info("[l]Executed PositiveTestsOnDevices->Test1");
        Login();
    }
}