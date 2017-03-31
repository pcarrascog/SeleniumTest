package test.resources;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BookFeature_TEST {
	private ChromeDriver driver;
	private String baseUrl;

	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	private StringBuffer verificationErrors = new StringBuffer();
	public static String curDir = System.getProperty("user.dir");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTC003() throws Exception {

		/*
		 * System.setProperty("webdriver.chrome.driver", curDir +
		 * "\\Drivers\\chromedriver.exe");
		 */
		System.setProperty("webdriver.chrome.driver", curDir + "/Drivers/chromedriver");
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();

		baseUrl = "http://192.168.17.223:8080";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int tiempoL = 1000;
		int tiempoML = 5000;
		Robot robot = new Robot();
		driver.get(baseUrl + "/cargo-tracker/");
		driver.findElement(By.linkText("Administration Interface")).click();
		robot.delay(tiempoL);
		driver.findElement(By.linkText("Book")).click();
		robot.delay(tiempoL);
		driver.findElement(By.xpath("//div[@id='j_idt29:origin']/div[3]/span")).click();
		robot.delay(tiempoML);
		driver.findElement(By.xpath("//div[@id='j_idt29:origin_panel']/div/ul/li[2]")).click();
		robot.delay(tiempoML);
		driver.findElement(By.id("j_idt29:j_idt36")).click();
		robot.delay(tiempoL);
		driver.findElement(By.xpath("//div[@id='j_idt29:destination']/div[3]/span")).click();
		driver.findElement(By.id("j_idt29:j_idt37")).click();
		robot.delay(tiempoL);
		driver.findElement(By.linkText("29")).click();
		robot.delay(tiempoL);
		driver.findElement(By.id("dateForm:bookBtn")).click();
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
