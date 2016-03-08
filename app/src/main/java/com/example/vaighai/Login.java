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

import android.R.integer;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	protected static final int NOTIFICATION_ID = 0;
	AlarmManager am;
	@SuppressLint("NewApi")
	@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);	
	setContentView(R.layout.login);
	StrictMode.enableDefaults();
	Button btn= (Button) findViewById(R.id.button1);	
	final Button btn2 = (Button) findViewById(R.id.button2);
	
	final EditText username = (EditText) findViewById(R.id.editText1);
	final EditText password = (EditText) findViewById(R.id.editText2);
	
	btn2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		
			
		Intent itn = new Intent(Login.this,  Newuser.class);
		startActivity(itn); 
			
		}
	});
	
	try
	{
	
	AlarmManager am;	
	  am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);  
	Intent intent = new Intent(Login.this,  TimeAlarm.class);
	  PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,intent, PendingIntent.FLAG_UPDATE_CURRENT  );		
	  am.setRepeating(AlarmManager.RTC, SystemClock.elapsedRealtime(), 60 * 1000, pendingIntent);	

	}
	catch(Exception e)
	{
	}
	btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {			
			final String un = username.getText().toString();
			final String pass = password.getText().toString();
			InputStream webs = null;
			String result = null;	
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
				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
				String imeino=telephonyManager.getDeviceId();
				
			try
			   {
				HttpClient httpclient = new DefaultHttpClient();
			//	Toast.makeText(getApplicationContext(),"Invalid Username and Password", Toast.LENGTH_SHORT).show();
				String surl = "http://110.234.155.156:8080/Android/password.php?var1="+un+"&var2="+pass+"&var3="+possibleEmail+"&var4="+imeino;
				HttpPost httppost = new HttpPost(surl);
				HttpResponse response = httpclient.execute(httppost);			
				HttpEntity entity = response.getEntity();
				webs = entity.getContent();
			   }
			   catch(Exception e)
			   {
			//	   Toast.makeText(getApplicationContext(),"Invalid Username and Password", Toast.LENGTH_SHORT).show();	
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
				
				
					//Toast.makeText(getApplicationContext(),jval , Toast.LENGTH_SHORT).show();
				
				}
			   catch(Exception e)
			   {
				   
			   }		
			   
	    	    try {
					JSONArray jArray = new JSONArray(result);				
																
						  JSONObject Json = jArray.getJSONObject(0);
						 String JNAME= Json.getString("USERNAME");
						 String JPASS= Json.getString("PASSWORD");
					
						
					
					if((JNAME.equals(un) & JPASS.equals(pass)) )
					 {
						 Intent It=new Intent(Login.this,MainActivity.class);
						 startActivity(It);  
						 username.setText("");
						 password.setText("");
					 }							
					 else {					
							username.setText("");
							password.setText("");
					}
					 
				} catch (Exception e) {
					e.printStackTrace();
				}		  
		}		
	}	
	);
	username.setText("");
	password.setText("");
	
	}
	
}