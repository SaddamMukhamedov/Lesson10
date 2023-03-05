package net.absoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class InventoryPage extends BaseStorePage {
    private final String ItemXPath = "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text() = '%s']]";

    public InventoryPage(WebDriver driver) {
        super(driver);
    }



@Step("Adding item {itemName} to cart")
    public InventoryPage addItemToCart(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(ItemXPath, itemName)));

        WebElement addToCartButton = item.findElement(By.xpath("//button[contains(@data-test, 'add-to-cart')]"));
        addToCartButton.click();
        return this;
    }
@Step("Remove item {itemName} from cart")
    public InventoryPage removeItemFromCart (String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(ItemXPath, itemName)));
        WebElement removeFromCart = item.findElement(By.xpath("//button[contains(@data-test, 'remove')]"));
        removeFromCart.click();
        return this;
    }
@Step("Check that items are sorted in descending order by price after clicking on the sorting button")
    public void checkSortingHiLo () {
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);
        select.selectByValue("hilo");


        List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        List<Double> originalPrices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            originalPrices.add(Double.parseDouble(priceElement.getText().replace("$", "")));
        }

        List<Double> sortedPrices = new ArrayList<>(originalPrices);

        Collections.sort(sortedPrices, Collections.reverseOrder());

        assertEquals(sortedPrices, originalPrices, "Items are sorted wrong");

    }
    @Step("Check that items are sorted in ascending order by price after clicking on the sorting button")
    public void checkSortingLoHi () {
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);
        select.selectByValue("lohi");


        List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> originalPrices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {
            originalPrices.add(Double.parseDouble(priceElement.getText().replace("$", "")));
        }

        List<Double> sortedPrices = new ArrayList<>(originalPrices);
        Collections.sort(sortedPrices);

        assertEquals(sortedPrices, originalPrices, "Items are sorted wrong");

    }

    @Step ("Check that items are sorted in ascending order by name after clicking on the sorting button ")
    public void checkSorting_FromA_To_Z () {
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);
        select.selectByValue("az");

        List<WebElement> nameElements = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> elementsNameBeforeSorting = new ArrayList<>();


        for (WebElement nameElement : nameElements) {
            elementsNameBeforeSorting.add(nameElement.getText());
        }

        List<String> elementsNameAfterSorting = new ArrayList<>(elementsNameBeforeSorting);
        Collections.sort(elementsNameAfterSorting);
        assertEquals(elementsNameBeforeSorting, elementsNameAfterSorting, "Elements are sorted wrong");

    }
@Step ("Check that items are sorted in descending order by name after clicking on the sorting button ")
    public void checkSorting_From_Z_To_A () {
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);
        select.selectByValue("za");

        List<WebElement> nameElements = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> elementsNameBeforeSorting = new ArrayList<>();


        for (WebElement nameElement : nameElements) {
            elementsNameBeforeSorting.add(nameElement.getText());
        }

        List<String> elementsNameAfterSorting = new ArrayList<>(elementsNameBeforeSorting);
        Collections.sort(elementsNameAfterSorting, Collections.reverseOrder());
        assertEquals(elementsNameBeforeSorting, elementsNameAfterSorting, "Elements are sorted wrong");

    }

}
