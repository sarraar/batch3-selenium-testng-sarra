package com.eurotech.tests.day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;

public class FilePathExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        // Aşağıdaki satır Selenium 4 versiyonu içindir.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Aşağıdaki satır Selenium 3 versiyonu içindir.
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void fileUpload() throws InterruptedException {
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        //  C:\Users\Sarra\IdeaProjects\batch3-selenium-testng
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/euroTech.txt";
        String fullPath = projectPath + "/" + filePath;
        System.out.println("fullPath = " + fullPath);
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.name("file"));
       // chooseFile.sendKeys("C:\\Users\\Sarra\\IdeaProjects\\batch3-selenium-testng\\src\\test\\resources\\euroTech.txt");
        chooseFile.sendKeys(fullPath);
        Thread.sleep(5000);
        driver.findElement(By.id("file-submit")).click();
        String actualText = driver.findElement(By.tagName("h3")).getText();
        System.out.println("actualText = " + actualText);
        Thread.sleep(5000);
       // C:\Users\Sarra\IdeaProjects\batch3-selenium-testng\src\test\resources\euroTech.txt
    }

    @Test
    public void test1() {
        System.out.println("System.getenv(\"Path\") = " + System.getenv("Path"));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
