package applicationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	WebDriver driver;

	//create the constructor 
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for login button
	By acceptcookies = By.xpath("//button[text()='Accept all cookies']");
	By signup = By.xpath("//button[contains(text(),'Sign up')]");
	By name = By.xpath("//input[@name='name']");
	By surname = By.xpath("//input[@name='surname']");
	By email = By.xpath("//input[@name='email']");
	By checkbox = By.xpath("(//div[@class='checkbox-input__holder clearfix']//button[@type='button'])[1]");
	By submitbutton = By.xpath("//button[@type='submit']");
	By thankyou = By.xpath("//*[text()='Thank you']");

	public void signup() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,(30));
		wait.until(ExpectedConditions.elementToBeClickable(signup)).click();
	
		  
	}
	public void name(String str) {
		driver.findElement(name).sendKeys(str);
	}
	public void surname(String str) {
		driver.findElement(surname).sendKeys(str);
	}
	public void email(String str) {
		driver.findElement(email).sendKeys(str);
	}
	public void checkbox() {
		Actions actions = new Actions(driver);
		actions.click().perform();
		driver.findElement(checkbox).click();
	}
	public void submitbutton() {
		driver.findElement(submitbutton).click();
	}
	public String getText() {
		return driver.findElement(thankyou).getText();
	}
	public void acceptcookies() {
		driver.findElement(acceptcookies).click();

	}
}
