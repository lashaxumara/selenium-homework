import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebFormsTest {
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
    public void startTest() {
        //dropDown
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement dropDownEl = driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']/option[3]"));
        Select dropDown = new Select(driver.findElement(By.id("dropdowm-menu-1")));
        dropDown.selectByIndex(2);
//        dropDown.selectByVisibleText("Python");
//        dropDown.selectByValue("python");
        if (dropDownEl.isSelected() == true) {
            System.out.println("Python is selected");
        } else {
            System.out.println("Python is not selected");
        }

        //checkBoxes
        List<WebElement> checkBox = driver.findElements(By.xpath("//div[@id='checkboxes']//input[@type='checkbox']"));
        for (WebElement box : checkBox) {
            if (box.isSelected()) {
                System.out.println("Box is already selected");
            } else {
                box.click();
                System.out.println("Selecting empty boxes");
            }
        }
        //radioButtons
        List<WebElement> radioButton = driver.findElements(By.cssSelector("input[type='radio'][name='color']"));
        for (WebElement radioButtonEl : radioButton) {
            if (radioButtonEl.getAttribute("value").equalsIgnoreCase("Yellow")) {
                radioButtonEl.click();
                System.out.println("Found yellow and clicked");
                break;
            } else {
                System.out.println("Could not find yellow yet");
            }
        }
        //dropDown
//        List<WebElement> dropDownCheck = driver.findElements(By.xpath("//select[@id='fruit-selects']/option"));
//        for (WebElement dropCheck : dropDownCheck) {
//            if (dropCheck.isEnabled()) {
//                System.out.println("Those are enabled");
//            } else {
//                System.out.println("Orange is diasabled");
//                break;
//            }

            WebElement orangeCheck = driver.findElement(By.xpath("//select[@id='fruit-selects']/option[2]"));
            if (orangeCheck.isEnabled()){
                System.out.println("Orange is enabled");
            }else {
                System.out.println("Orange is diasabled");
            }
        }
    }



