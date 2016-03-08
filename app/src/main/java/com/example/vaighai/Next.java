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
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Next extends Activity implements OnClickListener {
	
	@SuppressLint({ "NewApi", "ResourceAsColor" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 int id_click = 0;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);		
		StrictMode.enableDefaults();		    
		String s1=(getIntent().getExtras().getString("sdate"));	
		String result = null;		
			InputStream webs = null;
			try
			{
				HttpClient httpclient = new DefaultHttpClient();
				String surl = "http://110.234.155.156:8080/Android/Salescat.php?var1="+s1+"&var2=sfgg";
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
	    	    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT , Gravity.VERTICAL_GRAVITY_MASK);
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
		int i = (int) Math.ceil( v.getId()/5) ;		
		 switch (i) {    
		    case 2:
		    	String s1=(getIntent().getExtras().getString("sdate"));	
		    	 Intent It=new Intent(Next.this,Dobsales.class);
		    	 It.putExtra("sdate1", s1);
		    	 startActivity(It); 	 
		        break;
		    case 3:
		    	String s3=(getIntent().getExtras().getString("sdate"));
		   	 Intent Oilint=new Intent(Next.this,salesfeed.class);
		   	Oilint.putExtra("sdate1", s3);
		   	 startActivity(Oilint);   
		        break;
		    case 4:
		    	String s4=(getIntent().getExtras().getString("sdate"));
		   	 Intent fiint=new Intent(Next.this,fisales.class);
		   	fiint.putExtra("sdate1", s4);
		   	 startActivity(fiint);   
		        break;
		    case 5:
		    	String s5=(getIntent().getExtras().getString("sdate"));
		   	 Intent oilint=new Intent(Next.this,Oilsales.class);
		   	oilint.putExtra("sdate1", s5);
		   	 startActivity(oilint);   
		        break;
		
	}
	}
	
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {       
        getMenuInflater().inflate(R.menu.month, menu);        
        return true;
    }
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {	
		
	
	    switch(item.getItemId())
	    {
	    case R.id.item1 :
	    	String s2=(getIntent().getExtras().getString("sdate1"));	
	    	 Intent It=new Intent(this,Salesmon.class);	
	    	 It.putExtra("sdate1", s2.toString());
	    	 startActivity(It); 	 
	        break;
	   
	    }
	    return true;
	}

}
