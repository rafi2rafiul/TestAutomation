package BR;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Random;


public class Tc1 {
    public static WebDriver driver;

    protected static String getSaltString() {
        String SALTCHARS = "abcdefghijklmnopurstuvwxyz1234567890_-";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    @Test
    public void tC1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        driver.manage().window().maximize();

        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.id("email_create")).sendKeys(getSaltString()+"@gmail.com");

        driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
        Thread.sleep(5000);


        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("john");
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("smith");
        driver.findElement(By.cssSelector("#passwd")).sendKeys("123456");
        driver.findElement(By.id("days")).click();

        {
            WebElement dropdown = driver.findElement(By.cssSelector("#days"));
            Select dp=new Select(dropdown);
            dp.selectByValue("2");
        }

        driver.findElement(By.id("months")).click();

        {
            WebElement dropdown = driver.findElement(By.id("months"));
            Select dp=new Select(dropdown);
            dp.selectByValue("4");
        }

        driver.findElement(By.id("years")).click();

        {
            WebElement dropdown = driver.findElement(By.id("years"));
            Select dp=new Select(dropdown);
            dp.selectByValue("2010");
        }

        driver.findElement(By.id("company")).sendKeys("QA");
        driver.findElement(By.cssSelector("#address1")).sendKeys("Dhaka");
        driver.findElement(By.id("city")).sendKeys("Dhaka");
        {
            WebElement dropdown = driver.findElement(By.id("id_state"));
            dropdown.findElement(By.xpath("//option[. = 'Indiana']")).click();
        }
        driver.findElement(By.id("postcode")).sendKeys("00000");
        driver.findElement(By.id("phone")).sendKeys("1234697451");
        driver.findElement(By.cssSelector("#submitAccount > span")).click();
        Thread.sleep(3000);


        driver.findElement(By.linkText("DRESSES")).click();

        driver.findElement(By.linkText("Casual Dresses")).click();

        WebElement element = driver.findElement(By.cssSelector("body.category.category-9.category-casual-dresses.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-9 ul.product_list.grid.row:nth-child(4) li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line div.product-container div.left-block div.product-image-container a.product_img_link > img.replace-2x.img-responsive"));

        ((JavascriptExecutor)driver).executeScript("var mouseEvent = document.createEvent('MouseEvents');mouseEvent.initEvent('mouseover', true, true); arguments[0].dispatchEvent(mouseEvent);", element);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        driver.findElement(By.cssSelector("#category")).click();
        Thread.sleep(2000);

    }
}
