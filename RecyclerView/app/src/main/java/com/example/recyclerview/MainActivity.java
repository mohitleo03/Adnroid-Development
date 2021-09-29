package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapter.MainRecyclerAdapter;
import com.example.recyclerview.model.AllCategory;
import com.example.recyclerview.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mainCategoryRecycler;
    MainRecyclerAdapter mainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<CategoryItem> categoryItemList1 = new ArrayList<>();
        categoryItemList1.add(new CategoryItem(1,R.drawable.hindi1));
        categoryItemList1.add(new CategoryItem(1,R.drawable.hindi2));
        categoryItemList1.add(new CategoryItem(1,R.drawable.hindi3));
        categoryItemList1.add(new CategoryItem(1,R.drawable.hindi4));
        categoryItemList1.add(new CategoryItem(1,R.drawable.hindi5));

        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new CategoryItem(1,R.drawable.english1));
        categoryItemList2.add(new CategoryItem(1,R.drawable.english2));
        categoryItemList2.add(new CategoryItem(1,R.drawable.english3));
        categoryItemList2.add(new CategoryItem(1,R.drawable.english4));
        categoryItemList2.add(new CategoryItem(1,R.drawable.english5));

        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        categoryItemList3.add(new CategoryItem(1,R.drawable.punjabi1));
        categoryItemList3.add(new CategoryItem(1,R.drawable.punjabi2));
        categoryItemList3.add(new CategoryItem(1,R.drawable.punjabi3));
        categoryItemList3.add(new CategoryItem(1,R.drawable.punjabi4));
        categoryItemList3.add(new CategoryItem(1,R.drawable.punjabi5));

        List<CategoryItem> categoryItemList4 = new ArrayList<>();
        categoryItemList4.add(new CategoryItem(1,R.drawable.bpraak1));
        categoryItemList4.add(new CategoryItem(1,R.drawable.bpraak2));
        categoryItemList4.add(new CategoryItem(1,R.drawable.bpraak3));
        categoryItemList4.add(new CategoryItem(1,R.drawable.bpraak4));
        categoryItemList4.add(new CategoryItem(1,R.drawable.bpraak5));

        List<CategoryItem> categoryItemList5 = new ArrayList<>();
        categoryItemList5.add(new CategoryItem(1, R.drawable.taylor1));
        categoryItemList5.add(new CategoryItem(1, R.drawable.taylor2));
        categoryItemList5.add(new CategoryItem(1, R.drawable.taylor3));
        categoryItemList5.add(new CategoryItem(1, R.drawable.taylor4));

        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("Hindi", categoryItemList1));
        allCategoryList.add(new AllCategory("English", categoryItemList2));
        allCategoryList.add(new AllCategory("Punjabi",categoryItemList3));
        allCategoryList.add(new AllCategory("Best of B Praak",categoryItemList4));
        allCategoryList.add(new AllCategory("Best of Taylor Swift",categoryItemList5));

        setMainCategoryRecycler(allCategoryList);
    }

    private void setMainCategoryRecycler(List<AllCategory> allCategoryList){
        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }
}