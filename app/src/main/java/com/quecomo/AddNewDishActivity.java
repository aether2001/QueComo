package com.quecomo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewDishActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_dish);
    }

    public void saveNewDish(View view) {
        EditText editText = findViewById(R.id.dishNameInput);
        MainActivity.getRecipesList().add(editText.getText().toString());
        Toast toast = Toast.makeText(this, R.string.newDishAdded, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Intent intent = new Intent(AddNewDishActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
