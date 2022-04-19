package business;

public class BaseProduct implements MenuItem{

    private static final long serialVersionUID = -6398618787439004303l;
    String title;
    float rating;
    int calories;
    int protein;
    int fat;
    int sodium;
    int price;
    int orderedTimes;

    //TODO: composite design pattern

    public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, int price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
        this.orderedTimes = 0;
    }

    public String getTitle() {
        return title;
    }

    public float getRating() {
        return rating;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    @Override
    public int getOrderedTimes() {
        return orderedTimes;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Override
    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setOrderedTimes() {
        this.orderedTimes ++;
    }

    @Override
    public int computePrice() {
        return price;
    }



    @Override
    public String toString() {
        return "BaseProduct{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';
    }

}
