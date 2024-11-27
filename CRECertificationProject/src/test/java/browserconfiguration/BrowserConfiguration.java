package browserconfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfiguration {

	public static WebDriver driver;

	public static WebDriver startBrowser(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":
			// Configuring the path for ChromeDriver (Windows)

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			// Configuring the path for GeckoDriver (Windows)

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			// Configuring the path for EdgeDriver (Windows)

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
			break;


		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		return driver;
	}

	public static void closeBrowser() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}