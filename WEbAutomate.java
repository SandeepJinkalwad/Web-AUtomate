package automate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


 


public class WEbAutomate {

	public static void main(String[] args)  {
		
		//launch the ChromeBrowser
		System.setProperty("WebDriver.chrome.Driver","C:\\ChromeDriver\\chromedriver-win64\\");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Navigate to the FitPeo Homepage
		
		driver.get("https://www.fitpeo.com/");
		
		//Navigate to the Revenue Calculator Page:

		 driver.navigate().to("https://www.fitpeo.com/revenue-calculator");
		 
		//	Scroll down the page until the revenue calculator slider is visible.
		 
		JavascriptExecutor js = ((JavascriptExecutor)driver); 
		WebElement slider =driver.findElement(By.xpath("//input[@type='range']"));
		js.executeScript("scrollBy(0,300)");
		int xwidth = slider.getSize().width;		
		//	Adjust the slider to set its value to 820. 
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider,(int) (xwidth*4.7),0).perform();
		
		WebElement textbox=driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']"));
		textbox.clear();
		 textbox.sendKeys(Keys.chord("560", Keys.TAB));
	
		//textbox.sendKeys("560");
		 
			WebElement checkbox1 =driver.findElement(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']"));
			checkbox1.click();
			WebElement checkbox2 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]"));
			checkbox2.click();
			WebElement checkbox3 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]"));
			checkbox3.click();
			WebElement checkbox4 = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]"));
			checkbox4.click();
		    
		WebElement header = driver.findElement(By.xpath("//*[text()='Total Recurring Reimbursement for all Patients Per Month:']"));
		String actualtitle=header.getText();
		String expectedtitle="Total Recurring Reimbursement for all Patients Per Month:";
	      if(actualtitle == expectedtitle)
	      {
	    	  System.out.println("Not Verified");
	      }
	      else
	      {
	    	  System.out.println(actualtitle); 
	      }
	
		WebElement Va = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]"));
		String actualvalue=Va.getText();
		String expectedvalue="$111105";
		if(actualvalue == expectedvalue)
	      {
	    	  System.out.println("Not Verified");
	      }
	      else
	      {
	    	  System.out.println(actualvalue); 
	      }
		driver.close();
		
		

	}

}
