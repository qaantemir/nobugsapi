import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

public class UiTests {

    @Test
    public void parabankRegisterFormValidation_test() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement firstName = Selenide.element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("John");

        SelenideElement lastName = Selenide.element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Doe");

//        SelenideElement address = Selenide.element(Selectors.byId("customer.address.street"));
//        address.sendKeys("123 Main St");
//
//        SelenideElement city = Selenide.element(Selectors.byId("customer.address.city"));
//        city.sendKeys("New York");
//
//        SelenideElement state = Selenide.element(Selectors.byId("customer.address.state"));
//        state.sendKeys("NY");
//
//        SelenideElement zipCode = Selenide.element(Selectors.byId("customer.address.zipCode"));
//        zipCode.sendKeys("10001");
//
//        SelenideElement ssn = Selenide.element(Selectors.byId("customer.ssn"));
//        ssn.sendKeys("123-45-6789");
//
//        SelenideElement username = Selenide.element(Selectors.byId("customer.username"));
//        username.sendKeys("johndoe");

        SelenideElement registerButton = Selenide.element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement addressError = Selenide.element(Selectors.byId("customer.address.street.errors"));
        SelenideElement cityError = Selenide.element(Selectors.byId("customer.address.city.errors"));
        SelenideElement stateError = Selenide.element(Selectors.byId("customer.address.state.errors"));
        SelenideElement zipCodeError = Selenide.element(Selectors.byId("customer.address.zipCode.errors"));
//        SelenideElement phoneError = Selenide.element(Selectors.byId("customer.address.street.errors"));
        SelenideElement ssnError = Selenide.element(Selectors.byId("customer.ssn.errors"));
        SelenideElement userNameError = Selenide.element(Selectors.byId("customer.username.errors"));
        SelenideElement passwordError = Selenide.element(Selectors.byId("customer.password.errors"));
        SelenideElement confirmError = Selenide.element(Selectors.byId("repeatedPassword.errors"));

        addressError.shouldHave(Condition.exactText("Address is required."));
        cityError.shouldHave(Condition.exactText("City is required."));
        stateError.shouldHave(Condition.exactText("State is required."));
        zipCodeError.shouldHave(Condition.exactText("Zip Code is required."));
//        phoneError.shouldHave(Condition.exactText(""));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));
        userNameError.shouldHave(Condition.exactText("Username is required."));
        passwordError.shouldHave(Condition.exactText("Password is required."));
        confirmError.shouldHave(Condition.exactText("Password confirmation is required."));




    }
}
