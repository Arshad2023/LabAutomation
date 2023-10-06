package LabAutomate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutomateLabWebapp{
	WebDriver driver;
	public AutomateLabWebapp(WebDriver driver) {
		this.driver=driver;
	}

	//login features
	By EmailBox = By.xpath("//input[@name=\"email\"]");
	By PasswordBox = By.xpath("//input[@name=\"password\"]");
	By LoginBtn = By.xpath("//span[text()=\"Login\"]");
	By LoginError = By.xpath("//*[@class=\"MuiAlert-message\"]");
	By AddTest = By.xpath("//input[@id=\"patient-test\"]");
	By Discount = By.xpath("//*[@aria-haspopup='listbox']");
	By elem = By.xpath("//li[@role=\"option\"]");
	By datavalue = By.xpath("//*[@data-value='10']");
	
	By Pateints = By.xpath("//span[contains(text(), 'Patients')]");
	By Addpatients = By.xpath("//span[contains(text(), 'Add Patient')]");
	  By Name = By.xpath("//input[@name='name']");
	  By Email = By.xpath("//input[@name='email']");
	  By Phone = By.xpath("//input[@name='phone']");
	  By GeneralDet = By.xpath("//button[@style='margin-top: 5px;']");
	  By Height = By.xpath("//input[@name='height']");
	  By Weight = By.xpath("//input[@name='weight']");
	  By GenderDD = By.xpath("//*[@id='mui-component-select-gender']");
	  By ValueFemale = By.xpath("//li[@data-value='female']");
	  By age = By.xpath("//input[@name='age']");
	  By Sistolic = By.xpath("//input[@name='systolic']");
	  By Diastolic = By.xpath("//input[@name='diastolic']");
	  By Addtests = By.xpath("//span[text()='Add Tests'][@class='MuiButton-label jss1509']");
	  By values = By.id("patient-tests-labs-option-0");
	  By lab = By.xpath("//input[@id=\"patient-tests-labs\"]");	
	  
	  
	  
	public void InvalidData(String Email, String pass) throws InterruptedException {
		driver.findElement(EmailBox).sendKeys(Email);
		driver.findElement(PasswordBox).sendKeys(pass);
		driver.findElement(LoginBtn).click();
		Thread.sleep(3000);
		String ActualError = driver.findElement(LoginError).getText();
		String ExpectedError = "There is no user record corresponding to this identifier. The user may have been deleted.";
		Assert.assertEquals(ActualError, ExpectedError);
		driver.findElement(EmailBox).clear();
		driver.findElement(PasswordBox).clear();
	}
	public void ValidData(String Email, String pass) throws InterruptedException {
		driver.findElement(EmailBox).sendKeys(Email);
		driver.findElement(PasswordBox).sendKeys(pass);
		driver.findElement(LoginBtn).click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(2000);
		driver.findElement(Discount).click();
		driver.findElement(datavalue).click();
		driver.findElement(AddTest).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id='patient-test-option-2']")).click();
		Thread.sleep(1000);
		}
	public void Addepatient() throws InterruptedException{
		driver.findElement(Pateints).click();
		driver.findElement(Addpatients).click();
		driver.findElement(Phone).sendKeys("9087654321");
	    driver.findElement(Name).sendKeys("Test1");
	    driver.findElement(Email).sendKeys("Test@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(GeneralDet).click();
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(2000);
	    driver.findElement(Height).sendKeys("");
	    driver.findElement(Weight).sendKeys("");
	    driver.findElement(GenderDD).click();
	    driver.findElement(ValueFemale).click();
	    driver.findElement(age).sendKeys("");
	    driver.findElement(Sistolic).sendKeys("");
	    driver.findElement(Diastolic).sendKeys("");
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    driver.findElement(GeneralDet).click();
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(Discount).click();
		driver.findElement(datavalue).click();
		driver.findElement(AddTest).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@id='patient-test-option-2']")).click();
		Thread.sleep(1000);
		driver.findElement(lab).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'HEALTHCARE PATHOLOGY (Sion) - VITAMIN B12, SERUM - 390₹')]")).click();
		driver.findElement(By.xpath("//input[@name='doctor_name']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Dr.roheet rathod')] ")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='mui-component-select-doctor_commission']")).click();
		Thread.sleep(1000);
		driver.findElement(datavalue).click();
		Thread.sleep(1000);
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//button[@title='Add equipment']")); 
		act.doubleClick(ele).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='MuiInputBase-root MuiInput-root MuiInput-underline']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='test equipment']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='check']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@style='margin-top: 5px;']")).click();
		Thread.sleep(12000);
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		Thread.sleep(3000);
		String ActualError = driver.findElement(By.xpath("//*[@class='MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-button MuiListItem-secondaryAction']")).getText();
		String ExpectedError = "Test1";
		if(ActualError.contains(ExpectedError)){
			System.out.println("The Patient is added successfully! ");
		}
		
		


	}
	
}

