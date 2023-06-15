package com.bongz.pages;

import com.bongz.driver.DriverManger;
import com.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NBASignUpPage extends BasePage{

    //@FindBy(how = How.ID, using = "email") private WebElement emailFld;
   // @FindBy(how = How.ID, using = "password") private WebElement passwordFld;
  //  @FindBy(how = How.ID, using = "firstName") private WebElement firstNameFld;
  //  @FindBy(how = How.ID, using = "lastName") private WebElement lastNameFld;
//    @FindBy(how = How.CSS, using = "select[name='dobyear']") private WebElement birthDateYearDropDown;
    //@FindBy(how = How.NAME, using = "country") private WebElement countryDropDown;
    //@FindBy(how = How.CSS, using = "label[for='privacyConsent'] div[class='Checkbox_iconWrapper__2k_0O']") private WebElement agreeTermsTickBox;

    private final By emailFld = By.cssSelector("#email");
    private final By passwordFld = By.id("password");
    private final By firstNameFld = By.id("firstName");
    private final By lastNameFld = By.id("lastName");
    private final By birthMonthDropDown = By.cssSelector("select[name='dobMonth']");
    private final By birthYearDropDown = By.cssSelector("select[name='dobyear']");
    private final By countryDropDown = By.name("country");
    private final By agreeTermsCheckBox = By.cssSelector("label[for='privacyConsent'] div[class='Checkbox_iconWrapper__2k_0O']");
    private final By createAccountBtn = By.id("submit");

    public NBASignUpPage(){}

    public String getTitle(){
        return getPageTitle();
    }

    public NBASignUpPage enterEmail(String email){
        sendKeys(emailFld, email, WaitStrategy.VISIBLE, "Email ");
        return this;
    }

    public NBASignUpPage enterPassword(String password){
        sendKeys(passwordFld, password, WaitStrategy.VISIBLE, "Password ");
        return this;
    }

    public NBASignUpPage enterFirstName(String firstName){
        sendKeys(firstNameFld, firstName, WaitStrategy.VISIBLE, "First Name ");
        return this;
    }

    public NBASignUpPage enterLastName(String lastName){
        sendKeys(lastNameFld, lastName, WaitStrategy.VISIBLE, "Last Name ");
        return this;
    }

/*public NBASignUpPage enterSignUpDetails(SignUp signUp){

        return enterEmail(signUp.getEmail())
                .enterPassword(signUp.getPassword())
                .enterFirstName(signUp.getFirstName())
                .enterLastName(signUp.getLastName());
}*/

    public NBASignUpPage selectBirthMonth(String birthMonth){
        WebElement element = DriverManger.getDriver().findElement(birthMonthDropDown);
        Select select =new Select(element);
        select.selectByVisibleText(birthMonth);

       return this;
    }

    public NBASignUpPage selectBirthYear(String birthYear){
        WebElement element = DriverManger.getDriver().findElement(birthYearDropDown);
        Select select = new Select(element);
        select.selectByVisibleText(birthYear);
        return this;
    }

    public NBASignUpPage selectCountry(String country){
        WebElement element = DriverManger.getDriver().findElement(countryDropDown);
        Select select = new Select(element);
        select.selectByVisibleText(country);
        return this;
    }

    public NBASignUpPage agreeTerms(){
        WebElement element = DriverManger.getDriver().findElement(agreeTermsCheckBox);
        if (!element.isSelected()){
            element.click();
        }
        return this;
    }

    public NBASignUpPage createAccount() throws Exception {
        click(createAccountBtn, WaitStrategy.CLICKABLE, "Create button ");
        return this;
    }
}
