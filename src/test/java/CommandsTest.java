import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CommandsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }


    @Test
    public void buttonTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        button.click();
        Thread.sleep(5000);
        WebElement field = driver.findElement(By.cssSelector("#input-example > input[type=text]"));
        System.out.println(field.isEnabled());
        boolean text = driver.findElement(By.id("message")).isDisplayed();
        System.out.println(text);
        System.out.println(button.getText());
        field.sendKeys("Bootcamp");
        field.clear();
    }

    @Test
    public void coordinateTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        Point locationA = columnA.getLocation();
        Point locationB = columnB.getLocation();
        if (locationB.y == locationA.y) {
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");
        }
    }
}

