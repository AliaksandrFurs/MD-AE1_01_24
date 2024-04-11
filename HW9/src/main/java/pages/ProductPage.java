package pages;

import elements.BasicCheckboxs;
import elements.HeaderBar;
import enums.ItemBarEnum;
import enums.ProducentEnum;
import enums.ProductPageCheckboxTypeEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Wait;
import utilsfactory.ProductPageCheckboxFactory;

public class ProductPage extends BasicPage {

    public ProductPage(WebDriver driver){

        super(driver);
        allCheckboxes = ProductPageCheckboxFactory.getAllPageCheckboxes(driver);
    }

    private static final By FORMHEADER = By.xpath("h1[@class = 'catalog-form__title catalog-form__title_big-alter']");
    private static final By RESULTFILTER = By.className("catalog-form__filter-part catalog-form__filter-part_2");
    private static final By RESULTELEMENT = By.className("catalog-form__link catalog-form__link_primary-additional " +
            "catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor");

    @Override
    public void openPage(ItemBarEnum itembar) {
        itemBar.clickOnItem(itembar);
    }

    @Override
    public boolean isOpened() {

        Wait.isElementPresented(driver, FORMHEADER);
        Wait.isElementPresented(driver, HeaderBar.getTOPELEMENT());
        Wait.isElementClickable(driver, HeaderBar.getHEADERLOGO());

        return driver.findElements(FORMHEADER).size() > 0 && driver.findElements(HeaderBar.getTOPELEMENT()).size() > 0;
    }

    @Override
    public void selectCheckbox(ProductPageCheckboxTypeEnum checkboxType, ProducentEnum producent) {
        // verificate type - TBD
        BasicCheckboxs checkbox = allCheckboxes.get(checkboxType);
        checkbox.selectCheckbox(producent);
    }


    public static By getRESULTFILTER() {
        return RESULTFILTER;
    }

    public static By getRESULTELEMENT() {
        return RESULTELEMENT;
    }
}
