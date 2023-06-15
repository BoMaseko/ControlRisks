package com.bongz.tests;

import com.bongz.annotations.FrameworkAnnotation;
import com.bongz.enums.CategoryType;
import com.bongz.objects.SignUp;
import com.bongz.pages.NBAHomePage;
import com.bongz.pages.NBASignInPage;
import com.bongz.pages.NBASignUpPage;
import com.bongz.utilities.JacksonUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public class NBATests extends BaseTest{

    private NBATests(){}

    @FrameworkAnnotation(author = {"Bongani", "Automation"}, category = {CategoryType.REGRESSION, CategoryType.SMOKE})
    @Test
    public void nbaSignUpTest(Map<String, String> data) throws Exception {
        //SignUp signUp = JacksonUtils.genericDeserializeJson("signUp.json", SignUp.class);

        NBAHomePage nbaHomePage = new NBAHomePage();


        NBASignUpPage nbaSignUpPage = nbaHomePage.signIn().registerNewNBAId();
        String title = nbaSignUpPage.enterEmail(data.get("email"))
                        .enterPassword(data.get("password"))
                                .enterFirstName(data.get("firstname"))
                                        .enterLastName(data.get("lastname"))
                .selectBirthMonth(data.get("birthmonth"))
                        .selectBirthYear(data.get("birthyear"))
                                .selectCountry(data.get("country"))
                                        .agreeTerms()
                                                .createAccount()
                .getTitle();

        Assertions.assertThat(title).isEqualTo("NBA SignUp | NBA.com");


    }


    @FrameworkAnnotation(author = {"Bongani", "Automation"}, category = {CategoryType.REGRESSION, CategoryType.SMOKE})
    @Test
    public void nbaLoginTest(Map<String, String> data) throws Exception {


        NBAHomePage nbaHomePage = new NBAHomePage();

        String title = nbaHomePage.signIn().enterEmail(data.get("email"))
                        .enterPassword(data.get("password"))
                                .signIn().getTitle();

       Assertions.assertThat(title).isEqualTo("Sign in with your NBA ID");


    }

     /* @DataProvider(name="LoginTestDataProvider", parallel = true)
    public Object[][] getData(){

        return new String[][]{
                {"bomaseko1", "@KBTokzan2021"}
        };
    }*/
}
