import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstDemoTest {
    static WebDriver driver = null;
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
//        driver.manage().window().maximize();
        WebElement  userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        userName.sendKeys("standard_user");
        WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        pass.sendKeys("secret_sauce");
        WebElement button_search = driver.findElement(By.xpath("//input[@id='login-button']"));
        button_search.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}

