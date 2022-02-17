package getir.qa.academy;

import getir.qa.academy.Pages.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class TestSteps extends BaseClass {
    OnboardPage onboardPage;
    LoginPage loginPage;
    HomePage homePage;
    FoodHomePage foodHomePage;
    RestaurantPage restaurantPage;

    /* In this test case user will login and select the address from
    address bar then go to food domain and select random restaurant */
    @Test
    public void test3() throws InterruptedException {
        onboardPage = new OnboardPage(appiumDriver);
        if(localAndroid){
            onboardPage.clickAllowPermissionButton();
        } else {
            onboardPage.clickUseLocationButton();
            onboardPage.clickAllowPermissionButton();
        }
        onboardPage.waitForAnimation();
        onboardPage.clickLoginButton();
        loginPage = new LoginPage(appiumDriver, localAndroid);
        loginPage.waitForGetirTitle();
        loginPage.checkCountryCode();
        loginPage.enterPhoneNo("5458010808");
        loginPage.clickLoginButton();
        loginPage.enterOTP();
        homePage = new HomePage(appiumDriver);
        homePage.waitForLandingPageView();
        homePage.clickAddresBar();
        if(!localAndroid){
            Thread.sleep(20);
        }
        homePage.selectAddress("Arnavutköy");
        homePage.waitForLandingPageView();
        homePage.selectDomain("getiryemek");
        foodHomePage = new FoodHomePage(appiumDriver, localAndroid);
        foodHomePage.waitFoodPage();
        if(localAndroid){
            while (foodHomePage.isInThePage()){
                foodHomePage.sendKey("BACK");
            }
            foodHomePage.swipeTimes(3, "Android");
        } else {
            foodHomePage.swipeTimes(3, "iOS");
        }
        foodHomePage.selectRestaurant();
        restaurantPage = new RestaurantPage(appiumDriver);
        restaurantPage.waitForRestaurantPage();
    }



}
