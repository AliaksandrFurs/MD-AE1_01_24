package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Item {

    WebDriver driver;

    private final static By ITEM_NAME_PATTERN = By.className("catalog-navigation-list__dropdown-title");
    private final static By ITEM_PRICE_PATTERN = By.xpath("//span[@class='catalog-navigation-list__dropdown-description']/span");
    private final static By ITEM_QUANTITY_PATTERN = By.className("catalog-navigation-list__dropdown-description");

    public Item(WebDriver driver){
        this.driver = driver;
    }

    public String getItemName(){
        String name = driver.findElement(ITEM_NAME_PATTERN).getText();
        return name;
    }

    public String getItemPrice(){

        return  driver.findElement(ITEM_PRICE_PATTERN).getText();
    }

    public String getItemQuantity(){

        return driver.findElement(ITEM_QUANTITY_PATTERN).getText();
    }
}
