package com.personal.textrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MyModel> myModelList;
    CustomAdapter customAdapter;

    // 검색기능 구현하기./
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);


        displayItems();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String newText) {
        List<MyModel> filteredList = new ArrayList<>();
        for (MyModel item : myModelList) {
            if(item.getName().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        customAdapter.filterList(filteredList);
    }

    private void displayItems() {

        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        myModelList = new ArrayList<>();

        myModelList.add(new MyModel("Evan",25));
        myModelList.add(new MyModel("Kevin",42));
        myModelList.add(new MyModel("Raeed",12));
        myModelList.add(new MyModel("Arun",26));
        myModelList.add(new MyModel("Nori",28));
        myModelList.add(new MyModel("Silver",55));
        myModelList.add(new MyModel("Gold",35));
        myModelList.add(new MyModel("suzon",54));
        myModelList.add(new MyModel("Jihye",87));
        myModelList.add(new MyModel("JongHyun",33));
        myModelList.add(new MyModel("Clay",29));

        customAdapter = new CustomAdapter(this, myModelList);
        recyclerView.setAdapter(customAdapter);

    }
}