package pages;

import elements.BasicCheckboxs;
import elements.ProducentCheckboxes;
import enums.BarTypeEnum;
import enums.BarValuesEnum;
import enums.ProducentEnum;
import enums.ProductPageCheckboxTypeEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;
import utilsfactory.ProductPageCheckboxFactory;

public class ProductPage extends BasicPage implements ElementActions {

    public ProductPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
        this.allCheckboxes.put(ProductPageCheckboxTypeEnum.PRODUCENT, new ProducentCheckboxes(driver));
    }

    //private static final By FORMHEADER = By.xpath("h1[@class = 'catalog-form__title catalog-form__title_big-alter']");
    @FindBy(xpath = "h1[@class = 'catalog-form__title catalog-form__title_big-alter']")
    private WebElement formHeader;

    //private static final By RESULTFILTER = By.className("catalog-form__filter-part catalog-form__filter-part_2");
    @FindBy(className = "catalog-form__filter-part catalog-form__filter-part_2")
    private WebElement resultFilter;

    //private static final By RESULTELEMENT = By.className("catalog-form__link catalog-form__link_primary-additional " +
            //"catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor");
    @FindBy(className = "catalog-form__link catalog-form__link_primary-additional " +
            "catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor")
    private WebElement resultElement;

    @Override
    public void openPage(BarValuesEnum pageName) {

        headerBarMainNavigationValue.clickOnBar(pageName);
    }

    @Override
    public void isOpened() {

        Wait.isElementPresented(formHeader);
        Wait.isElementPresented(headerBarMainNavigationValue.getTopElement());
        Wait.isElementClickable(headerBarMainNavigationValue.getHeaderLogo());

        //return driver.findElements(FORMHEADER).size() > 0 && driver.findElements(headerBar.getTopElement()).size() > 0;
    }

    @Override
    public void selectCheckbox(ProductPageCheckboxTypeEnum checkboxType, ProducentEnum producent) {

        // verificate type - TBD
        BasicCheckboxs checkbox = allCheckboxes.get(checkboxType);
        checkbox.selectCheckbox(producent);
        Wait.isElementPresented(resultFilter);

    }

    @Override
    public void goToMain() {

        headerBarMainNavigationValue.getHeaderLogo().click();
        Wait.isElementClickable(headerBarMainNavigationValue.getHeaderLogo());
    }

    public WebElement getFormHeader() {
        return formHeader;
    }

    public WebElement getResultFilter() {
        return resultFilter;
    }

    public WebElement getResultElement() {
        return resultElement;
    }

}
