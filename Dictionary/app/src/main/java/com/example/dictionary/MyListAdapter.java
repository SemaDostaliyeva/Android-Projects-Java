package com.example.dictionary;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    static ArrayList<String> first_word_array = new ArrayList<String>();
    static ArrayList<String> second_word_array = new ArrayList<String>();;

    public MyListAdapter(@NonNull Activity context, int resource) {
        super(context, resource, first_word_array);
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_list_item, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.ingword);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.azword);

        titleText.setText(first_word_array.get(position));
        subtitleText.setText(second_word_array.get(position));

        return rowView;

    };
}
