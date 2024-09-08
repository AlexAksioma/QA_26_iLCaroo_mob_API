package mobile_tests;

import api.CarController;
import config.AppiumConfig;
import dto.CarDto;
import dto.CarsDto;
import dto.Fuel;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.Random;

public class AddNewCarTests extends AppiumConfig {

    SearchScreen searchScreen;
    @BeforeMethod
    public void login() {
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("0bagginsbob@mail.com")
                .password("Qwerty123!")
                .build();
        searchScreen =new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnThreeDots()
                .clickBtnLogin()
                .typeLoginFormPositive(user)
        ;
    }

    @Test
    public void addNewCarPositiveTest() {
        int i = new Random().nextInt(1000) + 1000;
        CarDto car = CarDto.builder()
                .serialNumber("777-" + i)
                .manufacture("Tesla")
                .model("Model X")
                .year("2024")
                .fuel(Fuel.ELECTRIC.getFuel())
                .seats(4)
                .carClass("B")
                .pricePerDay(1.23)
                .city("Netanya")
                .about("My car")
                .build();
        searchScreen.clickBtnThreeDots()
                .clickBtnMyCars()
                .clickBtnAddNewCar()
                .typeAddNewCarForm(car)
                .clickBtnAddCarPositive()
        ;

//        CarController carController = new CarController();
//        CarsDto carsDto = carController.getAllUserCarResponse(token)
//        for (CarDTO carAPI : carsDto.getCars()) {
//            System.out.println(carAPI.getSerialNumber());
//            if (carAPI.getSerialNumber().equals(car.getSerialNumber())) {
//                Assert.assertEquals(carAPI, car);
//                break;
//            }
//        }
    }
}
