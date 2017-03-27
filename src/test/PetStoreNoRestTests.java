import helpers.RandomValues;
import org.junit.Before;
import org.junit.Test;
import page.objects.HomePage;
import page.objects.LandingPage;
import pojo.User;
import test.data.UserCreator;

import static java.lang.String.valueOf;
import static test.data.UserCreator.TEST_DATAFILE;


public class PetStoreNoRestTests extends TestBase {

    private User user;
    private LandingPage landingPage;
    private HomePage homePage;
    public String randomUsername = "john" + new RandomValues().getRandomAlphaNumericWithSize(2);

    @Before
    public void beforeTest() {
        setupSelenium();
        user = UserCreator.getUser(TEST_DATAFILE);
        user.setUsername(randomUsername);

        landingPage = new LandingPage();

        landingPage
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .clickOnRegisterLink()
                .typeIntoUserId(user.getUsername())
                .typeIntoNewPassword(user.getPassword())
                .typeIntoRepeatedPassword(user.getPassword())
                .typeIntoFirstName(user.getFirstName())
                .typeIntoLastName(user.getLastName())
                .typeIntoEmail(user.getEmail())
                .typeIntoPhone(user.getPhone())
                .typeIntoAddress1(user.getAddress1())
                .typeIntoCity(user.getCity())
                .typeIntoState(user.getState())
                .typeIntoZip(valueOf(user.getZip()))
                .typeIntoCountry(user.getCountry())
                .clickOnSaveAccountInformation()
                .assertThatSignInIsDisplayed();

        navigateToLandingPage();

        homePage = landingPage
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoUsername(user.getUsername())
                .typeIntoPassword(user.getPassword())
                .clickOnLogin();
    }

    @Test
    public void asRegisteredUserLogIntoTheShop() {
        homePage
                .assertThatMyAccountLinkIsDisplayed();
    }

    @Test
    public void asRegisteredUserPlaceAnOrder() {
        homePage
                .clickOnFishCategory()
                .clickOnAngelFish()
                .clickOnAddToCardForLargeAngelFish()
                .clickOnProceedToCheckOut()
                .clickOnContinueButton()
                .clickOnOrder()
                .assertThatThankYouOrderMessageWasDisplayed();
    }
}