package mobile_tests;

import config.AppiumConfig;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginPositiveTest(){
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("0bagginsbob@mail.com")
                .password("Qwerty123!")
                .build();
        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnThreeDots()
                .clickBtnLogin()
                .typeLoginFormPositive(user)
                .isTextInElementPresent_popUpMessageSuccess("Login success!"))
                ;
    }
    @Test
    public void loginNegativeTest_wrongPassword(){
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("0bagginsbob@mail.com")
                .password("Qwerty123!1111")
                .build();
        Assert.assertTrue(new SplashScreen(driver)
                .goToSearchScreen()
                .clickBtnThreeDots()
                .clickBtnLogin()
                .typeLoginFormNegative(user)
                .validateErrorMessage("Login or Password incorrect"))
                ;
    }
}
