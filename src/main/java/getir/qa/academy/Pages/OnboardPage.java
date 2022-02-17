package getir.qa.academy.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OnboardPage extends Common {

    public OnboardPage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    @iOSXCUITFindBy(accessibility = "Allow Once")
    MobileElement allowPermission;

    @iOSXCUITFindBy(accessibility = "useLocationButton")
    MobileElement useLocationButton;

    @AndroidFindBy(id = "com.getir.dev:id/onboarding_innerAnimationView")
    @iOSXCUITFindBy(accessibility = "onboardingView")
    MobileElement innerAnimation;

    @AndroidFindBy(id = "com.getir.dev:id/onboarding_signInTextView")
    @iOSXCUITFindBy(accessibility = "btnLogin")
    MobileElement onboardingLoginButton;

    public void clickUseLocationButton(){ click(useLocationButton);}

    public void clickAllowPermissionButton(){
        click(allowPermission);
    }

    public void waitForAnimation(){
        waitForVisibility(innerAnimation);
    }

    public void clickLoginButton(){
        click(onboardingLoginButton);
    }


}
