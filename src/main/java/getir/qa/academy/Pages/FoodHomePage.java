package getir.qa.academy.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class FoodHomePage extends Common{
    Boolean localAndroid;
    public FoodHomePage(AppiumDriver<MobileElement> appiumDriver, Boolean device) {
        super(appiumDriver);
        localAndroid = device;
    }

    @AndroidFindBy(id = "com.getir.dev:id/tooltipTextView")
    MobileElement getirFoodPage;

    @iOSXCUITFindBy(accessibility = "negativeButton")
    @AndroidFindBy(id = "com.getir.dev:id/gaDialog_negativeButton")
    MobileElement closePopUp;

    @AndroidFindBy(id = "com.getir.dev:id/rowfoodrestaurant_rootConstraintLayout")
    @iOSXCUITFindBy(accessibility = "imgView")
    List<MobileElement> restaurants;

    public void waitFoodPage(){
        waitForVisibility(closePopUp);
        click(closePopUp);
    }

    public Boolean isInThePage() {
        try {
            getirFoodPage.isDisplayed();
            return true;
        } catch (Exception ignored) {

        }
        return false;
    }

    public void selectRestaurant(){
        Random random = new Random();
        int randomNumber = random.nextInt(restaurants.size());
        restaurants.get(randomNumber).click();
    }
}
