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
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;




public class TimeAlarm  extends BroadcastReceiver {	
	 NotificationManager nm;
	protected static  int NOTIFICATION_ID = 0;
	String result = null;
	String[] Citemid = new  String[100];	
	@SuppressLint("NewApi")
	@Override
	public void onReceive(Context context, Intent intent) {	
		if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
		        Intent serviceLauncher = new Intent(context, Login.class);
		        context.startService(serviceLauncher);		       
		    }
		  	   InputStream webs = null;
		  	 String possibleEmail = null;		  
				Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
				Account[] accounts = AccountManager.get(context).getAccounts();
				for (Account account : accounts) {						
				    if (emailPattern.matcher(account.name).matches()) {
				    possibleEmail = account.name;
								    
				      }
				    break;
				    }								
			try
			{
				HttpClient httpclient = new DefaultHttpClient();
				String surl = "http://110.234.155.156:8080/Android/salesnotify.php?var1="+possibleEmail;
				
				//Toast.makeText(context,possibleEmail, Toast.LENGTH_SHORT).show();
				HttpPost httppost = new HttpPost(surl);			
				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				webs = entity.getContent();	
				
			}
			catch (Exception e)
			{		 	  
		   
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
				
		    	    JSONArray jArray = new JSONArray(result);
		    	   for (int j = 0; j < jArray.length(); j++) {
		    	 JSONObject Json = jArray.getJSONObject(j);  
		    	 Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);		    	
		    	 Citemid[j]= Json.getString("SMSMESSAGE");		    	 
		    	 nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
				    NotificationCompat.Builder mBuilder =new NotificationCompat.Builder(context);
					mBuilder.setContentTitle("Vaighai")
				    .setContentText(Citemid[j])
				    .setSmallIcon(R.drawable.ic_launcher)
				    .setLights(0xFFFF0000, 500, 500)
					.setSound(soundUri);
					Intent notifyIntent = new Intent(context, Notify.class);
					PendingIntent contentIntent = PendingIntent.getActivity(context, 0,notifyIntent, android.content.Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);					
					mBuilder.setContentIntent(contentIntent);					
					Notification n = mBuilder.build();
					nm.notify(NOTIFICATION_ID++,n);	
					//mBuilder.setAutoCancel(true);
			}
			 }catch (Exception e) {	 
								
			}		
					}
	

}
