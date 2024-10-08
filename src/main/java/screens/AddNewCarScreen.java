package screens;

import dto.CarDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class AddNewCarScreen extends BaseScreen{
    public AddNewCarScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editSerial']")
    AndroidElement fieldSerialNumber;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editMan']")
    AndroidElement fieldManufacture;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editModel']")
    AndroidElement fieldModel;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editCity']")
    AndroidElement fieldCity;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editPrice']")
    AndroidElement fieldPrice;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editCarClass']")
    AndroidElement fieldCarClass;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/text1']")
    AndroidElement fieldFuel;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editYear']")
    AndroidElement fieldYear;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editSeats']")
    AndroidElement fieldSeats;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editAbout']")
    AndroidElement fieldAboutCar;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/addCarBtn']")
    AndroidElement btnAddCar;

    public AddNewCarScreen typeAddNewCarForm(CarDto car) {
        fieldSerialNumber.sendKeys(car.getSerialNumber());
        fieldManufacture.sendKeys(car.getManufacture());
        fieldModel.sendKeys(car.getModel());
        fieldCity.sendKeys(car.getCity());
        fieldPrice.sendKeys(Double.toString(car.getPricePerDay()));
        fieldCarClass.sendKeys(car.getCarClass());
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println(height + "X" + width);
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(width/100, height/4*3))
                .moveTo(PointOption.point(width/100, height/4))
                .release().perform();
        typeFuel(car.getFuel());
        fieldYear.sendKeys(car.getYear());
        fieldSeats.sendKeys(""+car.getSeats());
        fieldAboutCar.sendKeys(car.getAbout());
        return this;
    }

    public MyCarsScreen clickBtnAddCarPositive(){
        btnAddCar.click();
        return new MyCarsScreen(driver);
    }


    private void typeFuel(String fuel) {
        fieldFuel.click();
        pause(2);
        AndroidElement element = driver.findElement
                (By.xpath("//*[@text='"+fuel+"']"));
        element.click();
    }
}
