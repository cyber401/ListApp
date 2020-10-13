package com.example.myfavritelist;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CategoryManager {

    private Context mContext;
    Set<String> categoriesSet;



    public CategoryManager(Context context){

        mContext = context;
    }

    public void saveData(Categories categories){
        categoriesSet = new HashSet<>(categories.getCategoryItemList());
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putStringSet(categories.getCategoryName(), categoriesSet);
        sharedPreferencesEditor.apply();
    }

        public void retrieveData(){
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
                Map<String,?>  data = sharedPreferences.getAll();
        //      ArrayList<Categories> category = new ArrayList<>();
                for(Map.Entry<String, ?> entry : data.entrySet()){
                    Categories categories = new Categories(entry.getKey(), new ArrayList<String>((HashSet)entry.getValue())); 
                }

        }
}
