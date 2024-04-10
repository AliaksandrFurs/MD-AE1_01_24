package pages;

import elements.HeaderBar;
import elements.ProducentCheckboxes;
import enums.ItemBarEnum;
import enums.ProducentEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Wait;

public class ProductPage extends BasicPage {

    protected ProducentCheckboxes producentCheckboxes;

    public ProductPage(WebDriver driver){
        super(driver);
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

        Wait.isElementPresented(driver, FORMHEADER, 10);
        Wait.isElementPresented(driver, HeaderBar.getTOPELEMENT(), 10);
        Wait.isElementClickable(driver, HeaderBar.getHEADERLOGO(), 10);

        return driver.findElements(FORMHEADER).size() > 0 && driver.findElements(HeaderBar.getTOPELEMENT()).size() > 0;
    }

    @Override
    public void selectCheckbox(ProducentEnum producent) {
        producentCheckboxes.selectProducent(producent);
    }

    public static By getRESULTFILTER() {
        return RESULTFILTER;
    }

    public static By getRESULTELEMENT() {
        return RESULTELEMENT;
    }
}
