package com.securepay.assignment.service;

import com.securepay.assignment.model.Category;
import com.securepay.assignment.model.Item;
import com.securepay.assignment.util.Constant;
import com.securepay.assignment.util.MathUtil;

import java.util.ArrayList;
import java.util.List;

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
                item.setPrice(MathUtil.generateIntRandom(Constant.MIN_ITEM_PRICE, Constant.MAX_ITEM_PRICE));
                item.setShippingCost(MathUtil.generateIntRandom(Constant.MIN_ITEM_SHIPPING_COST, Constant.MAX_ITEM_SHIPPING_COST));
                item.setRating(MathUtil.generateIntRandom(Constant.MIN_ITEM_RATING, Constant.MAX_ITEM_RATING));
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
    public void printAllCategories() {
        categories.forEach(it -> {
            System.out.println("\n" + it.getCategoryName());

            it.getItemList().forEach(item ->
                    System.out.println("Item" + (it.getItemList().indexOf(item) + 1) + ": " + "Price " + item.getPrice() + ", "
                            + "Shipping Cost " + item.getShippingCost() + ", "
                            + "Rating " + item.getRating() + "; "));
        });
    }

    @Override
    public void printFinalResultCategories() {

        System.out.println("\n" + "Basket should be as below: ");

        finalResults.forEach(it -> {
            System.out.println(it.getCategoryName() + " - "
                    + it.getItemList().get(0).getItemName()
                    + ": Price " + it.getItemList().get(0).getPrice() + ", "
                    + "Shipping Cost " + it.getItemList().get(0).getShippingCost() + ", "
                    + "Rating " + it.getItemList().get(0).getRating() + "; ");
        });

        int totalCost = finalResults.stream().mapToInt(it ->
                (it.getItemList().get(0).getPrice() + it.getItemList().get(0).getShippingCost())).sum();

        int totalRating = finalResults.stream().mapToInt(it ->
                it.getItemList().get(0).getRating()).sum();

        System.out.println("\n" + "Total picked item quantity: " + finalResults.size());
        System.out.println("Total cost: " + totalCost);
        System.out.println("Total rating: " + totalRating);
    }

    /**
     * sort items in each category by cost of (price + shipping cost) from low to high
     * and by rating from high to low as second sorting criteria
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
     * sort categories by its first optimized item by cost of (price + shipping cost) from low to high
     * and by rating from high to low as second sorting criteria
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
    public void findTopXResults(int sumLimit) {
        int calculation = 0;

        for (Category category : categories) {
            if ((category.getItemList().get(0).getPrice() + category.getItemList().get(0).getShippingCost() + calculation)
                    <= sumLimit) {
                calculation = calculation + category.getItemList().get(0).getPrice() + category.getItemList().get(0).getShippingCost();
                finalResults.add(category);
            } else break;
        }
    }

}
