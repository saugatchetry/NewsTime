package saugat.chetry.com.newstime;

import java.util.ArrayList;

/**
 * Created by a511863 on 17/08/15.
 */
public class InternetData {

    String categoryName;
    String categoryImageUrl;
    int categoryId;
    int subCategoryId;
    String subCategoryName;
    String subCategoryImageUrl;
    String subCategoryDescription;
    int[] subCategoryIds = new int[3];
    String[][] subCategoryData = new String[3][];
    String[] subCategoryNames = new String[3];
    String[] subCategoryImageUrls = new String[3];
    String[] subCategoryDescriptions = new String[3];

    public String[] getSubCategoryImageUrls() {
        return subCategoryImageUrls;
    }

    public void setSubCategoryImageUrls(String[] subCategoryImageUrls) {
        this.subCategoryImageUrls = subCategoryImageUrls;
    }

    public String[] getSubCategoryDescriptions() {
        return subCategoryDescriptions;
    }

    public void setSubCategoryDescriptions(String[] subCategoryDescriptions) {
        this.subCategoryDescriptions = subCategoryDescriptions;
    }

    public String[] getSubCategoryNames() {
        return subCategoryNames;
    }

    public void setSubCategoryNames(String[] subCategoryNames) {
        this.subCategoryNames = subCategoryNames;
    }

    public int[] getSubCategoryIds() {
        return subCategoryIds;
    }

    public void setSubCategoryIds(int[] subCategoryIds) {
        this.subCategoryIds = subCategoryIds;
    }

    public String[][] getSubCategoryData() {
        return subCategoryData;
    }

    public void setSubCategoryData(String[][] subCategoryData) {
        this.subCategoryData = subCategoryData;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryImageUrl() {
        return subCategoryImageUrl;
    }

    public void setSubCategoryImageUrl(String subCategoryImageUrl) {
        this.subCategoryImageUrl = subCategoryImageUrl;
    }

    public String getSubCategoryDescription() {
        return subCategoryDescription;
    }

    public void setSubCategoryDescription(String subCategoryDescription) {
        this.subCategoryDescription = subCategoryDescription;
    }
}
