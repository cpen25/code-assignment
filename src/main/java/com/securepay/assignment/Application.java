package com.securepay.assignment;

import com.securepay.assignment.service.DataServiceImpl;
import com.securepay.assignment.service.DataServiceInterface;
import com.securepay.assignment.util.Constant;

public class Application {

    public static void main(String[] args) {

        System.out.println("Securepay Code challenge - Basket algorithm");

        DataServiceInterface dataGenService = new DataServiceImpl();

        //generate given number of categories
        dataGenService.generateCategories(Constant.COUNT_OF_CATEGORY);

        //generate given number of items in each category
        dataGenService.generateItemsAllCategories(Constant.COUNT_OF_ITEMS_IN_CATEGORY);

        //print out initial categories and all items.
        dataGenService.printAllCategories();


        //sort items in each category by cost of (price + shipping cost) from low to high
        //and by rating from high to low as second sorting criteria
        dataGenService.sortEachCategory();

        //sort categories by its first optimized item by cost of (price + shipping cost) from low to high
        //and by rating from high to low as second sorting criteria
        dataGenService.sortCategoriesByBestItems();

        //find TOP X as combination in which cost is less than 50
        dataGenService.findTopXResults(Constant.PRICE_SUM_LIMITATION);

        //print out final results
        //1. selected category and corresponding selected item from it
        //2. total cost of the basket items
        //3. sum of rating of all selected items
        dataGenService.printFinalResultCategories();

    }

}
