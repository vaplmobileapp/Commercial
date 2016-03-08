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

public class Salesmon extends Activity implements OnClickListener {
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.salesmoncat);
		StrictMode.enableDefaults();	
		int id_click=0;
		String s1=(getIntent().getExtras().getString("sdate1"));	
		String result = null;		
			InputStream webs = null;
			try
			{
				HttpClient httpclient = new DefaultHttpClient();
				String surl = "http://110.234.155.156:8080/Android/Salesmonth.php?var1="+s1+"&var2=sfgg";
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
			catch (Exception e)
			{
				
			}
				
	       try {    	   
	    	   super.onCreate(savedInstanceState);
	    	    TableLayout tableLayout = new TableLayout(getApplicationContext());    	      	  
	    	    TableRow tableRow;
	    	    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT , Gravity.VERTICAL_GRAVITY_MASK);
	    	    TextView textView;    	    
	    	    JSONArray jArray = new JSONArray(result);
	    	   for (int j = 0; j < jArray.length(); j++) {
	    		   tableRow = new TableRow(getApplicationContext());    		  
	    		   JSONObject Json = jArray.getJSONObject(j);    		 
	    				   for (int k = 0; k < 5; k++) {    					   
	    	    	         textView = new TextView(getApplicationContext());
	    	    	         textView.setId(id_click);	
	    	    	       
	    	    	         textView.setOnClickListener(this);
	    	    	         if (k==0)											
	    	    	         {
	    	    	          textView.setText(Json.getString("ITEMID"));
	    	    	          textView.setTextColor(Color.BLACK );
	    	    	          textView.setTextSize(16);
	    	    	          if(j==0 || j==jArray.length()-1)
	    	    	          {    
	    	    	        	textView.setTypeface(Typeface.DEFAULT_BOLD);
	    	    	          
	    	    	          }
	    	    	         }
	    	    	         else if(k==1) {
	    	    	        	 textView.setText(Json.getString("QTY"));
	    	    	        	 textView.setTextColor(Color.BLACK  );
	    	    	        	 textView.setTypeface(Typeface.DEFAULT_BOLD);
	    	    	        	 textView.setTextSize(16);
	    	    	        	 if(j==0 || j==jArray.length()-1)
	       	    	          {    
	       	    	        	textView.setTypeface(Typeface.DEFAULT_BOLD);
	       	    	          
	       	    	          }
							}
	    	    	         else if(k==2) {
	    	    	        	 textView.setText(Json.getString("MQTY"));
	    	    	        	 textView.setTextColor(Color.BLACK );
	    	    	        	 if(j==0 || j==jArray.length()-1)
	       	    	          {    
	       	    	        	textView.setTypeface(Typeface.DEFAULT_BOLD);
	       	    	        	textView.setTextColor(Color.BLACK );
	       	    	          
	       	    	          }
	    	    	         }
	    	    	         else if(k==3) {
	    	    	        	 textView.setText(Json.getString("TQTY"));
	    	    	        	 textView.setTextColor(Color.BLACK );
	    	    	        	 if(j==0 || j==jArray.length()-1)
	       	    	          {    
	       	    	        	textView.setTypeface(Typeface.DEFAULT_BOLD);
	       	    	        	textView.setTextColor(Color.BLACK );
	       	    	          
	       	    	          }
	    	    	         }
	    	    	         else if(k==4) {
	    	    	        	 textView.setText(Json.getString("NQTY"));
	    	    	        	 textView.setTextColor(Color.BLACK );
	    	    	        	 if(j==0 || j==jArray.length()-1)
	       	    	          {    
	       	    	        	textView.setTypeface(Typeface.DEFAULT_BOLD);
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
		switch (v.getId()) {
		case 2:
			String s2=(getIntent().getExtras().getString("sdate1"));
			Intent itdob = new Intent(this,Salesmondob.class);
			itdob.putExtra("sdate1", s2.toString());
			startActivity(itdob);
			break;
		case 3:
			String s3=(getIntent().getExtras().getString("sdate1"));
			Intent itfeed = new Intent(this,salesfeed.class);
			itfeed.putExtra("sdate1", s3.toString());
			startActivity(itfeed);
			break;
		case 4:
			String s4=(getIntent().getExtras().getString("sdate1"));
			Intent itfid = new Intent(this,Samonfi.class);
			itfid.putExtra("sdate1", s4.toString());
			startActivity(itfid);
			break;
		case 5:
			String s5=(getIntent().getExtras().getString("sdate1"));
			Intent itoil = new Intent(this,Samonoil.class);
			itoil.putExtra("sdate1", s5.toString());
			startActivity(itoil);

		default:
			break;
		}
		
	}

}