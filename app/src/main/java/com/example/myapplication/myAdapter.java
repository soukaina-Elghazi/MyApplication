package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
public class myAdapter extends ArrayAdapter<String> {
    int[] imageView;String[] product_description_details;String[] product_name_details;String[] product_price_details;Context context;
    public myAdapter(@NonNull Context context,String[] product_description_details,String[] name,String[] price,int[] imageView ) {
        super(context, R.layout.activity_presentation);
        this.product_description_details=product_description_details;
        this.product_name_details=name;
        this.product_price_details=price;
        this.imageView=imageView;
        this.context=context;}
    @Override public int getCount() {
        return product_description_details.length;
    }
    @NonNull @Override public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewHolder viewHolder =new viewHolder();
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_presentation, parent, false);
            viewHolder.description = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(viewHolder);
        }else {viewHolder=(viewHolder)convertView.getTag();}
            viewHolder.imageView.setImageResource(imageView[position]);
            viewHolder.description.setText(product_description_details[position]);
            return convertView;}
    static  class  viewHolder
    {ImageView imageView;TextView description;}}