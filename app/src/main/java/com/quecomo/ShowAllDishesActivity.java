package com.quecomo;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.quecomo.classes.DishesListAdapter;
import com.quecomo.entities.Dish;

import java.util.List;

public class ShowAllDishesActivity extends AppCompatActivity {

    private ListView dishesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_dishes);
        DishesListAdapter adapter = new DishesListAdapter(this, getDishesNames());
        dishesList = (ListView) findViewById(R.id.dishesListView);
        dishesList.setAdapter(adapter);
    }

    public String[] getDishesNames() {
        List<Dish> dishesList = Dish.listAll(Dish.class);
        String[] dishesNames = new String[dishesList.size()];

        int i = 0;
        for(Dish dish : dishesList) {
            dishesNames[i] = dish.getName();
            i++;
        }
        return dishesNames;
    }
}
