package getir.qa.academy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

    AppiumDriver<MobileElement> appiumDriver;
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    Boolean localAndroid = false;

    @BeforeTest
    public void setup() throws InterruptedException, MalformedURLException {
        if (localAndroid) {
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.getir.dev");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.getir.core.feature.splash.SplashActivity");
            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            Thread.sleep(2000);
        } else {
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.0");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.getir.ios.dev.v2");
            desiredCapabilities.setCapability(IOSMobileCapabilityType.PROCESS_ARGUMENTS, "{\n" +
                    "    \"args\": [\n" +
                    "      \"getir-is-running-ui-tests\",\n" +
                    "      \"-AppleLanguages\",\n" +
                    "      \"(tr)\",\n" +
                    "      \"-AppleLocale\",\n" +
                    "      \"tr_TR\"\n" +
                    "    ]\n" +
                    "  }".toString());
            appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            Thread.sleep(2000);
        }
    }

    @AfterTest
    public void tearDown(){
        appiumDriver.quit();
    }
}
