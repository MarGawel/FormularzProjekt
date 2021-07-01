package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FormPage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FormTest {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void formTest(){
        FormPage formPage = new FormPage(driver);
        formPage.setFirstName("Marcin");
        formPage.setLastName("Gaweł");
        formPage.chooseGender("Male");
        formPage.setDateOfBirth("11/30/1989");
        formPage.setAddress("Polska");
        formPage.setEmail("jakis@email.pl");
        formPage.setPassword("passord");
        formPage.setCompany("Firma");
        formPage.chooseRole("QA");
        List<String> expectationStringList = Arrays.asList("High salary", "Good teamwork");
        formPage.selectExpectation(expectationStringList);
        List<String> waysStringList = Arrays.asList("Read books", "Read tech blogs");
        formPage.selectWaysOfDevelopment(waysStringList);
        formPage.setComment("jakis długi komentarz");
        formPage.setSubmit();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
