package pages;

import elements.BasicCheckboxs;
import elements.ProducentCheckboxes;
import enums.BarTypeEnum;
import enums.main.MainPageTopBarEnum;
import enums.product.ProductPageProducentEnum;
import enums.ProductPageCheckboxTypeEnum;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.ElementActions;
import pages.interfaces.ProductPageActions;
import utils.Wait;

import java.util.HashMap;

public class ProductPage extends BasicPage implements ElementActions, ProductPageActions {

    protected HashMap<ProductPageCheckboxTypeEnum, BasicCheckboxs> productPageCheckboxes = new HashMap<>();

    public ProductPage(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
        productPageCheckboxes.put(ProductPageCheckboxTypeEnum.PRODUCENT, new ProducentCheckboxes(driver));
    }

    @FindBy(xpath = "h1[@class = 'catalog-form__title catalog-form__title_big-alter']")
    private WebElement formHeader;

    @FindBy(className = "catalog-form__filter-part catalog-form__filter-part_2")
    private WebElement resultFilter;

    @FindBy(className = "catalog-form__link catalog-form__link_primary-additional " +
            "catalog-form__link_base-additional catalog-form__link_font-weight_semibold catalog-form__link_nodecor")
    private WebElement resultElement;

    @Override
    public void openPage(BarTypeEnum enumType, MainPageTopBarEnum pageName) {

        try {
            switch(enumType){
                case HEADERBARPRODUCTNAVIGATION -> mainPageProductNavigationBar.clickOnBar(pageName);
            }
        }catch(NoSuchElementException e){
            System.out.println("No such element");
        }

    }

    @Override
    public void isOpened() {

        Wait.isElementPresented(formHeader);
        Wait.isElementPresented(mainPageTopBarNavigationBar.getTopElement());
        Wait.isElementClickable(mainPageTopBarNavigationBar.getHeaderLogo());

    }

    @Override
    public void selectCheckbox(ProductPageCheckboxTypeEnum checkboxType, ProductPageProducentEnum producent) {

        // verificate type - TBD
        BasicCheckboxs checkbox = productPageCheckboxes.get(checkboxType);
        checkbox.selectCheckbox(producent);
        Wait.isElementPresented(resultFilter);

    }

    @Override
    public void goToMain() {

        mainPageTopBarNavigationBar.getHeaderLogo().click();
        Wait.isElementClickable(mainPageTopBarNavigationBar.getHeaderLogo());
    }

    @Override
    public void skipConsents() {
        if(driver.findElements(consentElement).size() == 1){
            driver.findElement(acceptButton).click();
        }
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
