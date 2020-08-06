package framework;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import myreports.ExtentManager;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest extends TestListener implements ITestListener {

	protected static AppiumDriver<MobileElement> driver;

	protected static ExtentReports myExtent;
	protected static ExtentTest myTest;
	static AppiumDriverLocalService service;
	String serverIP = "127.0.0.1";
	int portNumber = 4723;
	ITestResult result;

	@Parameters({ "deviceName", "version", "deviceID" })
	@BeforeTest
	public void TestSetUp(String deviceName, String version, String deviceID) throws InterruptedException, IOException {
		String projectPath = System.getProperty("user.dir");
		System.out.println("===============  Execuiting Base Test Class ================");
		System.out.println("===============  Parameters Set as below to run    ================");
		System.out.println("Device Name    " + deviceName);
		System.out.println("Device Id      " + deviceID);
		System.out.println("Device Android Version    " + version);
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			caps.setCapability(MobileCapabilityType.UDID, deviceID);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability(MobileCapabilityType.APP,
					projectPath + "\\src\\main\\resources\\APP\\Fred_Hutch_POC_2.1.apk");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, caps);
			myExtent = ExtentManager.GetExtent();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterTest
	public void TearDown() throws InterruptedException {
		System.out.println("After Test");
		Thread.sleep(2000);
		driver.quit();
		Thread.sleep(2000);
		myExtent.flush();

	}

}
