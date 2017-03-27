import helpers.RandomValues;
import org.junit.Before;
import org.junit.Test;
import page.objects.HomePage;
import page.objects.LandingPage;
import pojo.User;
import rest.preconditions.RestCreateUser;
import test.data.UserCreator;

import static test.data.UserCreator.TEST_DATAFILE;


public class PetStoreTest extends TestBase {

    private User user;
    private LandingPage landingPage;
    private HomePage homePage;

    public String randomUsername = "john" + new RandomValues().getRandomAlphaNumericWithSize(2);

    @Before
    public void beforeTest() {
        setupSelenium();

        user = UserCreator.getUser(TEST_DATAFILE);
        user.setUsername(randomUsername);

        RestCreateUser preconditions = new RestCreateUser();
        preconditions.createUser(user);

        landingPage = new LandingPage();
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