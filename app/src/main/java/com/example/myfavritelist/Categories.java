package com.example.myfavritelist;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private String CategoryName;
    private ArrayList<String> CategoryItemList = new ArrayList<>();

    public Categories(String categoryName, ArrayList<String> categoryItemList) {
        CategoryName = categoryName;
        CategoryItemList = categoryItemList;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public List<String> getCategoryItemList() {
        return CategoryItemList;
    }
}
