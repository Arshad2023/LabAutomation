package TestMethods;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LabAutomate.AutomateLabWebapp;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods {
	WebDriver driver;
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://gor-pathology.web.app/");
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void LoginWithInvalidData() throws InterruptedException {
		AutomateLabWebapp Test = new AutomateLabWebapp(driver);
		Test.InvalidData("abcd@gmail.com","reedfedf");
		Thread.sleep(4000);
	}
	@Test(priority=2)
	public void LoginWithValidData() throws InterruptedException {
		AutomateLabWebapp Test = new AutomateLabWebapp(driver);
		Test.ValidData("test@kennect.io","Qwerty@1234");
	}

	@Test(priority=3)
	public void AddPatient() throws InterruptedException {
		AutomateLabWebapp Test = new AutomateLabWebapp(driver);
		Test.Addepatient();
	}
	
	
	
	
}
