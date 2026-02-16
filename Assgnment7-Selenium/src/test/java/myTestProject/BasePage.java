package myTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigUtils;

import java.util.Properties;

public class BasePage {
    WebDriver driver;
    By searchbar,search_button,search_header;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.searchbar = By.id("q");
        this.search_button = By.className("search-box__button--1oH7");
        this.search_header = By.xpath("//*[@id='root']/div/div[3]/div/div/div[1]/div[1]/div/div[2]/div/div/span[2]");
    }

    public void LoadPage(){
        Properties props= ConfigUtils.getProps("data");
        driver.get(props.getProperty("URL"));
    }
    public String SearchItem(){
        driver.findElement(searchbar).sendKeys("Electronics");
        driver.findElement(search_button).click();
        String Text=driver.findElement(search_header).getText();
        return Text;

    }
}
