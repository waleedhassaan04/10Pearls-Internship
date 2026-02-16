package myTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemPage extends BasePage {
    List<WebElement> resultItems;
    By brand, min_range,max_range,apply_button,result_counter,shipping_price;

    public ItemPage(WebDriver driver) {
        super(driver);
        this.brand=By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[4]/div[2]/div/div[1]/label[2]/span[1]");
        this.min_range=By.xpath("//*[@id=\'root\']/div/div[3]/div/div/div[2]/div/div[6]/div[2]/div/input[1]");
        this.max_range=By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[6]/div[2]/div/input[2]");
        this.apply_button=By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div/div[6]/div[2]/div/button");
        this.result_counter=By.className("image--Smuib");
        this.shipping_price=By.xpath("//*[@id=\"module_seller_delivery\"]/div/div/div[3]/div/div[1]/div/div/div[2]");
    }

    public void BrandFilter(){
        driver.findElement(brand).click();
    }

    public void PriceFilter(){
        driver.findElement(min_range).sendKeys("500");
        driver.findElement(max_range).sendKeys("5000");
        driver.findElement(apply_button).click();
    }

    public int count(){
        this.resultItems = driver.findElements(result_counter);
        int resultsCount = resultItems.size();
        System.out.println("Number of results: " + resultsCount);
        return resultsCount;
    }

    public void SelectItem(){
        resultItems.getFirst().click();
    }

    public String getUrl(){
       return driver.getCurrentUrl();
    }

    public String ShippingPrice(){
      String shippingprice=  driver.findElement(shipping_price).getText();
      return shippingprice;
    }
}
