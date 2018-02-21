package com.quecomo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.quecomo.classes.DishesListAdapter;
import com.quecomo.entities.Dish;

import java.util.List;

public class ShowAllDishesActivity extends AppCompatActivity {

    private ListView dishesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_dishes);
        DishesListAdapter adapter = new DishesListAdapter(this, getDishesNames());
        dishesListView = (ListView) findViewById(R.id.dishesListView);
        dishesListView.setAdapter(adapter);

        dishesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int rowNumber,
                                    long id) {
                Intent intent = new Intent(ShowAllDishesActivity.this, EditDishActivity.class);
                String dishName =  getDishesNames()[rowNumber];
                intent.putExtra("dishName", dishName);
                startActivity(intent);
            }
        });

        registerForContextMenu(dishesListView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.dishesListView) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle(getDishesNames()[info.position]);
            String[] menuItems = getResources().getStringArray(R.array.dishMenuOptions);
            for (int i = 0; i < menuItems.length; i++) {
                menu.add(Menu.NONE, i, i, menuItems[i]);
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int menuItemIndex = item.getItemId();
        String[] optionsMenu = getResources().getStringArray(R.array.dishMenuOptions);
        String optionSelected = optionsMenu[menuItemIndex];
        String dishName = getDishesNames()[info.position];
        List<Dish> dishes = Dish.find(Dish.class, "name = ?", dishName);
        Dish dish = dishes.get(0);
        dish.delete();
        Toast toast = Toast.makeText(this, R.string.dishDeleted, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Intent intent = new Intent(ShowAllDishesActivity.this, ShowAllDishesActivity.class);
        startActivity(intent);

        return true;
    }

    public String[] getDishesNames() {
        List<Dish> dishesList = Dish.listAll(Dish.class);
        String[] dishesNames = new String[dishesList.size()];

        int i = 0;
        for (Dish dish : dishesList) {
            dishesNames[i] = dish.getName();
            i++;
        }
        return dishesNames;
    }
}
