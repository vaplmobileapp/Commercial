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
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Stock extends Activity implements OnClickListener {

@Override
protected void onCreate(Bundle savedInstanceState) {
	 int id_click=0;
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.stock);	
	String s1=(getIntent().getExtras().getString("sdate"));
	String result = null;
	InputStream webs = null;	
	
	try
	{
		HttpClient httpclient = new DefaultHttpClient();
		String surl = "http://110.234.155.156:8080/Android/stock.php?var1="+s1+"&var2=sfgg";
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
	catch (Exception e)
	{
		
	}
		
   try {    	   
	   super.onCreate(savedInstanceState);
	    TableLayout tableLayout = new TableLayout(getApplicationContext());    	      	  
	    TableRow tableRow;
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
	    	        	 if(j==0)
	    	        	 {
	    	        		 textView.setText(Json.getString("SUBCATEGORY"));
	   	    	          textView.setTextColor(Color.BLACK );
	   	    	          textView.setTextSize(16);
	   	    	       textView.setTypeface(Typeface.DEFAULT_BOLD);
	   	    	       
	    	        	 }
	    	        	 else
	    	        	 {
	    	          textView.setText(Json.getString("SUBCATEGORY"));
	    	          textView.setTextColor(Color.BLACK );
	    	          textView.setTextSize(16);
	    	        	 }	    	       
	    	         }
	    	         else if(k==1) {	    	        	 
	    	        	 textView.setText(Json.getString("CLOSING"));
	    	        	 textView.setTextColor(Color.BLACK  );
	    	        	 textView.setTypeface(Typeface.DEFAULT_BOLD);
	    	        	 textView.setTextSize(16);	    	        	
					}
	    	         else if(k==2) {
	    	        	 if(j==0)
	    	        	 {
	    	        		 textView.setText(Json.getString("MDU"));
		   	    	          textView.setTextColor(Color.BLACK );
		   	    	          textView.setTextSize(16);
		   	    	       textView.setTypeface(Typeface.DEFAULT_BOLD);
	    	        		 
	    	        	 }
	    	        	 else
	    	        	 {
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
	    	        	 else
	    	        	 {
	    	        	 textView.setText(Json.getString("TVL"));
	    	        	 textView.setTextColor(Color.BLACK );
	    	        	 }
	    	        	
	    	         }
	    	         else if(k==4) {
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
	    	             tableRow.addView(textView);	 
	    	             id_click++; 
	    	                     	    	             }
				   tableLayout.addView(tableRow);
				  
		    	    	    }
	   	   
	     
	   ScrollView scroll = new ScrollView(getApplicationContext());
	   scroll.addView(tableLayout);
	   setContentView(scroll);  
	  
} catch (Exception e) {

	
	
}	
     
 
}



@Override
public void onClick(View v) {	
	int i = (int) Math.ceil(v.getId()/5);
    switch (i) {    
    case 5:
    	String s2=(getIntent().getExtras().getString("sdate"));
    	 Intent It=new Intent(Stock.this,Dobstock.class);
    	 It.putExtra("sdate1", s2);
    	 startActivity(It); 	 
        break;
    case 2:
    	String s3=(getIntent().getExtras().getString("sdate"));
   	 Intent Oilint=new Intent(Stock.this,oilstock.class);
   	Oilint.putExtra("sdate1", s3);
   	 startActivity(Oilint);   
        break;
    case 4:
    	String s4=(getIntent().getExtras().getString("sdate"));
   	 Intent feedint=new Intent(Stock.this,Feedstock.class);
   	feedint.putExtra("sdate1", s4);
   	 startActivity(feedint);   
        break;
    case 3:
    	String s5=(getIntent().getExtras().getString("sdate"));
   	 Intent fiint=new Intent(Stock.this,fistock.class);
   	fiint.putExtra("sdate1", s5);
   	 startActivity(fiint);   
        break;
    case 1:
    	String s6=(getIntent().getExtras().getString("sdate"));
   	 Intent wheatint=new Intent(Stock.this, Wheatstock.class);
   	wheatint.putExtra("sdate1", s6);
   	 startActivity(wheatint);   
        break;
    case 7:
    	String s7=(getIntent().getExtras().getString("sdate"));
   	 Intent branint=new Intent(Stock.this, Branstock.class);
   	branint.putExtra("sdate1", s7);
   	 startActivity(branint);   
        break; 
}
}
}
