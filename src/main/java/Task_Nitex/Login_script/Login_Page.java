package Task_Nitex.Login_script;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	private WebDriver driver;
	public Login_Page(WebDriver driver) {
        this.driver = driver;
    }
	
	private By CookiesCloseButton = By.xpath("//button[@data-v-837ea953]");//text-button-1
    private By signINButton = By.xpath("//a[@href='/en/signin']");
    private By EmailInputBox = By.xpath("//input[@type='text']");//"//span[@class='text-center']"
	private By ContinuetoPasswordButton = By.xpath("//button[@data-v-cfe787b0]");
    private By PassInputBox = By.xpath("//input[@type='password']");
    private By ConfirmLoginButton = By.xpath("//button[@data-v-cfe787b0]");
    private By ErrorMessagecheck = By.xpath("//p[@data-v-954ee157]");
    
    
    public void clickCloseButton() {
		driver.findElement(CookiesCloseButton).click();
	    }
    public void clickSignInButton() {
		driver.findElement(signINButton).click();
	    }
    public void clickUsername () {
    	driver.findElement(EmailInputBox).click();
    }
    public WebElement errorMessage() {
		WebElement message = driver.findElement(ErrorMessagecheck);
	    System.out.println("Error Message: " + message.getText());
		return message;
	    }
	public void setUsername(String username) {
		WebElement userName = driver.findElement(EmailInputBox);
		userName.sendKeys(username);
	    }
	public void clickcontinueButton() {
    	driver.findElement(ContinuetoPasswordButton).click();
    }
	public void setPassword(String password) {
		WebElement passwordField = driver.findElement(PassInputBox);
		passwordField.sendKeys(password);
	    }
	public void clickConfirmButton() {
		driver.findElement(ConfirmLoginButton).click();
	    }
}
