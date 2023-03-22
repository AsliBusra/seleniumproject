package com.cydeo.tests.day5_testNg_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropdowns {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropdownTest() {

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        WebElement currentSelectedOption = simpleDropdown.getFirstSelectedOption();

        String actualSimpleDropdownText = currentSelectedOption.getText();

        String expectedSimpleDropdwnText = "Please select an option";

        Assert.assertEquals(actualSimpleDropdownText, expectedSimpleDropdwnText);



        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String expectedStateDropdownText="Select a State";

        String actualStateDropdownText=stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualStateDropdownText,expectedStateDropdownText);

        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(),"Select a State");


    }
}
