package com.quecomo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.quecomo.entities.Dish;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        Random random = new Random();
        List<Dish> dishes = Dish.listAll(Dish.class);
        int numberOfDishes = dishes.size();
        if (dishes.size() > 0) {
            int generatedRandom = random.nextInt(numberOfDishes);
            TextView tv = findViewById(R.id.dishName);
            String dish = dishes.get(generatedRandom).getName();
            tv.setText(dish);
        }
    }

    public void showAddDishActivity(View view) {
        Intent intent = new Intent(MainActivity.this, AddNewDishActivity.class);
        startActivity(intent);
    }

    public void showAllDishesActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ShowAllDishesActivity.class);
        startActivity(intent);
    }

    /* Replaces last three characters of dish name with dots

     */
    public String formatDishNameDisplay(String dishName) {
            String dishNameString = new String(dishName);
            String formattedDish = dishNameString.substring(0, dishName.length() - 4);
            formattedDish += "." + "." + "." ;

            return  formattedDish;
    }

}
