package org.Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	
	public static WebDriver ChromeLaunch() { 
		
      WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		return driver;
		

	}
	public static void urlLaunch(String url) {
		
		driver.get(url);
	}
	
	public static void navigateUrl(String url) {
		driver.navigate().to(url);

	}
	
	public static void impWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
	
	public static void sendkeys(WebElement e,String data) {
		e.sendKeys(data);

	}
	
	public static void btnClick(WebElement e) {
		e.click();

	}
	
	public static String getCurrentUrl() {
		
		String url = driver.getCurrentUrl();
		return url;

	}
	
     public static String getAttribute(WebElement e) {
		
    	 String att = e.getAttribute("value");
		return att;
	}
     
     public static String getText(WebElement e) {
		String text = e.getText();
		return text;
		
	}
     
     
     
	
     public static void actDragAndDrop(WebElement from,WebElement to) {
		Actions a=new Actions(driver);
		a.dragAndDrop(from, to).perform();

	}
     
     public static void actSendkeys(WebElement e,String text) {
    	 Actions a=new Actions(driver);
    	a.sendKeys(e, text).perform();
	}
	
	public static void actclick(WebElement e) {
		Actions a=new Actions(driver);
        a.click(e).perform();  
	}
	
	
	public static void actDoubleClick(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e).perform();
	}
	public static void actContextClick(WebElement e) {
		Actions a=new Actions(driver);
		a.contextClick(e).perform();
	
	}
	public static void actClickHoldAndRelease(WebElement from,WebElement to) {
		Actions a=new Actions(driver);
        a.clickAndHold(from).release(to).perform();
	}
	
	public static void actClickMoveRelease(WebElement from,WebElement to) {
		Actions a=new Actions(driver);
		a.clickAndHold(from).moveToElement(to).release().perform();

	}
	

	
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);

	}
	
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);

	}
	
	public static void selectByVisibletext(WebElement e,String text) {
		Select s=new Select(e);
		s.selectByVisibleText(text);

	}
	
      public static String selGetFirstSelectedOptions(WebElement e) {
    	  Select s=new Select(e);
    	  WebElement firstSelectedOption = s.getFirstSelectedOption();
    	  String text = firstSelectedOption.getText();
    	  return text;
	}
	
	public static void selGetAllSelectedOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for(int i=0;i<allSelectedOptions.size();i++) {
		WebElement webElement = allSelectedOptions.get(0);
		String text = webElement.getText();}
		

	}
	
	
	
	
	
	
	
	
	
	public static void acceptAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	
	public static void disMissAlert() {
		Alert a = driver.switchTo().alert();
      a.dismiss();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//public static void getTakeScreenShot() throws IOException {
//
//	TakesScreenshot ts= (TakesScreenshot)driver;
//	
//	File from=ts.getScreenshotAs(OutputType.FILE);
//	System.out.println(from);
//	
//	File to = new File(url);
//	
//	FileUtils.copyFile(from, to);
//	
//
//}
	
	
	public static  void frameByIndex(int index) {
		driver.switchTo().frame(index);

	}
	
	public static  void framesByNameOrId(String nameorid) {
		driver.switchTo().frame(nameorid);

	}
	public static  void frameByWebElement(WebElement e) {
		driver.switchTo().frame(e);

	}
	
	
	public static void parentFrame() {
		driver.switchTo().parentFrame();
		
	}
	
	public static void defaultContent() {
		driver.switchTo().defaultContent();

	}
	
	
	public static void forward() {
		driver.navigate().forward();
	}
	
	
	public static void back() {
		driver.navigate().back();

	}
	
   public static void refresh() {
	driver.navigate().refresh();
}

public static void WindowHandles(int index) {

Set<String> allwin = driver.getWindowHandles();

List<String>li=new ArrayList<String>();
li.addAll(allwin);
driver.switchTo().window(li.get(index));

}
	
//   public static void WebDriverWait(WebElement e,int sec) {
//	WebDriverWait q=new WebDriverWait(driver, Duration.ofSeconds(20));
//
//}
	
	 public static  WebDriver browserLaunch(String browserName) {
		 String a=browserName;
		 
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		else  {
			System.err.println("invalid browser name");
		}
		return driver;
		
	}
	 
	 
	 public static void jssetAttribute(String text,WebElement e) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
         js.executeScript("arguments[0].setAttribute('value','"+text+"'", e);
	}
	 
	 public static void jsClick(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", e);

	}
	 
	 public static void jsscrollUp(WebElement e) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollInToview('true')", e);
	 }
	 
	 public static void jsscrollDown(WebElement e) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollInToview('false')", e);

	}
	 
	 public static String jsgetAttribute(WebElement e) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
         Object executeScript = js.executeScript("return arguments[0].getAttribute('value')",e);
		String data=(String) executeScript;
		return data;

	}
	 
	  public static void quit() {
		driver.quit();

	}
	 public static boolean isEnabled(WebElement a) {
		boolean enabled = a.isEnabled();
		return enabled;

	}
	 
	 public static boolean isDisplayed(WebElement a) {
			boolean displayed = a.isDisplayed();
			return displayed;

		}
		 
	 public static boolean isSelected(WebElement a) {
		boolean selected = a.isSelected();
		return selected;

	}
	 
	 
	 public static void takeScreenshot(String imagename) throws IOException {
	TakesScreenshot tk=(TakesScreenshot)driver;
	File src = tk.getScreenshotAs(OutputType.FILE);
	
	File des=new File(System.getProperty("user.dir")+"/src/test/resources/ScreenShots/"+imagename+".png");
	FileUtils.copyFile(src, des);


	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
