package Test;
import PageModels.BaseModel;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPage {
    WebDriver webDriver;
    @Test
    public void ComputerProductTest(){
        BaseModel baseModel = new BaseModel(webDriver);
        baseModel.setUp();
        Assert.assertTrue(baseModel.shouldPageSite(), "Websıte yüklenmedı");
        baseModel.setSearchTextModel("Bilgisayar");
        baseModel.nextpage();
        baseModel.clickComputerProduct();
        baseModel.clicktBasket();
        Assert.assertTrue(baseModel.clickcount()=="1","Sepettekı ürün sayısı yanlış");
        baseModel.clickBasketButton();
        baseModel.deleteProduct();
        Assert.assertEquals(baseModel.deleteMesage()=="Sepetinizde ürün bulunmamaktadır.","İlgili mesaj görüntülenmedi");

        baseModel.quitWebBrowser();

    }
}
