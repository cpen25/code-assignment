package com.securepay.assignment.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class CategoryTest {
    private Category category;
    private List<Item> itemList;

    @Before
    public void initTest() {
        category = new Category("testCategory");
        itemList = new ArrayList<>();

        Item item = new Item();
        itemList.add(item);
    }

    @Test
    public void shouldCreateCategoryCorrectly() {
        Assertions.assertEquals("testCategory", category.getCategoryName());
        Assertions.assertNull(category.getItemList());
    }

    @Test
    public void shouldSetItemListCorrectly() {
        category.setItemList(itemList);
        Assertions.assertNotNull(category.getItemList());
        Assertions.assertEquals(1, category.getItemList().size());
    }

}
