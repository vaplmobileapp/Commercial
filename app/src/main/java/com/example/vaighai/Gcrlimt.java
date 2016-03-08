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

import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Gcrlimt extends Activity {
	
	ArrayAdapter<String> adapter;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gcredlimt);
		StrictMode.enableDefaults();	
		String result = null;	
		ListView listview = (ListView) findViewById(R.id.listView1);
		EditText inputSearch = (EditText) findViewById(R.id.editText1);
		//final Spinner sp1 = (Spinner) findViewById(R.id.spinner1);
		InputStream webs = null;
			try
			{
				HttpClient httpclient = new DefaultHttpClient();
				String surl = "http://110.234.155.156:8080/Android/Group.php";
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
			 		
				  
		    	    JSONArray jArray = new JSONArray(result);
		    	  
		    	   String[] Citemid = new  String[jArray.length()];
		    	   String[] party = new  String[jArray.length()];		    	 
		    	   for (int j = 0; j < jArray.length(); j++) {
		    		   		  
		    		   JSONObject Json = jArray.getJSONObject(j);
		    		   Citemid[j] =Json.getString("PARTYID");
		    		   party[j]=Json.getString("partymastid");
		    		   adapter = new ArrayAdapter<String>(this,R.layout.da_item,Citemid)  ;		    		   
		    		   listview.setAdapter(adapter);
		    		   inputSearch.addTextChangedListener(new TextWatcher() {

		    		        public void onTextChanged(CharSequence cs, int arg1, int arg2,
		    		                int arg3) {
		    		            // When user changed the Text
		    		            Gcrlimt.this.adapter.getFilter().filter(cs);
		    		        }

		    		        public void beforeTextChanged(CharSequence arg0, int arg1,
		    		                int arg2, int arg3) {
		    		            // TODO Auto-generated method stub

		    		        }

		    		        public void afterTextChange(Editable arg0) {
		    		            // TODO Auto-generated method stub

		    		        }

		    		        public void afterTextChanged(Editable s) {
		    		            // TODO Auto-generated method stub

		    		        }
		    		    });
		    		 
		    		   
		    		   }	
		    	  
			  }
			  catch(Exception e)
			  {
			  }
			
			 listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> paret, View viewclicked,int position, long id) {
            TextView textview = (TextView) viewclicked;
            String message = textview.getText().toString();
        //    String Itemcate =  String.valueOf(sp1.getSelectedItem());
            
            message=message.replace(" ", "");
            Intent crin = new Intent(Gcrlimt.this,Creditlimit.class);
            crin.putExtra("sdate1", message.toString());
          //  crin.putExtra("category", Itemcate.toString());  
            startActivity(crin);
             Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
				}

				
			
			
			  });
	}

}
