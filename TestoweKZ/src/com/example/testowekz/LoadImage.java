package com.example.testowekz;

import java.io.InputStream;
import java.net.URL;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;


public class LoadImage extends AsyncTask<String, String, Bitmap> {
	 Bitmap bitmap;
	 

    @Override
        protected void onPreExecute() {
            super.onPreExecute();
         
           
    }
       protected Bitmap doInBackground(String... args) {
        
		try {
               bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());
        } catch (Exception e) {
              e.printStackTrace();
        }
      return bitmap;
       }
       protected void onPostExecute(Bitmap image) {
      
       }
   }
