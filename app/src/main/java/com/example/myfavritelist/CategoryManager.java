package com.example.myfavritelist;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CategoryManager {

    private Context mContext;
    private Categories categories;
    Set<String> categoriesSet;



    void categoryManager(Context context){
        mContext = context;
    }

    public void saveCategory(){
        categoriesSet = new HashSet<>(categories.getCategoryItemList());

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putStringSet(categories.getCategoryName(), categoriesSet);
    }

}
