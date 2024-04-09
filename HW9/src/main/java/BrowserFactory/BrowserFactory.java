package BrowserFactory;

import utils.Browser;

public class BrowserFactory {

    private static Browser browser;

    private BrowserFactory(){};

    public static Browser getBrowser(){

        if(browser == null){
            return new Browser();
        }
        return browser;
    }
}
