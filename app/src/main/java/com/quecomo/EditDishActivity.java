package com.quecomo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.quecomo.entities.Dish;

import java.util.List;

public class EditDishActivity extends AppCompatActivity {

    private String beforeEditDishName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_dish);
        String dishName = getIntent().getStringExtra("dishName");
        TextView textView = findViewById(R.id.editDishText);
        textView.setText(dishName);
        beforeEditDishName = dishName;
    }

    public void editDish(View view) {
        EditText editText = findViewById(R.id.editDishText);
        String newDishName = editText.getText().toString();
        if (!"".equals(newDishName)) {
            List<Dish> dishes = Dish.find(Dish.class, "name = ?", beforeEditDishName);
            Dish dish = dishes.get(0);
            dish.setName(newDishName);
            dish.save();
            Toast toast = Toast.makeText(this, R.string.dishEdited, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            Intent intent = new Intent(EditDishActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
