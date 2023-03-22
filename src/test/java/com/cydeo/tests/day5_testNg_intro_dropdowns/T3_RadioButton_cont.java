package com.cydeo.tests.day5_testNg_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton_cont {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //WebElement hockeyRadioBtn = driver.findElement(By.xpath("//input[@id='hockey']"));

        clickAndVerifyRadioButton(driver,"sport","hockey");

        clickAndVerifyRadioButton(driver,"sport","football");

        clickAndVerifyRadioButton(driver,"color","yellow");
    }

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue) {
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));

        for (WebElement each : radioButtons) {
            String eachId = each.getAttribute("id");


            if (eachId.equals(idValue)) {
                each.click();
                System.out.println(eachId + " is selected: " + each.isSelected());
                break;
            }
        }
    }
}
