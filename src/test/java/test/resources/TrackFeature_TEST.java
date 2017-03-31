package test.resources;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TrackFeature_TEST {
	private ChromeDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	public static String curDir = System.getProperty("user.dir");
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTC002FeatureTrack() throws Exception {

		System.setProperty("webdriver.chrome.driver", curDir + "\\Drivers\\chromedriver.exe");

		// System.setProperty("webdriver.chrome.driver", curDir +
		// "/Drivers/chromedriver");

		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();

		baseUrl = "http://192.168.17.223:8080";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int tiempoC = 1000;
		int tiempoL = 1500;
		Robot robot = new Robot();
		driver.get(baseUrl + "/cargo-tracker/");
		robot.delay(tiempoC);
		driver.findElement(By.linkText("Administration Interface")).click();
		driver.findElement(By.linkText("Track")).click();
		robot.delay(tiempoC);
		driver.findElement(By.id("trackingForm:trackIdInput_input")).clear();
		driver.findElement(By.id("trackingForm:trackIdInput_input")).sendKeys("ABC123");
		robot.delay(tiempoL);
		driver.findElement(By.id("trackingForm:j_idt30")).click();
		robot.delay(tiempoC);
		String validadorTexto = driver.findElement(By.cssSelector("#result > strong")).getText();
		assertEquals("Handling History", validadorTexto);
		robot.delay(tiempoC);
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
