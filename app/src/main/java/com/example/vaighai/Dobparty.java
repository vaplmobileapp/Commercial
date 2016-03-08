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
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Dobparty extends Activity implements OnClickListener {
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		int id_click=0;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doboutstanding);
		StrictMode.enableDefaults();
		String s1=(getIntent().getExtras().getString("sdate1"));	
		String result = null;
				InputStream webs = null;
			try
			{
				HttpClient httpclient = new DefaultHttpClient();
				String surl = "http://110.234.155.156:8080/Android/DOBOUTSTANDING.php?var1="+s1+"&var2=sfgg";		
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
		    	  
		    	  
		    	    TableLayout tableLayout = new TableLayout(getApplicationContext());    	      	  
		    	    TableRow tableRow;
		    	    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT , Gravity.VERTICAL_GRAVITY_MASK);
		    	    TextView textView;    	    
		    	
		    	    JSONArray jArray = new JSONArray(result);
		    	   for (int j = 0; j < jArray.length(); j++) {
		    		   tableRow = new TableRow(getApplicationContext());    		  
		    		   JSONObject Json = jArray.getJSONObject(j);    		 
		    				   for (int k = 0; k < 6; k++) {    					   
		    	    	         textView = new TextView(getApplicationContext());
		    	    	         textView.setId(id_click);				    	    	       
		    	    	        textView.setOnClickListener(this);
		    	    	         if (k==0)											
		    	    	         {
		    	    	        	 if(j==0)
		    	    	        	 {
		    	    	        		 textView.setText(Json.getString("Mname"));
				    	    	          textView.setTextColor(Color.BLACK );
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {									
		    	    	          textView.setText(Json.getString("Mname"));
		    	    	          textView.setTextColor(Color.BLACK );
		    	    	          textView.setTextSize(16);
		    	    	        	 } 
		    	    	         }
		    	    	        else if(k==1) {
		    	    	        	if(j==0)
		    	    	        	 {
		    	    	        		 textView.setText(Json.getString("Total"));
				    	    	          textView.setTextColor(Color.BLACK );
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {	
		    	    	        	 textView.setText(Json.getString("Total"));		    	    	       
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
		    	    	        		 textView.setText(Json.getString("MDU"));
				    	    	          textView.setTextColor(Color.BLACK );
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {	
		    	    	        	 textView.setText(Json.getString("MDU"));
		    	    	        	 textView.setTextColor(Color.BLACK );
		    	    	        	 }
		    	    	         }
		    	    	         else if(k==3) {
		    	    	        	 if(j==0)
		    	    	        	 {
		    	    	        		 textView.setText(Json.getString("TVL"));
				    	    	          textView.setTextColor(Color.BLACK );
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {	
		    	    	        	 textView.setText(Json.getString("TVL"));
		    	    	        	 textView.setTextColor(Color.BLACK );
		    	    	        	 }
		    	    	         }
		    	    	         else  if(k==4) {
		    	    	        	 if(j==0)
		    	    	        	 {
		    	    	        		 textView.setText(Json.getString("NKL"));
				    	    	          textView.setTextColor(Color.BLACK );
				    	    	          textView.setTextSize(16);
				    	    	          textView.setTypeface(Typeface.DEFAULT_BOLD);
		    	    	        	 }
		    	    	        	 else {										
									 textView.setText(Json.getString("NKL"));
		    	    	        	 textView.setTextColor(Color.BLACK );
		    	    	        	 }
		    	    	         }
		    	    	        
		    	    	            textView.setPadding(8, 8, 8, 8);
		    	    	            textView.setTextColor(Color.parseColor("#00FFFF"));
		    	    	            textView.setLayoutParams(layoutParams);
		    	    	             tableRow.addView(textView);		    	    	                	             
		    	    	                     	    	             }
		    				   tableLayout.addView(tableRow);
		    				   id_click++;
		    				  
		    		    	    	    }		    	
		    	   ScrollView scroll = new ScrollView(getApplicationContext());
		    	    scroll.addView(tableLayout);		    	   
		    	   setContentView(scroll);		    	   
		    	    	   
			} catch (Exception e) {
		 
				
				
			}
	}

	@Override
	public void onClick(View v) {
		
		//int i = (int) Math.ceil( v.getId()/5) ;
		//Toast.makeText(getApplicationContext(),i , Toast.LENGTH_SHORT).show();
		//switch (i) {
		//case 1:
//			String s2=(getIntent().getExtras().getString("sdate"));
		//	 Intent It=new Intent(this,Dobparty.class);	
	    	 //It.putExtra("sdate1", s2.toString());
	    	 //startActivity(It); 	 
			//break;
	
		//}
		
	}

}
