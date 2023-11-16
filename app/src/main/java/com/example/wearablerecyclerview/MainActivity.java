package com.example.wearablerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.wear.widget.WearableLinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.wearablerecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    MyMenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        init();
    }

    private void init()
    {
        mainBinding.wrcView.setHasFixedSize(true);
        mainBinding.wrcView.setEdgeItemsCenteringEnabled(true);
        mainBinding.wrcView.setLayoutManager(new WearableLinearLayoutManager(this));
        ArrayList<MyMenuItem> menuList =  new ArrayList<>();

        menuList.add(new MyMenuItem("Item 1", R.drawable.icon_1));
        menuList.add(new MyMenuItem("Item 2", R.drawable.icon_2));
        menuList.add(new MyMenuItem("Item 3", R.drawable.icon_3));
        menuList.add(new MyMenuItem("Item 4", R.drawable.icon_4));

        menuAdapter = new MyMenuAdapter(menuList,getApplicationContext());
        mainBinding.wrcView.setAdapter(menuAdapter);
        menuAdapter.notifyDataSetChanged();
    }
}