package ru.grenatom.aft.base;

import java.io.ByteArrayInputStream;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;


public class BaseTest {

	protected WebDriver driver;
	protected Logger log;

	/**
	 *
	 * Returns if the JVM is 32 or 64 bit version
	 */
	public static String jvmBitVersion(){
		return System.getProperty("sun.arch.data.model");
	}


	@Attachment(value = "Screenshot", type = "image/png")
	protected byte[] createAttachment() {
		String content = "attachmentContent";
		Allure.addAttachment("Screenshot:", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		return content.getBytes();

	}



	protected void setUp(@Optional("chrome") String browser, @Optional("local") String environment, ITestContext ctx) {

		// Create Driver
		Assert.assertTrue(true, "[A]Starting setUp" );
		try{
			BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		}
		catch(Throwable ext1) {
			//log.info("[l]Ошибка : " + ext1.getMessage());
			Assert.fail("[A]Ошибка", ext1);
		}


		BrowserDriverFactory factory = new BrowserDriverFactory(browser);
		if (environment.equals("grid")) {
			try{
				driver = factory.createDriverGrid();
			}
			catch(Throwable ext2) {
				//log.info("[l]Ошибка при factory.createDriverGrid();: " + ext2.getMessage());
				Assert.fail("[A]Ошибка", ext2);
			}

		} else {

			try{
				driver = factory.createDriver();
			}
			catch(Throwable ext2) {
				//log.info("[l]Ошибка при factory.createDriverGrid();: " + ext2.getMessage());
				Assert.fail("[A]Ошибка", ext2);
			}
		}

		// maximize browser window
		driver.manage().window().maximize();

		// Set up test name and Logger
		setCurrentThreadName();
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);

	}


	@AfterMethod(alwaysRun = true)
	protected void tearDown() {
		// Closing driver
		log.info("[l]Closing driver");
		Assert.assertTrue(true, "[A]Closing driver");
		driver.quit();
	}


	/** Sets thread name which includes thread id */
	private void setCurrentThreadName() {
		Thread thread = Thread.currentThread();
		String threadName = thread.getName();
		String threadId = String.valueOf(thread.getId());
		if (!threadName.contains(threadId)) {
			thread.setName(threadName + " " + threadId);
		}
	}

}