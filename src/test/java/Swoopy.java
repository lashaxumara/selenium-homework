import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Swoopy {
    WebDriver driver;
    Actions action;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

//    @AfterMethod
//    public void finish() {
//        driver.quit();
//    }

    @Test
    public void swoopExercise(){
        driver.get("https://www.swoop.ge/");
        WebElement hoverButton =driver.findElement(By.xpath("//label[text()='დასვენება']"));
        action.moveToElement(hoverButton).perform();
        List<WebElement> menuOfWeekands = driver.findElements(By.xpath("//label[contains(text(),'დასვენება')]"));
        WebElement lastElement= menuOfWeekands.get(menuOfWeekands.size() - 1);
        lastElement.click();
       driver.findElement(By.cssSelector("img.special-offer-img")).click();
       driver.findElement(By.xpath("//span[text()='კალათაში დამატება']")).click();
       driver.findElement(By.id("mainBasketIcon")).click();



       String addedToBasket = driver.findElement(By.cssSelector("(img.special-offer-img")).getAccessibleName();
       String afterBasket = driver.findElement(By.id("item_1048065")).getAccessibleName();
        Assert.assertEquals(addedToBasket,afterBasket);


    }

}
