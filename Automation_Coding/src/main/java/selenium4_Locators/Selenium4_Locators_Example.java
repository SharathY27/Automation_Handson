package selenium4_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4_Locators_Example {

	public void above() {
		RelativeLocator.with(By.tagName("")).above(By.id(""));
	}

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();

		WebDriver driver = new EdgeDriver();

		
		
	}

}
