package com.cydeo.tests.day5_testNg_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementsRefEx {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/add_remove_elements/");
        WebElement addElementBtn=driver.findElement(By.xpath("//button[.='Add Element']"));

        Thread.sleep(2000);
        addElementBtn.click();

        WebElement deletetBtn=driver.findElement(By.xpath("//button[@class='added-manually']"));

        System.out.println("deletetBtn.isDisplayed() = " + deletetBtn.isDisplayed());

        Thread.sleep(2000);
        deletetBtn.click();

        try {
            System.out.println("deletetBtn.isDisplayed() = " + deletetBtn.isDisplayed());

        }catch (StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException exception is thrown");
            System.out.println("deletetBtn.isDisplayed() = false");
        }

        driver.close();


    }
}
