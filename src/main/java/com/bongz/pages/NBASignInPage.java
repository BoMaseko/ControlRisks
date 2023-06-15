package com.bongz.pages;

import com.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public class NBASignInPage extends BasePage{

    private final By registerNewNbaId = By.cssSelector(".Anchor_anchor__cSc3P.SignIn_dontHaveAccountLink__jiAqc.Link_styled__okbXW");
    private final By emailFld = By.id("email");
    private final By passwordFld = By.id("password");
    private final By signButton = By.id("submit");

    public String getTitle(){
        return getPageTitle();
    }

    public NBASignUpPage registerNewNBAId() throws Exception {
        click(registerNewNbaId, WaitStrategy.CLICKABLE, "Don't have an NBA ID? ");
        return new NBASignUpPage();
    }

    public NBASignInPage enterEmail(String email){
        sendKeys(emailFld, email, WaitStrategy.PRESENCE, "Email ");
        return this;
    }

    public NBASignInPage enterPassword(String password){
        sendKeys(passwordFld, password, WaitStrategy.PRESENCE, "Password ");
        /*WebDriverWait wait = new WebDriverWait(DriverManger.getDriver(), Duration.ofSeconds(25));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
*/

        return this;
    }

    public NBASignInPage signIn() throws Exception {
        click(signButton, WaitStrategy.CLICKABLE, "Sign In ");
        return this;
    }

}
