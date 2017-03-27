package page.objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import setup.Driver;

import static java.lang.System.out;

public class UserRegistrationPage extends Page {

    @FindBy(name = "username")
    private WebElement userIdField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "repeatedPassword-test")
    private WebElement repeatedPasswordField;

    @FindBy(name = "account.firstName")
    private WebElement accountFirstNameField;

    @FindBy(name = "account.lastName")
    private WebElement accountLastNameField;

    @FindBy(name = "account.email")
    private WebElement accountEmailField;

    @FindBy(name = "account.phone")
    private WebElement accountPhoneField;

    @FindBy(name = "account.address1")
    private WebElement accountAddress1Field;

    @FindBy(name = "account.city")
    private WebElement accountCityField;

    @FindBy(name = "account.state")
    private WebElement accountStateField;

    @FindBy(name = "account.zip")
    private WebElement accountZipField;

    @FindBy(name = "account.country")
    private WebElement accountCountryField;

    @FindBy(name = "newAccount")
    private WebElement newAccountButton;

    public UserRegistrationPage() {
        waitForPageToLoad();
        PageFactory.initElements(new AjaxElementLocatorFactory(Driver.getInstance(), TIME_OUT), this);
        waitForElementsToLoad(userIdField, passwordField, accountFirstNameField);
    }

    public UserRegistrationPage typeIntoUserId(String username) {
        userIdField.sendKeys(username);
        out.println("Type into field username " + username);
        return this;
    }

    public UserRegistrationPage typeIntoNewPassword(String newPassword) {
        passwordField.sendKeys(newPassword);
        out.println("Type into field new password " + newPassword);
        return this;
    }

    public UserRegistrationPage typeIntoRepeatedPassword(String repeatPassword) {
        repeatedPasswordField.sendKeys(repeatPassword);
        out.println("Type into field Repeat Password " + repeatPassword);
        return this;
    }

    public UserRegistrationPage typeIntoFirstName(String firstName) {
        accountFirstNameField.sendKeys(firstName);
        out.println("Type into field FirstName " + firstName);
        return this;
    }

    public UserRegistrationPage typeIntoLastName(String lastName) {
        accountLastNameField.sendKeys(lastName);
        out.println("Type into field Last Name " + lastName);
        return this;
    }

    public UserRegistrationPage typeIntoEmail(String email) {
        accountEmailField.sendKeys(email);
        out.println("Type into field Email " + email);
        return this;
    }

    public UserRegistrationPage typeIntoPhone(String phone) {
        accountPhoneField.sendKeys(phone);
        out.println("Type into field phone " + phone);
        return this;
    }

    public UserRegistrationPage typeIntoAddress1(String address1) {
        accountAddress1Field.sendKeys(address1);
        out.println("Type into field address1 " + address1);
        return this;
    }

    public UserRegistrationPage typeIntoCity(String city) {
        accountCityField.sendKeys(city);
        out.println("Type into field city " + city);
        return this;
    }

    public UserRegistrationPage typeIntoState(String state) {
        accountStateField.sendKeys(state);
        out.println("Type into field state " + state);
        return this;
    }

    public UserRegistrationPage typeIntoZip(String zip) {
        accountZipField.sendKeys(zip);
        out.println("Type into field zip " + zip);
        return this;
    }

    public UserRegistrationPage typeIntoCountry(String country) {
        accountCountryField.sendKeys(country);
        out.println("Type into field country " + country);
        return this;
    }

    public HomePage clickOnSaveAccountInformation() {
        newAccountButton.click();
        out.println("Clicked on New account button");
        return new HomePage();
    }

}
