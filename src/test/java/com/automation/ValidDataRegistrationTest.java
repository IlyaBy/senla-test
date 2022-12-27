package com.automation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ValidDataRegistrationTest extends BasicTestCase {

    private String getUrl = "https://demoqa.com/automation-practice-form";
    private By firstNameInput = By.xpath("//input[@id='firstName']");
    private By lastNameInput = By.xpath("//input[@id='lastName']");
    private By eMailInput = By.xpath("//input[@id='userEmail']");
    private By mobilePhoneInput = By.xpath("//input[@id='userNumber']");
    private By subjectInput = By.xpath("//input[@id='subjectsInput']");
    private By submitConfirmation = By.xpath("//div[text()='Thanks for submitting the form']");
    private By addressInput = By.xpath("//textarea[@id='currentAddress']");
    private By submitButton = By.xpath("//button[text()='Submit']");

@Test
    public void compulsoryFieldsFillInForm() {

        driver.get(getUrl);

        driver.findElement(firstNameInput).sendKeys("Lu-", Keys.ENTER);
        driver.findElement(lastNameInput).sendKeys("Kang", Keys.ENTER);
        driver.findElement(eMailInput).sendKeys("name@example.com", Keys.ENTER);
        driver.findElement(mobilePhoneInput).sendKeys("1234567890", Keys.ENTER);
        driver.findElement(subjectInput).sendKeys(Keys.ENTER);
        driver.findElement(addressInput).sendKeys("3 Store, 311-318 High Holborn, London, WC1V 7BN", Keys.ENTER);

        WebElement genderInput = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        Actions genderAction = new Actions(driver);
        genderAction.moveToElement(genderInput).click().perform();

        driver.findElement(submitButton).submit();

        Assert.assertEquals("Thanks for submitting the form",driver.findElement(submitConfirmation).getText());

    }

    @Test
    public void maleStudentWhoLikesSportsAndMathsIsPossibleToSubmit() {

        driver.get(getUrl);

        driver.findElement(firstNameInput).sendKeys("Lu-", Keys.ENTER);
        driver.findElement(lastNameInput).sendKeys("Kang", Keys.ENTER);
        driver.findElement(eMailInput).sendKeys("name@example.com", Keys.ENTER);
        driver.findElement(mobilePhoneInput).sendKeys("1234567890", Keys.ENTER);
        driver.findElement(subjectInput).sendKeys("Maths",Keys.ARROW_DOWN);
        driver.findElement(subjectInput).sendKeys(Keys.ENTER);
        driver.findElement(addressInput).sendKeys("3 Store, 311-318 High Holborn, London, WC1V 7BN", Keys.ENTER);

        WebElement genderInput = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        Actions genderAction = new Actions(driver);
        genderAction.moveToElement(genderInput).click().perform();

        WebElement hobbiesInput = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
        Actions hobbiesAction = new Actions(driver);
        hobbiesAction.moveToElement(hobbiesInput).click().perform();

        driver.findElement(submitButton).submit();

        Assert.assertEquals("Thanks for submitting the form",driver.findElement(submitConfirmation).getText());

    }
    @Test
    public void femaleStudentWhoLikesMusicAndEconomicsIsPossibleToSubmit() {

        driver.get(getUrl);

        driver.findElement(firstNameInput).sendKeys("Sonya-", Keys.ENTER);
        driver.findElement(lastNameInput).sendKeys("Blade", Keys.ENTER);
        driver.findElement(eMailInput).sendKeys("name@example.com", Keys.ENTER);
        driver.findElement(mobilePhoneInput).sendKeys("1234567890", Keys.ENTER);
        driver.findElement(subjectInput).sendKeys("Economics",Keys.ARROW_DOWN);
        driver.findElement(subjectInput).sendKeys(Keys.ENTER);
        driver.findElement(addressInput).sendKeys("3 Store, 311-318 High Holborn, London, WC1V 7BN", Keys.ENTER);

        WebElement genderInput = driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
        Actions genderAction = new Actions(driver);
        genderAction.moveToElement(genderInput).click().perform();

        WebElement hobbiesInput = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']"));
        Actions hobbiesAction = new Actions(driver);
        hobbiesAction.moveToElement(hobbiesInput).click().perform();

        driver.findElement(submitButton).submit();

        Assert.assertEquals("Thanks for submitting the form",driver.findElement(submitConfirmation).getText());

    }
    @Test
    public void otherStudentWhoLikesReadingAndComputerScienceIsPossibleToSubmit() {

        driver.get(getUrl);

        driver.findElement(firstNameInput).sendKeys("Conchita-", Keys.ENTER);
        driver.findElement(lastNameInput).sendKeys("Wurst", Keys.ENTER);
        driver.findElement(eMailInput).sendKeys("name@example.com", Keys.ENTER);
        driver.findElement(mobilePhoneInput).sendKeys("1234567890", Keys.ENTER);
        driver.findElement(subjectInput).sendKeys("Computer Science",Keys.ARROW_DOWN);
        driver.findElement(subjectInput).sendKeys(Keys.ENTER);
        driver.findElement(addressInput).sendKeys("3 Store, 311-318 High Holborn, London, WC1V 7BN", Keys.ENTER);

        WebElement genderInput = driver.findElement(By.xpath("//input[@id='gender-radio-3']"));
        Actions genderAction = new Actions(driver);
        genderAction.moveToElement(genderInput).click().perform();

        WebElement hobbiesInput = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']"));
        Actions hobbiesAction = new Actions(driver);
        hobbiesAction.moveToElement(hobbiesInput).click().perform();

        driver.findElement(submitButton).submit();

        Assert.assertEquals("Thanks for submitting the form",driver.findElement(submitConfirmation).getText());

    }
}
