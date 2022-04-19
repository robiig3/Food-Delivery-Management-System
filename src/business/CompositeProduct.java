package business;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct implements MenuItem{

    private static final long serialVersionUID = -5925076595280048059l;
    String title;
    float rating;
    int calories;
    int protein;
    int fat;
    int sodium;
    int price;
    int orderedTimes;

    public CompositeProduct() {
        this.title = "";
        this.rating = 0;
        this.calories = 0;
        this.protein = 0;
        this.fat = 0;
        this.sodium = 0;
        this.price = 0;
        this.orderedTimes = 0;
    }

    @Override
    public int computePrice() {
        return price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public float getRating() {
        return rating;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public int getProtein() {
        return protein;
    }

    @Override
    public int getFat() {
        return fat;
    }

    @Override
    public int getSodium() {
        return sodium;
    }

    @Override
    public int getOrderedTimes() {
        return orderedTimes;
    }

    @Override
    public void setTitle(String title) {
        this.title += title + " | ";
    }

    @Override
    public void setRating(float rating) {
        this.rating += rating;
    }

    @Override
    public void setCalories(int calories) {
        this.calories += calories;
    }

    @Override
    public void setProtein(int protein) {
        this.protein += protein;
    }

    @Override
    public void setFat(int fat) {
        this.fat += fat;
    }

    @Override
    public void setSodium(int sodium) {
        this.sodium += sodium;
    }

    @Override
    public void setPrice(int price) {
        this.price += price;
    }

    @Override
    public void setOrderedTimes() {
        this.orderedTimes ++;
    }

    public void addProduct(BaseProduct product){
        setTitle(product.title);
        setRating(product.rating);
        setCalories(product.calories);
        setProtein(product.protein);
        setFat(product.fat);
        setSodium(product.sodium);
        setPrice(product.price);
    }

    public void printDailyMenuProducts(){
        System.out.print(getTitle());
    }

}
