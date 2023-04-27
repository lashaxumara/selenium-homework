import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwitchToTest {
    WebDriver driver;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void switchTo() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");

        WebElement field = driver.findElement(By.xpath("//*[@id='tinymce']/p"));
        field.clear();

        field.sendKeys("Here Goes");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("button[aria-label='Align center']")).click();

    }

    @Test
    public void alertButton() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();

    }
}
