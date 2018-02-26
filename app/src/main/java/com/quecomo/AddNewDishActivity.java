package com.quecomo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.quecomo.entities.Dish;

public class AddNewDishActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_dish);
    }

    public void saveNewDish(View view) {
        EditText editText = findViewById(R.id.dishNameInput);
        String dishName = editText.getText().toString();
        if (!"".equals(dishName)) {
            String firstLetter = dishName.substring(0,1);
            firstLetter = firstLetter.toUpperCase();
            dishName = firstLetter + dishName.substring(1);
            Dish newDish = new Dish(dishName, null);
            newDish.save();
            Toast toast = Toast.makeText(this, R.string.newDishAdded, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            Intent intent = new Intent(AddNewDishActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }



}
