package portfolio;

import io.github.bonigarcia.wdm.WebDriverManager;
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

import java.net.MalformedURLException;
import java.time.Duration;

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
    public void checkAlerts() throws InterruptedException, MalformedURLException {

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(250));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.submit();
        WebElement userForm = driver.findElement(By.id("userForm"));
        Assertions.assertEquals("was-validated", userForm.getAttribute("class"));

        driver.findElement(By.cssSelector("[placeholder='First Name']")).sendKeys("Evgeny");
        driver.findElement(By.cssSelector("[placeholder='Last Name']")).sendKeys("Yaroslavtsev");
        driver.findElement(By.cssSelector("[placeholder='name@example.com']")).sendKeys("ye@ya.ru");

        WebElement genderCheckBox = driver.findElement(By.id("gender-radio-1"));
        actions.moveToElement(genderCheckBox).click().build().perform();
        Assertions.assertEquals("true", genderCheckBox.getAttribute("checked"));

        driver.findElement(By.id("userNumber")).sendKeys("1234567890As&ы");

        driver.findElement(By.id("dateOfBirthInput")).clear();
        driver.findElement(By.id("dateOfBirthInput")).sendKeys("24 Dec 1991");

        driver.findElement(By.id("subjectsInput")).sendKeys("Maths");
        driver.findElement(By.id("subjectsInput")).sendKeys("Chemistry");

        WebElement hobbiesCheckbox1 = driver.findElement(By.id("hobbies-checkbox-1"));
        actions.moveToElement(hobbiesCheckbox1).click().build().perform();


        String filePath = "C:\\Users\\Admin\\Downloads\\photo_2024-03-21_19-24-07.jpg";
        driver.findElement(By.id("uploadPicture")).sendKeys(filePath);

        submitBtn.submit();
//        Assertions.assertEquals("true", hobbiesCheckbox1.getAttribute("checked"));

//        WebElement inputF = driver.findElement(By.id(“dateOfBirth”));
//
//        WebElement selectDropdown = driver.findElement(By.className(".react-datepicker__month-select"));
//        Select select = new Select(selectDropdown);
//        select.selectByVisibleText("December");

//        WebElement genderCheckBox = driver.findElement(By.cssSelector("[id='gender-radio-1']"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='gender-radio-1']")));
//        genderCheckBox.click();

//        driver.findElement(By.cssSelector("[id='gender-radio-1']")).click();


//        WebElement testingRadiobutton = driver.findElement(By.cssSelector("input[name='CourseType'][value='Testing']"));
//        testingRadiobutton.click();
//        Thread.sleep(5000);
//
//        Assertions.assertEquals("true", testingRadiobutton.getAttribute("checked"));

//        WebElement nameInput = driver.findElement(By.cssSelector("#author"));
//        nameInput.sendKeys("name");
//
        Thread.sleep(5000);
//
//        Assertions.assertEquals("name", nameInput.getAttribute("value"));
    }

//    @Test
//    public void s7ExplicitWaitTest() throws InterruptedException {
//        driver.get("https://news.s7.ru/news?id=13441");
//        driver.manage().window().maximize();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(250));
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".comments-block-wrapper")));
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        WebElement nameInput = driver.findElement(By.cssSelector("#author"));
//        nameInput.sendKeys("name");
//
//        Thread.sleep(3000);
//
//        Assertions.assertEquals("name", nameInput.getAttribute("value"));
//    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
