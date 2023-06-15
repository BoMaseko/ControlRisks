package com.bongz.tests;

import com.bongz.driver.DriverManger;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

public final class LoginpageTests extends BaseTest{

    private LoginpageTests(){

    }

    @Test
    public void test1(){

        DriverManger.getDriver().findElement(By.name("q")).sendKeys("Arsenal", Keys.ENTER);
    }

    @Test
    public void test3(){
        DriverManger.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
        String title = DriverManger.getDriver().getTitle();
        Assert.assertTrue(Objects.nonNull(title), "Title is null");
        Assert.assertTrue(title.toLowerCase().contains("google search"));
        Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"google search"));
        Assert.assertTrue(title.length()>15);
        Assert.assertTrue(title.length()<100);
        List<WebElement> elements = DriverManger.getDriver().findElements(By.xpath("//h3/span"));
        //Assert.assertEquals(elements.size(), 10);

        boolean isElementPresent = false;
        for(WebElement element : elements){
            if(element.getText().equalsIgnoreCase("Testing mini bytes - Youtube")){
                isElementPresent = true;
                break;
            }
        }
        Assert.assertTrue(isElementPresent, "Testing mini bytes - Youtube");
    }

    @Test
    public void test4(){
        DriverManger.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);
        String title = DriverManger.getDriver().getTitle();

        Assertions.assertThat(title)
                .as("Object is actually null").isNotNull()
                .containsIgnoringCase("google search")
                // .matches("\\w.*"+"google search")
                .hasSizeBetween(15, 100);

        List<WebElement> elements = DriverManger.getDriver().findElements(By.xpath("//h3/span"));

        Assertions.assertThat(elements)
                .hasSize(0)
                .extracting(e->e.getText())
                .contains("Testing mini bytes - Youtube");
    }

}
