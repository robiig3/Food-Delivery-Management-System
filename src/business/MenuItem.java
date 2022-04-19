package business;

import java.io.Serializable;

public interface MenuItem extends Serializable {

    int computePrice();

    String getTitle();

    float getRating();

    int getCalories();

    int getProtein();

    int getFat();

    int getSodium();

    int getOrderedTimes();

    void setTitle(String title);

    void setRating(float rating);

    void setCalories(int calories);

    void setProtein(int protein);

    void setFat(int fat);

    void setSodium(int sodium);

    void setPrice(int sodium);

    void setOrderedTimes();

}
