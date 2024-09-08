package screens;

import dto.RegistrationBodyDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginEmail']")
    AndroidElement fieldEmail;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginPassword']")
    AndroidElement fieldPassword;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/loginBtn']")
    AndroidElement btnYalla;

    public SearchScreen typeLoginFormPositive(RegistrationBodyDto user){
        fieldEmail.sendKeys(user.getUsername());
        fieldPassword.sendKeys(user.getPassword());
        btnYalla.click();
        return new SearchScreen(driver);
    }

    public ErrorScreen typeLoginFormNegative(RegistrationBodyDto user) {
        fieldEmail.sendKeys(user.getUsername());
        fieldPassword.sendKeys(user.getPassword());
        btnYalla.click();
        return new ErrorScreen(driver);
    }
}
