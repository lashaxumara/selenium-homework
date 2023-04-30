import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AutoComplete {
    WebDriver driver;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void listOfElements(){
        driver.get("https://www.google.com/");
        WebElement textArea = driver.findElement(By.id("APjFqb"));
        textArea.sendKeys("Automation");

        List<WebElement> listOfElement = driver.findElements(By.xpath("//li[@data-view-type]//div[@id]"));
        int lastIndex = listOfElement.size() - 1;
        WebElement lastElement = listOfElement.get(lastIndex);
        System.out.println(lastElement.getText());
        lastElement.click();
    }
}
