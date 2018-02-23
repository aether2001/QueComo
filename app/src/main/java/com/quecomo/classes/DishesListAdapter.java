package com.quecomo.classes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.quecomo.R;

/**
 * Created by armando on 20/02/18.
 */

public class DishesListAdapter extends ArrayAdapter {

    private final Activity context;
    private String[] dishesNames;


    public DishesListAdapter(Activity context, String[] nameArrayParam) {
        super(context, R.layout.dishes_list_row, nameArrayParam);
        this.context = context;
        this.dishesNames = nameArrayParam;
    }

    public String[] getDishesNames() {
        return dishesNames;
    }

    public void setDishesNames(String[] dishesNames) {
        this.dishesNames = dishesNames;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.dishes_list_row, null, true);

        TextView dishNameView = (TextView) rowView.findViewById(R.id.dishNameTextView);
        dishNameView.setText(dishesNames[position]);

        return rowView;
    }
}


