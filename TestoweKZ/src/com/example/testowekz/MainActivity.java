package com.example.testowekz;

import java.io.IOException;
import java.io.InputStream;


import java.util.ArrayList;

import java.util.concurrent.ExecutionException;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;




 


public class MainActivity extends Activity {
	 
	 private String json;
	private ArrayList<String> titles = new ArrayList<String>();
	private  ArrayList<String> descriptions = new ArrayList<String>();
	private  ArrayList<Bitmap> images = new ArrayList<Bitmap>();
	private ListView list;

	
	 
	
  
    	@Override
    	protected void onCreate(Bundle savedInstanceState) {
    		// TODO Auto-generated method stub
    		super.onCreate(savedInstanceState);
    		

            setContentView(R.layout.activity_main);
            
           

        		json=loadJSONFromAsset();
        	
			      

        	JsonElement jelement = new JsonParser().parse(json);
            JsonObject  jobject = jelement.getAsJsonObject();
            jobject = jobject.getAsJsonObject("main");
            JsonObject  jobject1 = jelement.getAsJsonObject();
            jobject1 = jobject.getAsJsonObject("articles");
            JsonArray jarray = jobject1.getAsJsonArray("article");
            Article[] myArray = new Gson().fromJson(jarray, Article[].class);
           
            for (Article item : myArray)
            {
            	
            	titles.add(item.title);
            	descriptions.add(item.content);
            	//images.add(item.image);
            	try {
            		
					images.add(new LoadImage().execute(item.image).get());
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
       
            CustomList adapter = new
                    CustomList(MainActivity.this, titles, images);
                list=(ListView)findViewById(R.id.listView1);
                    list.setAdapter(adapter);
                  ;
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            

							@Override
							public void onItemClick(AdapterView<?> arg0,
									View arg1, int position, long arg3) {
								// TODO Auto-generated method stub
								
								Intent show = new Intent(MainActivity.this, ViewActivity.class);
								show.putExtra("image", images.get(position));
								show.putExtra("title", titles.get(position));
								show.putExtra("content", descriptions.get(position));
								startActivity(show);
								
							}
                        });
    	
                    
            
    	}
    	public String loadJSONFromAsset() {
    	    String json = null;
    	    try {

    	        InputStream is = getAssets().open("test.json");

    	        int size = is.available();

    	        byte[] buffer = new byte[size];

    	        is.read(buffer);

    	        is.close();

    	        json = new String(buffer, "UTF-8");


    	    } catch (IOException ex) {
    	        ex.printStackTrace();
    	        return null;
    	    }
    	    return json;

    	}
    	

    	
     
    

	
}