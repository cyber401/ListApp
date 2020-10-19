package com.example.myfavritelist;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CategoryManager categoryManager = new CategoryManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRecyclerView();
        FloatingActionButton floatingActionButton =  findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showAlertDialog();
            }
        });

    }

    public void showAlertDialog(){
        final EditText editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        AlertDialog.Builder alertDialogBox = new AlertDialog.Builder(this);
        alertDialogBox.setTitle("Enter Category Name").setView(editText).
                setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Categories categories = new Categories(editText.getText().toString(), new ArrayList<String>());
                        CategoryRecyclerAdapter categoryRecyclerAdapter = (CategoryRecyclerAdapter) recyclerView.getAdapter();
                        categoryRecyclerAdapter.addCategory(categories);
                    }
                });
        AlertDialog alertDialog = alertDialogBox.create();
        alertDialog.show();
        }
        public void setRecyclerView(){
            ArrayList<Categories> data = categoryManager.retrieveData();
            recyclerView = findViewById(R.id.categoryRecyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new CategoryRecyclerAdapter(data));
        }
    }

