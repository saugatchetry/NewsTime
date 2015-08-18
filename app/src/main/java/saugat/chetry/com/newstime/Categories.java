package saugat.chetry.com.newstime;

import java.util.ArrayList;

/**
 * Created by a511863 on 18/08/15.
 */
public class Categories {

    int categoryId;
    String categoryName;
    String categoryImageUrl;
    ArrayList<SubCategories> subCategoriesArrayList;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }

    public ArrayList<SubCategories> getSubCategoriesArrayList() {
        return subCategoriesArrayList;
    }

    public void setSubCategoriesArrayList(ArrayList<SubCategories> subCategoriesArrayList) {
        this.subCategoriesArrayList = subCategoriesArrayList;
    }
}
