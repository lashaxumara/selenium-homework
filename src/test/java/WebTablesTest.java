import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest {
    WebDriver driver;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void tableWork() {
        driver.get("http://techcanvass.com/Examples/webtable.html");

        WebElement table = driver.findElement(By.id("t01"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < cells.size(); j++) {
                String cellText = cells.get(j).getText();
                if (cellText.equals("Honda")) {
                    String priceText = cells.get(j + 2).getText();
                    System.out.println("The ex-showroom price of this model is: " + priceText);
                    break;
                }
            }
        }
    }
}






















