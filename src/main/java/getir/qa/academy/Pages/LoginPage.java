package getir.qa.academy.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class LoginPage extends Common{
    Boolean localAndroid;
    public LoginPage(AppiumDriver<MobileElement> appiumDriver, Boolean device) {
        super(appiumDriver);
        localAndroid = device;
    }


    @AndroidFindBy(id = "com.getir.dev:id/signin_countryCodeTextView")
    MobileElement countryCode;

    @AndroidFindBy(id = "com.getir.dev:id/ga_toolbar_getir10TitleTextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"Giriş\"`]" )
    MobileElement getirTitle;

    @AndroidFindBy(id = "com.getir.dev:id/signin_countryCodeConstraintLayout")
    @iOSXCUITFindBy(accessibility = "comboCountryCode")
    MobileElement countryCodeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Turkey']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == '\uD83C\uDDF9\uD83C\uDDF7 Turkey'")
    MobileElement selectTurkey;

    @AndroidFindBy(xpath = "//*[@resource-id='com.getir.dev:id/signin_phoneTextInputLayout']/android.widget.EditText")
    @iOSXCUITFindBy(accessibility = "txtPhoneNumber")
    MobileElement phoneNoTextField;

    @AndroidFindBy(id = "com.getir.dev:id/signin_signInButton")
    @iOSXCUITFindBy(accessibility = "btnLogin")
    MobileElement loginButton;

    @AndroidFindBy(id = "com.getir.dev:id/onetimepassword_codeGAOTPEditText")
    @iOSXCUITFindBy(accessibility = "txtCode")
    MobileElement OTPText;

    public void waitForGetirTitle(){
        waitForVisibility(getirTitle);
    }

    public void checkCountryCode()  {
        if(localAndroid){
            if(countryCode.getText().contains("+90")){
                Assert.assertTrue(true);
            } else {
                click(countryCodeButton);
                click(selectTurkey);
            }
        } else {
                click(countryCodeButton);
                click(selectTurkey);
            }
        }

    public void enterPhoneNo(String phoneNo){
        sendText(phoneNoTextField, phoneNo);
    }

    public void clickLoginButton(){
        if(loginButton.isEnabled()){
            click(loginButton);
        } else {
            Assert.fail("Üye girişi tuşu aktif değildir, lütfen zorunlu alanları doldurun.");
        }
    }

    public void enterOTP(){
        if(localAndroid){
            click(OTPText);
            sendKey("DEL");
            sendKey("DEL");
            sendKey("1");
            sendKey("2");
            sendKey("3");
            sendKey("4");
        } else {
            sendText(OTPText, "1234");
        }

    }
}
