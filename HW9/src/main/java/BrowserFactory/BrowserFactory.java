package BrowserFactory;

import utils.Browser;

public class BrowserFactory {

    private static ThreadLocal<Browser> browser;

    private BrowserFactory(){};

    public static Browser getBrowser(){

        if(browser == null){
            //Browser browserInitialize = new Browser();
            browser = new ThreadLocal<>();
            browser.set(new Browser());
        }
        return browser.get();
    }
}
