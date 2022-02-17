package getir.qa.academy.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RestaurantPage extends Common{
    public RestaurantPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.getir.dev:id/restaurantmenu_coordinatorLayout")
    @iOSXCUITFindBy(accessibility = "menuContainerView")
    MobileElement restaurantPage;

    public void waitForRestaurantPage(){
        waitForVisibility(restaurantPage);
    }
}
