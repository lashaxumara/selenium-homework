import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsTest {
    WebDriver driver;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void waitsTest() {
        //Explicit wait
        Duration duration = Duration.ofSeconds(15);
        WebDriverWait wait = new WebDriverWait(driver,duration);

        driver.get("https://demoqa.com/progress-bar");
        WebElement startButton = driver.findElement(By.id("startStopButton"));
        startButton.click();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='progressbar' and @aria-valuenow='100']")));
        System.out.println(element.getText());
    }
}
