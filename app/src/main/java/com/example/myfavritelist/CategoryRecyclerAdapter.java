package com.example.myfavritelist;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder> {


    private ArrayList<Categories> data;
    public CategoryRecyclerAdapter(ArrayList<Categories> data) {
        this.data = data;
    }

    public void addCategory(Categories categories){
        data.add(categories);
        notifyItemInserted(data.size() - 1);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_category_recycler_layout,parent,false);
        return new CategoryViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.textView1.setText("1");
        holder.textView2.setText(data.get(position).getCategoryName());
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView textView1, textView2;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textViewOne);
            textView2 = itemView.findViewById(R.id.textViewTwo);
        }
    }
}
