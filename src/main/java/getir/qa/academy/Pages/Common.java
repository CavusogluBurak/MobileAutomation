package getir.qa.academy.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class Common {

    AppiumDriver<MobileElement> driver;
    public static final long WAIT = 50;

    public Common(AppiumDriver<MobileElement> appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(20)), this);
        driver = appiumDriver;
    }

    public void waitForVisibility(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear(MobileElement element) {
        waitForVisibility(element);
        element.clear();
    }

    public void click(MobileElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void sendText(MobileElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

    public void sendKey(String key){
        switch (key) {
            case "DEL":
                ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.DEL));
                break;
            case "1":
                ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.DIGIT_1));
                break;
            case "2":
                ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.DIGIT_2));
                break;
            case "3":
                ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.DIGIT_3));
                break;
            case "4":
                ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));
                break;
            case "BACK":
                ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }

    public void swipeUpAccordingToPhoneSize(String deviceType){
        if(deviceType.equals("Android")){
            Dimension d = driver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width/2, swipeEndWidth = width/2;
            int swipeStartHeight = (height*20) / 100;
            int swipeEndHeight = (height*60) / 100;

            new TouchAction(driver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        } else {
            Dimension d = driver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width/2, swipeEndWidth = width/2;
            int swipeStartHeight = (height*70) / 100;
            int swipeEndHeight = (height*30) / 100;

            new TouchAction(driver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        }
    }

    public void swipeDownAccordingToPhoneSize(String deviceType){
        if(deviceType.equals("Android")){
            Dimension d = driver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width/2, swipeEndWidth = width/2;
            int swipeStartHeight = (height*60) / 100;
            int swipeEndHeight = (height*20) / 100;

            new TouchAction(driver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        } else {
            Dimension d = driver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width/2, swipeEndWidth = width/2;
            int swipeStartHeight = (height*40) / 100;
            int swipeEndHeight = (height*20) / 100;

            new TouchAction(driver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        }
    }

    public void swipeTimes(int times, String deviceType){
        for(int i = 0; i<times; i++){
            if(deviceType.equals("Android")){
                swipeUpAccordingToPhoneSize(deviceType);
            } else {
                swipeDownAccordingToPhoneSize(deviceType);
            }
        }
    }

}
