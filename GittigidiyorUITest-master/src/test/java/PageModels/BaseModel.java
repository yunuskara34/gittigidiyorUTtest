package PageModels;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseModel  {
    public BaseModel(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    WebDriver webDriver;
    By txtSearchArea = By.cssSelector(".sc-4995aq-0");
    By siteIcon = By.xpath("//a[@href='https://www.gittigidiyor.com']");
    By txtComputerProduct = By.cssSelector(".fs16");
    By next = By.xpath("//a[text()='2']");
    By basket = By.id("add-to-basket");
    By count = By.cssSelector(".basket-item-count");
    By delete = By.cssSelector("btn-delete");
    By deletmesage = By.xpath("//*[@id='empty-cart-container']/div[1]/div[1]/div/div[2]/h2");

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.gittigidiyor.com/");


    }
    public boolean shouldPageSite(){
        return webDriver.findElement(siteIcon).isEnabled();

    }
    public void setSearchTextModel(String value){
        webDriver.findElement(txtSearchArea).sendKeys(value + Keys.ENTER);
    }
    public void quitWebBrowser(){
        webDriver.quit();
    }
    public void clickComputerProduct(){
        webDriver.findElements(txtComputerProduct).get(0).click();
    }
    public  void nextpage(){
        webDriver.findElement(next).click();
   }
   public void clicktBasket(){
        webDriver.findElement(basket).click();

   }
   public String clickcount(){
        return webDriver.findElement(count).getText();

   }
    public void clickBasketButton(){
        webDriver.findElement(count).click();

    }
   public void deleteProduct(){
      webDriver.findElement(delete).click();
   }
   public String deleteMesage(){
        return webDriver.findElement(deletmesage).getText();
   }




}

