package portfolio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class demoQa {

    private WebDriver driver;


    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

    }

    @Test
    public void checkAlerts() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(250));
        SoftAssertions softAssert = new SoftAssertions();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.submit();
        WebElement userForm = driver.findElement(By.id("userForm"));
        Assertions.assertEquals("was-validated", userForm.getAttribute("class"));

        String fName = "Evgeny";
        String lName = "Yaroslavtsev";
        String eMail = "ye@ya.ru";
        String number = "1234567890As&ы";
        String validNumber = "1234567890";
        String date = "24 Dec 1991";
        String currentAddress = "Russia, Novosibirsk city";
        String nameStudent = "Student Name";
        String emailStudent = "Student Email";
        String gender = "Gender";
        String genderValue = "Male";
        String mobile = "Mobile";
        String dateBirth = "Date of Birth";
        String subjects = "Subjects";
        String textToSelectMaths = "Maths";
        String textToSelectChemistry = "Chemistry";
        String hobbies = "Hobbies";
        String hobbiesSports = "Sports";
        String filePath = "C:\\Users\\Admin\\Downloads\\photo_2024-03-21_19-24-07.jpg";
        String pictureName = "photo_2024-03-21_19-24-07.jpg";
        String picture = "Picture";
        String address = "Address";
        String stateAndCity = "State and City";

        driver.findElement(By.cssSelector("[placeholder='First Name']")).sendKeys(fName);

        driver.findElement(By.cssSelector("[placeholder='Last Name']")).sendKeys(lName);

        driver.findElement(By.cssSelector("[placeholder='name@example.com']")).sendKeys(eMail);

        WebElement genderCheckBox = driver.findElement(By.id("gender-radio-1"));
        actions.moveToElement(genderCheckBox).click().build().perform();
        Assertions.assertEquals("true", genderCheckBox.getAttribute("checked"));

        driver.findElement(By.id("userNumber")).sendKeys(number);

//        driver.findElement(By.id("dateOfBirthInput")).clear();
//        driver.findElement(By.id("dateOfBirthInput")).sendKeys(date);

        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys(textToSelectMaths);
        List<WebElement> optionsToSelectMaths = driver.findElements(By.cssSelector(".subjects-auto-complete__menu"));
        for (WebElement option : optionsToSelectMaths) {
            System.out.println(option);
            if (option.getText().equals(textToSelectMaths)) {
                System.out.println("Trying to select: " + textToSelectMaths);
                option.click();
                break;
            }
        }

        subjectsInput.sendKeys(textToSelectChemistry);
        List<WebElement> optionsToSelect = driver.findElements(By.cssSelector(".subjects-auto-complete__menu"));
        for (WebElement option : optionsToSelect) {
            System.out.println(option);
            if (option.getText().equals(textToSelectChemistry)) {
                System.out.println("Trying to select: " + textToSelectChemistry);
                option.click();
                break;
            }
        }

        WebElement hobbiesCheckbox1 = driver.findElement(By.id("hobbies-checkbox-1"));
        actions.moveToElement(hobbiesCheckbox1).click().build().perform();

        driver.findElement(By.id("uploadPicture")).sendKeys(filePath);

        driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
        submitBtn.submit();
        Thread.sleep(3000);

        WebElement row1Label = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(1) > td:first-child"));
        softAssert.assertThat(row1Label.getText()).isEqualTo(nameStudent);

        WebElement row2Label = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(2) > td:first-child"));
        softAssert.assertThat(row2Label.getText()).isEqualTo(emailStudent);

        WebElement row3Label = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(3) > td:first-child"));
        softAssert.assertThat(row3Label.getText()).isEqualTo(gender);

        WebElement row4Label = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(4) > td:first-child"));
        softAssert.assertThat(row4Label.getText()).isEqualTo(mobile);

        WebElement row5Label = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(5) > td:first-child"));
        softAssert.assertThat(row5Label.getText()).isEqualTo(dateBirth);

        WebElement row6Label = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(6) > td:first-child"));
        softAssert.assertThat(row6Label.getText()).isEqualTo(subjects);

        WebElement row7Label = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(7) > td:first-child"));
        softAssert.assertThat(row7Label.getText()).isEqualTo(hobbies);

        WebElement row8Label = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(8) > td:first-child"));
        softAssert.assertThat(row8Label.getText()).isEqualTo(picture);

        WebElement row9Label = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(9) > td:first-child"));
        softAssert.assertThat(row9Label.getText()).isEqualTo(address);

        WebElement row10Label = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(10) > td:first-child"));
        softAssert.assertThat(row10Label.getText()).isEqualTo(stateAndCity);


        WebElement row1Value = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(1) > td:last-child"));
        softAssert.assertThat(row1Value.getText()).isEqualTo(fName + " " + lName);

        WebElement row2Value = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(2) > td:last-child"));
        softAssert.assertThat(row2Value.getText()).isEqualTo(eMail);

        WebElement row3Value = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(3) > td:last-child"));
        softAssert.assertThat(row3Value.getText()).isEqualTo(genderValue);

        WebElement row4Value = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(4) > td:last-child"));
        softAssert.assertThat(row4Value.getText()).isEqualTo(validNumber);

//        WebElement row5Value = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(5) > td:last-child"));
//        softAssert.assertThat(row5Value.getText()).isEqualTo(date);

        WebElement row6Value = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(6) > td:last-child"));
        softAssert.assertThat(row6Value.getText()).isEqualTo(textToSelectMaths + ", " + textToSelectChemistry);

        WebElement row7Value = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(7) > td:last-child"));
        softAssert.assertThat(row7Value.getText()).isEqualTo(hobbiesSports);

        WebElement row8Value = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(8) > td:last-child"));
        softAssert.assertThat(row8Value.getText()).isEqualTo(pictureName);

        WebElement row9Value = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(9) > td:last-child"));
        softAssert.assertThat(row9Value.getText()).isEqualTo(currentAddress);

        softAssert.assertAll();
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
