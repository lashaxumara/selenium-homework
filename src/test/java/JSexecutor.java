import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSexecutor {
    WebDriver driver;
    Actions action;
    JavascriptExecutor js;

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    @AfterMethod
    public void finish() {
        driver.quit();
    }

    @Test
    public void practiceIsMagic() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        WebElement magicHover = driver.findElement(By.xpath("//li[contains(text(),'Practice magic')]"));
        action.moveToElement(magicHover).perform();

        WebElement delButton = driver.findElement(By.xpath("//i[@class='fa fa-trash']"));
        js.executeScript("$(arguments[0]).click();", delButton);
    }

    @Test
    public void deMoQaWeb() {
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");

        WebElement entrieOne = driver.findElement(By.id("zone2-entries"));
        js.executeScript("arguments[0].scrollIntoView();", entrieOne);

        String text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;",entrieOne);
        Assert.assertEquals(text, "0 Entries");
    }


}
