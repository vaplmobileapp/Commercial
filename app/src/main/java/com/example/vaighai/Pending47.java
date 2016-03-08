package com.example.vaighai;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Pending47 extends Activity {
@SuppressLint("NewApi")
@Override
protected void onCreate(Bundle savedInstanceState) {	
	super.onCreate(savedInstanceState);
	setContentView(R.layout.pending47);
	StrictMode.enableDefaults();		
	String result = null;				
		InputStream webs = null;
		try
		{
			HttpClient httpclient = new DefaultHttpClient();
			String surl = "http://110.234.155.156:8080/Android/47oilpending.php";
			HttpPost httppost = new HttpPost(surl);			
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			webs = entity.getContent();	
			
		}
		catch (Exception e)
		{
	//	tv.setText("Not connected to Db");			
	   Toast.makeText(getApplicationContext(), "Network Not Available", Toast.LENGTH_SHORT).show();
	   
	   
		}
		try
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(webs,"iso.8859-1"),8);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line=br.readLine())!=null)
		{
		sb.append(line+"/n");	
		}
		
		webs.close();
		
		result=sb.toString() ;
		}
	   catch(Exception e)
	   {
		   
	   }
		try {    	   
	    	   super.onCreate(savedInstanceState);
	    	  
	    	    TableLayout tableLayout = new TableLayout(getApplicationContext());    	      	  
	    	    TableRow tableRow;
	    	    TextView textView;    	    
	    	   // Toast.makeText(getApplicationContext(), s1, Toast.LENGTH_SHORT).show();
	    	    JSONArray jArray = new JSONArray(result);
	    	   for (int j = 0; j < jArray.length(); j++) {
	    		   tableRow = new TableRow(getApplicationContext());    		  
	    		   JSONObject Json = jArray.getJSONObject(j);    		 
	    				   for (int k = 0; k < 6; k++) {    					   
	    	    	         textView = new TextView(getApplicationContext());
	    	    	         if (k==0)											
	    	    	         {
	    	    	        	 if(j==0)
	    	    	        	 {
	    	    	           textView.setText(Json.getString("Party"));
			    	    	   textView.setTextColor(Color.BLACK );
			    	    	   textView.setTextSize(16);	
			    	    	   textView.setTypeface(Typeface.DEFAULT_BOLD);
	    	    	        	 }
	    	    	        	 else {									
								
	    	    	          textView.setText(Json.getString("Party"));
	    	    	          textView.setTextColor(Color.BLACK );
	    	    	          textView.setTextSize(16);
	    	    	        	 }
	    	    	         }
	    	    	        else if(k==1) {
	    	    	        	 if(j==0)
	    	    	        	 {
	    	    	           textView.setText(Json.getString("TOTQTY"));
			    	    	   textView.setTextColor(Color.BLACK );
			    	    	   textView.setTextSize(16);	
			    	    	   textView.setTypeface(Typeface.DEFAULT_BOLD);
	    	    	        	 }
	    	    	        	 else {	
	    	    	        	 textView.setText(Json.getString("TOTQTY"));		    	    	       
	    	    	        	 textView.setTextColor(Color.BLACK  );		    	    	        	// 
	    	    	        	 textView.setTextSize(16);
	    	    	        	 textView.setTypeface(Typeface.DEFAULT_BOLD);
	    	    	        	 }
	    	    	        	 if(j==0 || j==jArray.length()-1)
	       	    	          {    
	    	    	        		 textView.setTextColor(Color.BLACK );;
	       	    	          
	       	    	          }
							}
	    	    	         else if(k==2) {
	    	    	        	 if(j==0)
	    	    	        	 {
	    	    	           textView.setText(Json.getString("MDUQTY"));
			    	    	   textView.setTextColor(Color.BLACK );
			    	    	   textView.setTextSize(16);	
			    	    	   textView.setTypeface(Typeface.DEFAULT_BOLD);
	    	    	        	 }
	    	    	        	 else {	
	    	    	        	 textView.setText(Json.getString("MDUQTY"));
	    	    	        	 textView.setTextColor(Color.BLACK );
	    	    	        	 }
	    	    	         }
	    	    	         else if(k==3) {
	    	    	        	 if(j==0)
	    	    	        	 {
	    	    	           textView.setText(Json.getString("TVLQTY"));
			    	    	   textView.setTextColor(Color.BLACK );
			    	    	   textView.setTextSize(16);	
			    	    	   textView.setTypeface(Typeface.DEFAULT_BOLD);
	    	    	        	 }
	    	    	        	 else {	
	    	    	        	 textView.setText(Json.getString("TVLQTY"));
	    	    	        	 textView.setTextColor(Color.BLACK );
	    	    	        	 }
	    	    	         }
	    	    	         else  if(k==4) {
	    	    	        	 if(j==0)
	    	    	        	 {
	    	    	           textView.setText(Json.getString("NKLQTY"));
			    	    	   textView.setTextColor(Color.BLACK );
			    	    	   textView.setTextSize(16);	
			    	    	   textView.setTypeface(Typeface.DEFAULT_BOLD);
	    	    	        	 }
	    	    	        	 else {	
	    	    	        	 textView.setText(Json.getString("NKLQTY"));
	    	    	        	 textView.setTextColor(Color.BLACK );
	    	    	        	 }
	    	    	         }
	    	    	        
	    	    	            textView.setPadding(8, 8, 8, 8);
	    	    	            textView.setTextColor(Color.parseColor("#00FFFF"));
	    	    	             tableRow.addView(textView);		    	    	                	             
	    	    	                     	    	             }
	    				   tableLayout.addView(tableRow);   				   
	    				  
	    		    	    	    }		    	
	    	   ScrollView scroll = new ScrollView(getApplicationContext());
	    	    scroll.addView(tableLayout);		    	   
	    	   setContentView(scroll);		    	   
	    	    	   
		} catch (Exception e) {
	 
			
			
		}
}
}
