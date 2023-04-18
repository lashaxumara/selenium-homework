import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void starter() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void finished() {
        driver.quit();
    }

    @Test
    public void Exercise() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i = 0; i < 3; i++) {
            addElement.click();
        }

        WebElement deleteButton = driver.findElement(By.xpath("(//button[@class='added-manually'])[last()]"));
        System.out.println("Last 'delete' button with findElement-" + deleteButton.getText() + "-");

        List<WebElement> cssButton = driver.findElements(By.cssSelector("button[class^='added']"));
        System.out.println("List of three element, printed last element-" + cssButton.get(cssButton.size()-1).getText() + "-");

        WebElement deleteButton2 = driver.findElement(By.xpath("//button[contains(@class,'manually') and contains(text(),'Delete')][last()]"));
        System.out.println("Printing last element 'button'with xpath-contains -" + deleteButton2.getText()+"-");
    }

    @Test
    public void Exercise2() {
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        WebElement lorem = driver.findElement(By.xpath("//td[text()='Apeirian9']/preceding-sibling::td"));
        System.out.println(lorem.getText());

        WebElement dolor = driver.findElement(By.xpath("//td[text()='Apeirian9']/following-sibling::td"));
        System.out.println(dolor.getText());
    }
}
