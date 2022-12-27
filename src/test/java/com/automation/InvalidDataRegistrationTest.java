package com.automation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class InvalidDataRegistrationTest extends BasicTestCase {
    
    private String getUrl = "https://demoqa.com/automation-practice-form";
    private By firstNameInput = By.xpath("//input[@id='firstName']");
    private By lastNameInput = By.xpath("//input[@id='lastName']");
    private By eMailInput = By.xpath("//input[@id='userEmail']");
    private By mobilePhoneInput = By.xpath("//input[@id='userNumber']");
    private By submitConfirmation = By.xpath("//div[text()='Thanks for submitting the form']");
    private By addressInput = By.xpath("//textarea[@id='currentAddress']");
    private By submitButton = By.xpath("//button[text()='Submit']");

@Test
    public void invalidCompulsoryFieldsFillInForm() {

        driver.get(getUrl);

        driver.findElement(firstNameInput).sendKeys("1%!:()<>&", Keys.ENTER);
        driver.findElement(lastNameInput).sendKeys("1%!:()<>&", Keys.ENTER);
        driver.findElement(eMailInput).sendKeys("@name</.", Keys.ENTER);
        driver.findElement(mobilePhoneInput).sendKeys("123456789", Keys.ENTER);
        driver.findElement(addressInput).sendKeys("?", Keys.ENTER);

        WebElement genderInput = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        Actions genderAction = new Actions(driver);
        genderAction.moveToElement(genderInput).click().perform();

        driver.findElement(submitButton).submit();

    try {
        Assert.assertEquals("Thanks for submitting the form", driver.findElement(submitConfirmation).getText());

    } catch (NoSuchElementException e) {
        e.printStackTrace();
        }

    }

    @Test
    public void invalidNamesFieldsFillInForm() {

        driver.get(getUrl);

        driver.findElement(firstNameInput).sendKeys("1%!:()<>&", Keys.ENTER);
        driver.findElement(lastNameInput).sendKeys("1%!:()<>&", Keys.ENTER);
        driver.findElement(eMailInput).sendKeys("name@example.com", Keys.ENTER);
        driver.findElement(mobilePhoneInput).sendKeys("1234567890", Keys.ENTER);
        driver.findElement(addressInput).sendKeys("3 Store, 311-318 High Holborn, London, WC1V 7BN", Keys.ENTER);

        WebElement genderInput = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        Actions genderAction = new Actions(driver);
        genderAction.moveToElement(genderInput).click().perform();

        driver.findElement(submitButton).submit();

        try {
            Assert.assertEquals("Thanks for submitting the form", driver.findElement(submitConfirmation).getText());
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }
}


