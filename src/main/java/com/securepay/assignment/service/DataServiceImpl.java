package com.securepay.assignment.service;

import com.securepay.assignment.util.Constant;
import com.securepay.assignment.model.Category;
import com.securepay.assignment.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataServiceImpl implements DataServiceInterface {

    private List<Category> categories = new ArrayList<>();
    private List<Category> finalResults = new ArrayList<>();

    @Override
    public void generateCategories(int count) {
        for (int i = 1; i <= count; i++) {
            Category category = new Category("Category" + i);
            categories.add(category);
        }
    }

    @Override
    public void generateItemsAllCategories(int itemCountInEachCategory) {
        categories.forEach(it -> {

            List<Item> items = new ArrayList<>();

            for (int i = 1; i <= itemCountInEachCategory; i++) {
                Item item = new Item();
                item.setItemName("Item" + i);
                item.setPrice(generateIntRandom(1, 20));
                item.setShippingCost(generateIntRandom(2, 5));
                item.setRating(generateIntRandom(1, 5));
                items.add(item);
            }

            it.setItemList(items);

        });
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public int generateIntRandom(int a, int b) {
        return a + (int) (new Random().nextFloat() * (b - a));
    }

    @Override
    public void printAllCategories() {
        categories.forEach(it -> {
            System.out.println(it.getCategoryName());

            it.getItemList().forEach(item ->
                    System.out.println("Item" + (it.getItemList().indexOf(item)+1) + ": " + "Price " + item.getPrice() + ", "
                            + "Shipping Cost " + item.getShippingCost() + ", "
                            + "Rating " + item.getRating() + "; "));
        });
    }

    @Override
    public void printFinalResultCategories() {

        System.out.println("\n" + "Basket should be like: ");

        finalResults.forEach(it -> {
            System.out.println(it.getCategoryName() + " - "
                    + it.getItemList().get(0).getItemName()
                    + ": Price " + it.getItemList().get(0).getPrice() + ", "
                    + "Shipping Cost " + it.getItemList().get(0).getShippingCost() + ", "
                    + "Rating " + it.getItemList().get(0).getRating() + "; ");
        });

        int a = finalResults.stream().mapToInt(it -> it.getItemList().get(0).getRating()).sum();

        System.out.println("\n" + "Total item quantity: " + finalResults.size());
        System.out.println("Total rating is: " + a);
    }

    /**
     * sort items by total cost and rating in each category
     */
    @Override
    public void sortEachCategory() {
        categories.forEach(it -> it.getItemList().sort((o1, o2) -> {
            Integer x1 = o1.getPrice() + o1.getShippingCost();
            Integer x2 = o2.getPrice() + o2.getShippingCost();
            int sComp = x1.compareTo(x2);

            if (sComp != 0) {
                return sComp;
            }

            Integer y1 = o1.getRating();
            Integer y2 = o2.getRating();
            return y2.compareTo(y1);
        }));
    }

    /**
     * Sort between categories by its best item
     */
    @Override
    public void sortCategoriesByBestItems() {
        categories.sort((o1, o2) -> {
            Integer x1 = o1.getItemList().get(0).getPrice() + o1.getItemList().get(0).getShippingCost();
            Integer x2 = o2.getItemList().get(0).getPrice() + o2.getItemList().get(0).getShippingCost();
            int sComp = x1.compareTo(x2);

            if (sComp != 0) {
                return sComp;
            }

            Integer y1 = o1.getItemList().get(0).getRating();
            Integer y2 = o2.getItemList().get(0).getRating();
            return y2.compareTo(y1);
        });
    }

    @Override
    public void findTopXResults() {
        int calculation = 0;

        for (Category category : categories) {
            if ((category.getItemList().get(0).getPrice() + category.getItemList().get(0).getShippingCost() + calculation)
                    <= Constant.PRICE_SUM_LIMITATION) {
                calculation = calculation + category.getItemList().get(0).getPrice() + category.getItemList().get(0).getShippingCost();
                finalResults.add(category);
            } else break;
        }
    }

}
