package com.personal.textrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<MyModel> list;

    public CustomAdapter(Context context, List<MyModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.single_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.textName.setText(list.get(position).getName());
        holder.textAge.setText(String.valueOf(list.get(position).getAge())); // int 로 바꿔주기.
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList(List<MyModel> filteredList){
        list = filteredList;
        notifyDataSetChanged();
    }
}
