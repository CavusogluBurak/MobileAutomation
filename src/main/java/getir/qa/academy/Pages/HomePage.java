package getir.qa.academy.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class HomePage extends Common{
    public HomePage(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.getir.dev:id/landing_picker")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeCollectionView\"")
    MobileElement langinPageView;

    @AndroidFindBy(id = "com.getir.dev:id/serviceGrid_textView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")
    List<MobileElement> domains;

    @AndroidFindBy(id = "com.getir.dev:id/layoutaddress_destinationAddressTextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[3]")
    MobileElement addressBar;

    @AndroidFindBy(id = "com.getir.dev:id/layoutaddress_destinationTitleTextView")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"lblAddress\"`]")
    List<MobileElement> addresses;

    public void waitForLandingPageView(){
        waitForVisibility(langinPageView);
    }

    public void clickAddresBar(){
        click(addressBar);
    }

    public void selectAddress(String addressTitle){
        for (MobileElement title : addresses) {
            if (title.getText().contains(addressTitle)) {
                title.click();
                break;
            }
        }
    }

    public void waitForAddress(){
        waitForVisibility(addresses.get(0));
    }

    public void selectDomain(String domainName){
        for (MobileElement title : domains) {
            if (Objects.equals(title.getText(), domainName)) {
                title.click();
                break;
            }
        }
    }
}
