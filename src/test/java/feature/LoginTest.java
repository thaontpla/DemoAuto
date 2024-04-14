package feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Thiết lập WebDriver (trình duyệt Chrome)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        // Mở trang web
        driver.get("https://www.saucedemo.com/");

        // Nhập thông tin đăng nhập
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        // Click vào nút đăng nhập
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Kiểm tra xem đăng nhập thành công hay không bằng cách kiểm tra URL mới
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
    }

    @AfterClass
    public void tearDown() {
        // Đóng trình duyệt
        driver.quit();
    }
}
