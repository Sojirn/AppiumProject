package testappium;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;


public class AppiumDriverManager {
	String userDir = System.getProperty("user.dir") + "/src/test/resources/";
	AppiumDriver driver;
	@Test 
	public void launchApp() throws MalformedURLException
	{
		//*[contains(@text,'Property 
		//For Rent')]
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		capabilities.setCapability(MobileCapabilityType.APP, userDir + "Pulse_Pass_base.apk");
		capabilities.setCapability("appPackage", "com.pulse.music");
		capabilities.setCapability("ignoreHiddenApiPolicyError", true);
		capabilities.setCapability("fullReset", true);
		//capabilities.setCapability("deviceName", "IRZHFIYLAYW4YD8T");
		capabilities.setCapability("appWaitActivity", "com.pulse.music.ui.splash.SplashActivity");
		 driver=new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bt_get_started")));
		driver.findElement(By.id("bt_get_started")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tv_continue_as_guest")));
		driver.findElement(By.id("tv_continue_as_guest")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edt_search")));
		driver.findElement(By.id("edt_search")).sendKeys("80");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imgPlaylist")));
		driver.findElement(By.id("imgPlaylist")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPrevious")));
		driver.findElement(By.id("btnPrevious")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_play")));
		driver.findElement(By.id("btn_play")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNext")));
		driver.findElement(By.id("btnNext")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnMinimize")));
		driver.findElement(By.id("btnMinimize")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("img_pulse_icon")));
		driver.findElement(By.xpath("//*[contains(@resource-id,'navigation_metaverse')]//*[contains(@resource-id,'navigation_bar_item_icon_view')]")).click();
         WebElement slider=driver.findElement(By.id("tv_pulse_metaverse"));
		Point source = slider.getLocation();
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(finger, 1);
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),source.x,source.y));
		sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
		sequence.addAction(new Pause(finger, Duration.ofMillis(600)));
		sequence.addAction(finger.createPointerMove(Duration.ofMillis(600),
		       PointerInput.Origin.viewport(), source.x + 400, source.y));
		sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
		driver.perform(Collections.singletonList(sequence));
		List<String> l1 = new ArrayList<String>()
		
		/*final List<String> l1 = new ArrayList<String>();
		l1.add("soji");
		l1.add("satheesh");
		
		List<List<String>> l2 = Collections.singletonList(l1)*/;

	
		
		
	}
	

}
