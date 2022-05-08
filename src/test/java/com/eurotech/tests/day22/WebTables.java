package com.eurotech.tests.day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.eurotech.utilities.WebDriverFactory;

import java.time.Duration;
import java.util.List;

public class WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        // Aşağıdaki satır Selenium 4 versiyonu içindir.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
    }

    @Test
    public void printTables() {
        WebElement table1= driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println("table1 = " + table1);
    }

    @Test
    public void getAllHeaders() {
        List<WebElement> allHeaders=driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));
        System.out.println("allHeaders.size() = " + allHeaders.size());
        for (WebElement header: allHeaders) {
            System.out.println("header.getText() = " + header.getText());
        }
    }

    @Test
    public void getAllRows() {
        List<WebElement> allRows=driver.findElements(By.xpath(" //table[@border='1']/tbody/tr/th"));
        System.out.println("allRows.size() = " + allRows.size());
        for (WebElement row: allRows) {
            System.out.println("row.getText() = " + row.getText());
        }

        List<WebElement> numRow=driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("numRow.size() = " + numRow.size());
        for (int i=1;i<=numRow.size(); i++) {
            WebElement row=driver.findElement(By.xpath("(//table[@border='1']/tbody/tr)["+i+"]"));
            System.out.println("row.getText() = " + row.getText());
        }
    }

    @Test
    public void getAllCellInOneRow() {


    }

    @Test
    public void secondRow() {
        List<WebElement> secondRow=driver.findElements(By.xpath("(//table[@border='1']/tbody/tr)[2]"));
        for (WebElement row: secondRow) {
            System.out.println("row.getText() = " + row.getText());
        }

    }

    @Test
    public void secondRowsecondColoum() {
        WebElement element=driver.findElement(By.xpath("((//table[@border='1']/tbody/tr)[2])/td[3]"));
        System.out.println("element.getText() = " + element.getText());
    }

    @Test
    public void printAllCellByIndex() {
        int rowNumber=getNumberOfRows();
        int columnNumber=getNumberOfColumns();
        for (int i = 1; i <=rowNumber ; i++) {
            for (int j = 1; j <=columnNumber ; j++) {
                WebElement element=driver.findElement(By.xpath("((//table[@border='1']/tbody/tr)["+i+"])/td["+j+"]"));

                System.out.print( element.getText()+" ");
            }
            System.out.println("");
        }

      //  List<WebElement> cells=driver.findElements(By.xpath("(//table[@border='1']/tbody/tr)[2]"));


    }

    private int getNumberOfColumns() {
        List<WebElement> columns=driver.findElements(By.xpath("//table[@border='1']/tbody/tr/th"));
        return columns.size();

    }

    private int getNumberOfRows() {
        List<WebElement> rows=driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
       return rows.size();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
