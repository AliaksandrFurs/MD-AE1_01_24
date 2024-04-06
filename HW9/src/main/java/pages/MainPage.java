package pages;

import driverfactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasicPage {

    //WebDriver driver = DriverFactory.getChromeDriver();

    By navigationBar = By.className("project-navigation__part project-navigation__part_1");
    By tvSection = By.xpath("//a[@href='https://catalog.onliner.by/tv']");

    private MainPage(){};

    public static MainPage getMainPage(){
        return new MainPage();
    };

    public By getNavigationBar() {
        return navigationBar;
    }

    public By getTvSection() {
        return tvSection;
    }
}
