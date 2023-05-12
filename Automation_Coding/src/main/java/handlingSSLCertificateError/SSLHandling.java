package handlingSSLCertificateError;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLHandling {

	static WebDriver driver;

	public void setup() {
		WebDriverManager.edgedriver().setup();
	}

	public static void main(String[] args) throws InterruptedException {

		EdgeOptions options = new EdgeOptions();

		options.setAcceptInsecureCerts(true);

		driver = new EdgeDriver(options);

		driver.get("https://expired.badssl.com/");

//		((JavascriptExecutor) driver).executeScript("CertificateWarningController.visitInsecureWebsiteWithTemporaryBypass()");

		Thread.sleep(5000);
		System.out.println("The Page title is : " + driver.getTitle());

		driver.quit();

	}

}
