package applicationpages;

import org.testng.annotations.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUITest {
	WebDriver driver;

	@Test
	public void scenario1() throws InterruptedException {
		System.out.println("--------BeforeTest----------------");

		driver.get("https://www.investec.com/en_za/focus/money/understanding-interest-rates.html");
		driver.manage().window().maximize();

		SignUpPage signup = new SignUpPage(driver);
		signup.acceptcookies();
		signup.signup();
		System.out.println("After");
		signup.name("Laxmi");
		signup.surname("Suruaknti");
		signup.email("test@investec.co.za");
		signup.checkbox();
		signup.submitbutton();
		Thread.sleep(5000);
		Assert.assertEquals("Thank you", signup.getText());

	}

	@BeforeTest
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "./chromedri" + "" + "ver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	@AfterTest
	public void afterMethod() { // close and quit the browser
		driver.quit();
	}

}
