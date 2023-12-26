package Task_Nitex.Login_script;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Positive_Login_Test {
	WebDriver driver;
	Login_Page loginpage;
	
	@BeforeMethod
	public void setUpDriverLink() throws InterruptedException {
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.clo3d.com/en/");
		loginpage = new Login_Page(driver);
		loginpage.clickCloseButton();
		loginpage.clickSignInButton();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void driverClose() {
		driver.quit();
	}
	
	@Test (priority = 1)
	public void VerifyWithInValidEmail() {
		loginpage.clickUsername();
		loginpage.setUsername("");
		loginpage.clickcontinueButton();
		loginpage.errorMessage();
	}
	
	@Test (priority = 2)
	public void VerifyWithInvalidPassword() {
		loginpage.clickUsername();
		loginpage.setUsername("mokaddes.arman.2111@gmail.com");
		loginpage.clickcontinueButton();
		loginpage.setPassword(" ");
		loginpage.clickConfirmButton();
		loginpage.errorMessage();
	}
	
	@Test (priority = 3)
	public void VerifyWithValidCred() throws InterruptedException {
		loginpage.setUsername("mokaddes.arman.2111@gmail.com");
		loginpage.clickcontinueButton();
		loginpage.setPassword("Armoka@12345");
		loginpage.clickConfirmButton();
		Thread.sleep(5000);
		if (driver.getTitle().contentEquals("CLO | 3D Fashion Design Software")) {
			System.out.println("The user is logged in to the system correctly.");
		}
		else {
            System.out.println("Login feature is not working.");
        }
	}
	
	@Test (priority = 4)
	public void VerifyWithDriverBackButton() {
		loginpage.clickUsername();
		loginpage.setUsername("mokaddes.arman.2111@gmail.com");
		loginpage.clickcontinueButton();
		loginpage.setPassword("Armoka@12345");
		loginpage.clickConfirmButton();
		driver.navigate().back();
		System.out.println("The page title is : " + driver.getTitle());
	}
}