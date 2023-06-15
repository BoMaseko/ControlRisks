package com.bongz.pages;

import com.bongz.driver.DriverManger;
import com.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class NBAHomePage extends BasePage{

    public NBAHomePage(){}

    private final By signInLink = By.cssSelector("div[id='nav-controls'] span[class='NavItem_text__JoCLX']");
    private final By signInWithNBAId = By.cssSelector(".Anchor_anchor__cSc3P.NavDropdownChild_link__NSYfR[href='/account/sign-in']");

    Actions action = new Actions(DriverManger.getDriver());


    public NBASignInPage signIn() throws Exception {
        action.moveToElement(DriverManger.getDriver().findElement(signInLink)).perform();
        click(signInWithNBAId, WaitStrategy.VISIBLE, "Sign In");
        return new NBASignInPage();
    }
}
