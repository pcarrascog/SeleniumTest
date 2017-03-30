package test.resources;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AboutFeatureFirefox {
	
	public static String curDir = System.getProperty("user.dir");
	private WebDriver driver;
	private String baseUrl;

	private StringBuffer verificationErrors = new StringBuffer();
	DesiredCapabilities capabilities = DesiredCapabilities.firefox();

	@Before
	public void setUp() throws Exception {
		/*
		 * System.setProperty("webdriver.gecko.driver", curDir +
		 * "\\Drivers\\geckodriver.exe"); driver = new FirefoxDriver();
		 * 
		 * System.setProperty("webdriver.chrome.driver", curDir +
		 * "\\Drivers\\chrome.exe"); WebDriver driver = new ChromeDriver();
		 * 
		 * System.setProperty("webdriver.ie.driver", curDir +
		 * "\\Drivers\\IEDriverServer.exe"); driver = new
		 * InternetExplorerDriver();
		 * 
		 */
	}

	@Test
	public void testAboutFeature() throws Exception {
		/*
		 * System.setProperty("webdriver.chrome.driver", curDir +
		 * "/Drivers/chromedriver");
		 * 
		 */
		System.setProperty("webdriver.firefox.bin","/usr/bin/firefox");
		System.setProperty("webdriver.gecko.driver", curDir + "/Drivers/geckodriver"); 
		capabilities.setCapability("marionette", true);
		capabilities.setBrowserName("firefox");
		capabilities.setCapability("firefox_binary","/usr/bin/firefox");
		driver = new FirefoxDriver(capabilities);

		driver.manage().window().maximize();

		baseUrl = "http://192.168.17.223:8080";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int tiempoL = 1000;
		int tiempoML = 5000;
		Robot robot = new Robot();

		driver.get(baseUrl + "/cargo-tracker/");
		robot.delay(tiempoML);
		driver.findElement(By.linkText("Administration Interface")).click();
		robot.delay(tiempoL);
		driver.findElement(By.linkText("About")).click();
		robot.delay(tiempoL);
		assertEquals("This interface includes several features for Cargo Administrators:",
				driver.findElement(By.cssSelector("h3")).getText());
		robot.delay(tiempoL);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
