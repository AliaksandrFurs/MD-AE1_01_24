package utils.browserconfiguration;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeConfiguration {

    private  ChromeOptions options = new ChromeOptions();

    private ChromeConfiguration(){

        options.setHeadless(false);
    }




}
