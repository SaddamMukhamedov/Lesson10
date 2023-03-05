package net.absoft;

import io.qameta.allure.Description;
import net.absoft.data.Account;
import net.absoft.pages.InventoryPage;
import net.absoft.pages.LoginPage;
import org.testng.annotations.Test;

public class SortingTest extends BaseTest{

    @Test
    @Description("Verify that items are sorted in ascending order by price")
    public void sortingFromLowToHigh() {
        new LoginPage(driver)
                .login(Account.STANDART_USER);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkSortingLoHi();
    }

    @Test
    @Description("Verify that items are sorted in descending order by price")
    public void sortingFromHighToLow() {
        new LoginPage(driver)
                .login(Account.STANDART_USER);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkSortingHiLo();
    }



    @Test
    @Description("Verify that names are sorted in ascending order")
    public void sorting_FromA_To_Z() {
        new LoginPage(driver)
                .login(Account.STANDART_USER);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkSorting_FromA_To_Z();
    }

    @Test
    @Description("Verify that names are sorted in descending order")
    public void sorting_From_Z_To_A() {
        new LoginPage(driver)
                .login(Account.STANDART_USER);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkSorting_From_Z_To_A();
    }
}
