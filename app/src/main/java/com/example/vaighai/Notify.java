package com.example.vaighai;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Notify extends Activity {
@SuppressLint("NewApi")
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	 String possibleEmail = null;		  
		Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
		Account[] accounts = AccountManager.get(getApplicationContext()).getAccounts();
		for (Account account : accounts) {						
		    if (emailPattern.matcher(account.name).matches()) {
		    possibleEmail = account.name;				    				    
		      }
		    if(possibleEmail!=null)
		    {
		    break;
		    }
		    }	
	setContentView(R.layout.notifi);
	ListView lv = (ListView) findViewById(R.id.listView1);
	InputStream webs = null;
	try
	{ 		
		HttpClient httpclient = new DefaultHttpClient();
		String surl = "http://110.234.155.156:8080/Android/Laynot.php?var1="+possibleEmail;
		HttpPost httppost = new HttpPost(surl);			
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();
		webs = entity.getContent();	
		
	}
	catch (Exception e)
	{				
   Toast.makeText(getApplicationContext(), "Network Not Available", Toast.LENGTH_SHORT).show();
   		   
	}
	String result = null;	
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
    	   for (int j = 0; j < jArray.length(); j++) {    		   		  
    		   JSONObject Json = jArray.getJSONObject(j);
    		   Citemid[j] =Json.getString("SMSMESSAGE");
    		   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.da_item,Citemid)  ;		    		   
    		   lv.setAdapter(adapter);  
    		   }		    	
	  }
	  catch(Exception e)
	  {
	  }
	 lv.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> paret, View viewclicked,int position, long id) {
    TextView textview = (TextView) viewclicked;
    String message = textview.getText().toString();
     Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
		}	
	  });
}
}
