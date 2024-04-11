package utilsfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFactory {

    private static ThreadLocal<WebDriverWait> webDriverWait;

    private WaitFactory(){}

    public static WebDriverWait getWait(WebDriver driver, long timeout){

        if(webDriverWait == null){

            webDriverWait = new ThreadLocal<>();
            webDriverWait.set(new WebDriverWait(driver, 10));
        }
        return webDriverWait.get();
    }
}
