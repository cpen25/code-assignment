package com.securepay.assignment.service;

import com.securepay.assignment.model.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class DataServiceTest {

    private DataServiceImpl dataService;

    @Before
    public void initTest() {
        dataService = new DataServiceImpl();
    }

    @Test
    public void shouldCreateRandomIntCorrectly() {
        int test = dataService.generateIntRandom(1, 100);
        Assertions.assertTrue(1 <= test && test <= 100);

        int test1 = dataService.generateIntRandom(1, 1);
        Assertions.assertEquals(1, test1);
    }

    @Test
    public void shouldInitCategoriesCorrectly() {
        dataService.generateCategories(2);
        Assertions.assertEquals(2, dataService.getAllCategories().size());
        Assertions.assertEquals("Category1", dataService.getAllCategories().get(0).getCategoryName());
        Assertions.assertEquals("Category2", dataService.getAllCategories().get(1).getCategoryName());
    }

    @Test
    public void shouldInitItemsForCategoryCorrectly() {
        dataService.generateCategories(2);
        dataService.generateItemsAllCategories(2);
        Assertions.assertEquals("Item1", dataService.getAllCategories().get(0).getItemList().get(0).getItemName());
        Assertions.assertEquals("Item2", dataService.getAllCategories().get(0).getItemList().get(1).getItemName());

        Assertions.assertEquals("Item1", dataService.getAllCategories().get(1).getItemList().get(0).getItemName());
        Assertions.assertEquals("Item2", dataService.getAllCategories().get(1).getItemList().get(1).getItemName());
    }

    @Test
    public void shouldSortItemsInCategoryCorrectly() {
        dataService.generateCategories(1);
        dataService.generateItemsAllCategories(5);
        dataService.sortEachCategory();

        Category category = dataService.getAllCategories().get(0);

        for (int i = 0; i < 4; i++) {
            Assertions.assertTrue(
                    (category.getItemList().get(i).getPrice()
                            + category.getItemList().get(i).getShippingCost())
                            <= (category.getItemList().get(i + 1).getPrice()
                            + category.getItemList().get(i + 1).getShippingCost()));
        }
    }

    @Test
    public void shouldSortCategoriesByEachBestItemCorrectly() {
        dataService.generateCategories(5);
        dataService.generateItemsAllCategories(5);
        dataService.sortEachCategory();
        dataService.sortCategoriesByBestItems();

        List<Category> categories = dataService.getAllCategories();

        for (int i = 0; i < 4; i++) {
            Assertions.assertTrue((categories.get(i).getItemList().get(0).getPrice()
                    + categories.get(i).getItemList().get(0).getShippingCost())
                    <= (categories.get(i + 1).getItemList().get(0).getPrice()
                    + categories.get(i + 1).getItemList().get(0).getShippingCost()));
        }
    }

}