package org.mobileautomationdemo.test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class GameTVTest {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "4.4.2"); 
		capabilities.setCapability("deviceName","Emulator");
		capabilities.setCapability("platformName","Android");

		capabilities.setCapability("appPackage", "com.android.game.tv");
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.android.game.TV.gameTV"); 
		// This is Launcher activity of your app (you can get it from apk info app)
		
		
		//Create RemoteWebDriver instance and connect to the Appium server
		//It will launch the Game.TV App in Android Device using the configurations specified in Desired Capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testLoginonGameTVApp() throws Exception {
		//locate the Twitter icon on login screen using By.name()
		WebElement twitter=driver.findElement(By.name("twitter"));

	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}