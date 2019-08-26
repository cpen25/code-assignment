package com.securepay.assignment.service;

import com.securepay.assignment.model.Category;

import java.util.List;

public interface DataServiceInterface {

    /**
     * generate number of categories
     * @param count
     */
    void generateCategories(int count);

    /**
     * generate number of items in each category
     * @param itemCountInEachCategory
     */
    void generateItemsAllCategories(int itemCountInEachCategory);

    /**
     * get all current categories as a list
     * @return
     */
    List<Category> getAllCategories();

    /**
     * print all initial created categories with all items in each
     */
    void printAllCategories();

    /**
     * print results for this code challenge
     */
    void printFinalResultCategories();

    /**
     * sort items in each category by cost of (price + shipping cost) from low to high
     * and by rating from high to low as second sorting criteria
     */
    void sortEachCategory();

    /**
     * sort categories by its first optimized item by cost of (price + shipping cost) from low to high
     * and by rating from high to low as second sorting criteria
     */
    void sortCategoriesByBestItems();

    /**
     * find out top number of categories with its most optimized item by total cost less than specific total cost
     */
    void findTopXResults(int sumLimit);

}
