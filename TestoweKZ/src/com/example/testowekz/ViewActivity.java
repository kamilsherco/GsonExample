package com.example.testowekz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewActivity extends Activity {
	private TextView txtTitle;
	private TextView txtDesc ;
	private ImageView imageView;
	private Intent fromMain;
	private Bitmap image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		
		txtTitle = (TextView) findViewById(R.id.tVtitle);
		txtDesc = (TextView) findViewById(R.id.tVcontent);
		imageView = (ImageView) findViewById(R.id.iVimage);
		
		fromMain= getIntent();
		image=(Bitmap) fromMain.getParcelableExtra("image");
		txtTitle.setText(fromMain.getStringExtra("title"));
		txtDesc.setText(fromMain.getStringExtra("content"));
	
		imageView.setImageBitmap(image);
		
		
		
	}

}
