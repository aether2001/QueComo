package com.quecomo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static List<String> recipesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeRecipesList();
    }


    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        TextView tv = findViewById(R.id.textView3);
        Random random = new Random();
        int minvalue = 0;
        int maxValue = recipesList.size();
        int generatedRandom = random.nextInt(maxValue - minvalue - 1);
        tv.setText(recipesList.get(generatedRandom));
    }

    public void showAddDishActivity(View view)
    {
        Intent intent = new Intent(MainActivity.this, AddNewDishActivity.class);
        startActivity(intent);
    }

    private void initializeRecipesList() {
        recipesList.add("Pollo con almendras");
        recipesList.add("Paella");
        recipesList.add("Pollo al horno con patatas");
        recipesList.add("Bacalao al horno con tomate");
        recipesList.add("Chino");
        recipesList.add("Canelones");
        recipesList.add("Arroz a la cubana con pinchitos de pollo");
    }

    public static List<String> getRecipesList() {
        return recipesList;
    }
}
