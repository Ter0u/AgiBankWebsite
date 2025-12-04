package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class BuscaPage {

    private final WebDriver driver;

    public BuscaPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By btnSearchLocator = By.xpath("//a[contains(@class,'astra-search-icon') and @role='button']");
    private final By searchInputLocator = By.id("search-field");
    private final By resultsLocator = By.xpath("//h1[contains(text(),'Resultados encontrados para: ')]");

    public WebElement getBtnSearch() {
        return driver.findElement(btnSearchLocator);
    }

    public WebElement getSearchInput() {
        return driver.findElement(searchInputLocator);
    }

    public WebElement getResults() {
        return driver.findElement(resultsLocator);
    }

}
