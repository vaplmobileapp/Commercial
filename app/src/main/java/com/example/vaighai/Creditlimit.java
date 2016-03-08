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
import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Creditlimit extends Activity {
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		//ActionBar actionBar = getActionBar();
	    //actionBar.hide();

	  //  actionBar.show();
	   // actionBar.setSubtitle("subtitle");
	    //actionBar.setTitle("title"); 
		setContentView(R.layout.credilimit);
		String s1=(getIntent().getExtras().getString("sdate1"));
	//	String s2=(getIntent().getExtras().getString("category"));
		String result = null;
				InputStream webs = null;
			try
			{			
			
				HttpClient httpclient = new DefaultHttpClient();
				String surl = "http://110.234.155.156:8080/Android/Creditlimit.php?var2="+s1+"&var1=emp";
				HttpPost httppost = new HttpPost(surl);			
				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				webs = entity.getContent();	
				
			}
			catch (Exception e)
			{
	
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
		    	  
		    	    TableLayout tableLayout = new TableLayout(this);	
		    	    int orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
		    	    // or = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
		    	    setRequestedOrientation(orientation);
		    	    TableRow tableRow;
		    	    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,Gravity.VERTICAL_GRAVITY_MASK);
		    	    
		    	    TextView textView;   	    
		    
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
		    	    	        		 textView.setText(Json.getString("MNAME"));
				    	    	          textView.setTextColor(Color.BLACK );				    	    	      
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {									
		    	    	          textView.setText (Json.getString("MNAME"));		    	    	          
		    	    	          textView.setTextColor(Color.BLACK );
		    	    	          textView.setTextSize(16);
		    	    	        	 } 
		    	    	         }
		    	    	        else if(k==1) {
		    	    	        	if(j==0)
		    	    	        	 {
		    	    	        		 textView.setText(Json.getString("POICYCREDITQTY"));
				    	    	          textView.setTextColor(Color.BLACK );
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {	
		    	    	        	 textView.setText(Json.getString("POICYCREDITQTY"));		    	    	       
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
		    	    	        		 textView.setText(Json.getString("POLICYCREDITDAYS"));
				    	    	          textView.setTextColor(Color.BLACK );
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {	
		    	    	        	 textView.setText(Json.getString("POLICYCREDITDAYS"));
		    	    	        	 textView.setTextColor(Color.BLACK );
		    	    	        	 }
		    	    	         }
		    	    	         else if(k==3) {
		    	    	        	 if(j==0)
		    	    	        	 {
		    	    	        		 textView.setText(Json.getString("POLICYCREDITLIMIT"));
				    	    	          textView.setTextColor(Color.BLACK );
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {	
		    	    	        	 textView.setText(Json.getString("POLICYCREDITLIMIT"));
		    	    	        	 textView.setTextColor(Color.BLACK );
		    	    	        	 }
		    	    	         }
		    	    	         else  if(k==4) {
		    	    	        	 if(j==0)
		    	    	        	 {
		    	    	        		 textView.setText(Json.getString("ACTDUEDAYS"));
				    	    	          textView.setTextColor(Color.BLACK );
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {										
									 textView.setText(Json.getString("ACTDUEDAYS"));
		    	    	        	 textView.setTextColor(Color.BLACK );
		    	    	        	 }
		    	    	         }	    	    	     
		    	    	         else  if(k==5) {
		    	    	        	 if(j==0)
		    	    	        	 {
		    	    	        		 textView.setText(Json.getString("ACTDUE"));
				    	    	          textView.setTextColor(Color.BLACK );
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {										
									 textView.setText(Json.getString("ACTDUE"));
		    	    	        	 textView.setTextColor(Color.BLACK );
		    	    	        	 }
		    	    	         }	    	
		    	    	            textView.setPadding(8, 8, 8, 8);
		    	    	            textView.setTextColor(Color.parseColor("#00FFFF"));
		    	    	            textView.setLayoutParams(layoutParams);
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
