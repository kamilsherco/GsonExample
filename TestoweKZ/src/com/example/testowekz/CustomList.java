package com.example.testowekz;


import java.util.ArrayList;


import android.app.Activity;
import android.graphics.Bitmap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomList extends ArrayAdapter<String>{
private final Activity context;
private final ArrayList<String> web;

private final ArrayList<Bitmap> images;

public CustomList(Activity context,
ArrayList<String> titles,ArrayList<Bitmap> images) {
super(context, R.layout.adapter, titles);
this.context = context;
this.web = titles;
this.images = images;

}
@Override
public View getView(int position, View view, ViewGroup parent) {
	
LayoutInflater inflater = context.getLayoutInflater();

View rowView= inflater.inflate(R.layout.adapter, null, true);
TextView txtTitle = (TextView) rowView.findViewById(R.id.tvTitle);

ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


txtTitle.setText(web.get(position));

imageView.setImageBitmap(images.get(position));


return rowView;
}

}