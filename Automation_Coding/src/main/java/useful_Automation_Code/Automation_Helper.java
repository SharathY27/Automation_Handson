package useful_Automation_Code;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation_Helper {

	JavascriptExecutor js;

	WebDriver driver;

	public static void browserSetup(WebDriver driver) {
		WebDriverManager.edgedriver().setup();

		EdgeOptions options = new EdgeOptions().addArguments("--remote-allow-origins=*");

		driver = new EdgeDriver(options);

	}

	public static void tearDown(WebDriver driver) {
		driver.quit();
	}

	public static void openNewWindow(boolean tab, WebDriver driver, boolean javascriptExecutor) {
		if (tab && !javascriptExecutor)
			driver.switchTo().newWindow(WindowType.TAB);
		else {
			driver.switchTo().newWindow(WindowType.WINDOW);
		}
		// using JavascriptExecutor
		if (javascriptExecutor) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.open()");
		}
		
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	}

	public void takeScreenshot(WebDriver driver) throws IOException {
		File screenshotDestination = new File(
				"C:\\Users\\Sharath\\eclipse-workspace\\Automation_Coding\\Screenshots\\snapshot.png");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, screenshotDestination);
	}

	public static void closeTab(WebDriver driver) {
		List<String> handles = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Handles : " + handles);
		driver.switchTo().window(handles.get(1)).close();
		driver.switchTo().window(handles.get(0));
	}

	public void openAmazonWebsite() throws InterruptedException, IOException {

		WebDriverManager.edgedriver().setup();

		EdgeOptions options = new EdgeOptions().addArguments("--remote-allow-origins=*");

		driver = new EdgeDriver(options);

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		Thread.sleep(8000);

		takeScreenshot(driver);

		openNewWindow(false, driver, false);
		Thread.sleep(4000);

		closeTab(driver);

		tearDown(driver);

	}

	public String getTextFromClipboard() throws UnsupportedFlavorException, IOException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		String text = (String) clipboard.getData(DataFlavor.stringFlavor);
		return text;
	}

	public int getRandomNumber() {

		Supplier<Integer> random = () -> {
			int max = 10, min = 1;
			return (int) (Math.random() * (max - min + 1) + min);
		};
		return random.get();
	}

	public void refreshWebpage(WebDriver driver) {
		driver.get(driver.getCurrentUrl());
	}

	// window.scrollTo and window.scroll => will scroll from top of page from(0,0)
	// window.scrollBy => will scroll from current position of webPage

	public void scrollBycoordinates(int x, int y, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")", new Object() {
		});
	}

	public void scroll_To_Botton_Of_Page(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scroll_To_Element(WebDriver driver, WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void wait_Until_Page_Is_Loaded(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("return document.readystate").toString().equals("complete");
	}

	public String getDateBasedOnTodaysDate(boolean upcomingDays, long howManyDaysBeforeOrAfter,
			boolean monthInLetterFormat, boolean firstThreeLetterOfMonth) {

		String months[] = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"November", "December" };

		LocalDate today = LocalDate.now();
		LocalDate returningDate;
		String month = "";
		if (upcomingDays) {
			returningDate = today.plusDays(howManyDaysBeforeOrAfter);
		} else {
			returningDate = today.minusDays(howManyDaysBeforeOrAfter);
		}

		if (monthInLetterFormat && firstThreeLetterOfMonth) {
			month = months[returningDate.getMonthValue()].substring(0, 3);
		} else {
			month = months[returningDate.getMonthValue()];
		}

		String monthIntegerValue = today.toString().substring(5, 7);
		return returningDate.toString().replace(monthIntegerValue, month);

	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public String updateExistingJson() throws FileNotFoundException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		File jsonFile = new File("src/main/resources/Sample_Json.json");
		Object obj = jsonParser.parse(new FileReader(jsonFile));
		JSONObject jsonObject = (JSONObject) obj;
		jsonObject.put("Today date",getDateBasedOnTodaysDate(false, 0, true, false));
		FileWriter fw = new FileWriter(jsonFile);
		fw.write(jsonObject.toString());
		fw.close();
		return FileUtils.readFileToString(jsonFile);
	}

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		Automation_Helper helper = new Automation_Helper();

//		System.out.println(helper.getDateBasedOnTodaysDate(false, 0, true, true));
		System.out.println(helper.updateExistingJson());

	}

}
