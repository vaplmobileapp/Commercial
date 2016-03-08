package com.example.vaighai;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;



public class MainActivity extends Activity {  


	@SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         Button b = (Button) findViewById(R.id.button1);
         Button BC = (Button) findViewById(R.id.button2);
         Button B3 = (Button) findViewById(R.id.button3);
         Button b4 = (Button) findViewById(R.id.button4);
         Button b5 = (Button) findViewById(R.id.button5);    
         Button b6 = (Button) findViewById(R.id.button6);
         Button b7 = (Button) findViewById(R.id.button7);
         final Button b8 = (Button) findViewById(R.id.button8);
         
         
         
     //    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
         StrictMode.enableDefaults();
        final DatePicker dp  = (DatePicker) findViewById(R.id.datePicker1);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= 11) {
            dp.setCalendarViewShown(false);            
        }   	
    	    	
        b8.setOnClickListener(new OnClickListener() {		     	 
        	       	
			@Override
			public void onClick(View v) {
				
				Intent I=new Intent(MainActivity.this,Gcrlimt.class);
				startActivity(I); 	
			}
		});
        b7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent I=new Intent(MainActivity.this,Production.class);
		        int   day  = (dp.getDayOfMonth());
		        int   month= dp.getMonth()+1;
		        int   year = dp.getYear();
		        String formattedMonth = "" + month;
		        String formattedDayOfMonth = "" + day;
		        if(month < 10){
		        	formattedMonth = ("0" + formattedMonth);
		        }
		        if(day < 10){
		        	formattedDayOfMonth = "0" + formattedDayOfMonth;
		        }
		        String docdate=((formattedDayOfMonth+"/"+formattedMonth+"/"+year));
		        String docmon=((formattedMonth+"/"+year));
		        	
		       I.putExtra("sdate", docdate.toString());
		       I.putExtra("sdate1", docmon.toString());
startActivity(I); 	
				
			}
		});
        
        b6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent I=new Intent(MainActivity.this,Outstanding.class);
		        int   day  = (dp.getDayOfMonth());
		        int   month= dp.getMonth()+1;
		        int   year = dp.getYear();
		        String formattedMonth = "" + month;
		        String formattedDayOfMonth = "" + day;
		        if(month < 10){
		        	formattedMonth = ("0" + formattedMonth);
		        }
		        if(day < 10){
		        	formattedDayOfMonth = "0" + formattedDayOfMonth;
		        }
		        String docdate=((formattedDayOfMonth+"/"+formattedMonth+"/"+year));	        		                      		
		        	
		       I.putExtra("sdate", docdate.toString());
startActivity(I); 	
				
			}
		});
        
        
        b5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent I=new Intent(MainActivity.this,Arrivals.class);
		        int   day  = (dp.getDayOfMonth());
		        int   month= dp.getMonth()+1;
		        int   year = dp.getYear();
		        String formattedMonth = "" + month;
		        String formattedDayOfMonth = "" + day;
		        if(month < 10){
		        	formattedMonth = ("0" + formattedMonth);
		        }
		        if(day < 10){
		        	formattedDayOfMonth = "0" + formattedDayOfMonth;
		        }
		        String docdate=((formattedDayOfMonth+"/"+formattedMonth+"/"+year));
		        String docmon=((formattedMonth+"/"+year));
		        	
		       I.putExtra("sdate", docdate.toString());
		       I.putExtra("sdate1", docmon.toString());
startActivity(I); 	
				
			}
		});
        b4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent I=new Intent(MainActivity.this,Stock.class);
		        int   day  = (dp.getDayOfMonth());
		        int   month= dp.getMonth()+1;
		        int   year = dp.getYear();
		        String formattedMonth = "" + month;
		        String formattedDayOfMonth = "" + day;
		        if(month < 10){
		        	formattedMonth = ("0" + formattedMonth);
		        }
		        if(day < 10){
		        	formattedDayOfMonth = "0" + formattedDayOfMonth;
		        }
		        String docdate=((formattedDayOfMonth+"/"+formattedMonth+"/"+year));		        		                      		
		        		//http://172.16.1.13/Android/get.php?var1=21/jul/13&var2=sfgg
		       I.putExtra("sdate", docdate.toString());
startActivity(I); 	
					
			}
		});
        	B3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent I=new Intent(MainActivity.this,Pencontract.class);
		        int   day  = (dp.getDayOfMonth());
		        int   month= dp.getMonth()+1;
		        int   year = dp.getYear();
		        String formattedMonth = "" + month;
		        String formattedDayOfMonth = "" + day;
		        if(month < 10){

		        	formattedMonth = ("0" + formattedMonth);
		        }
		        if(day < 10){

		        	formattedDayOfMonth = "0" + formattedDayOfMonth;
		        }
		        String docdate=((formattedDayOfMonth+"/"+formattedMonth+"/"+year));
		        	
startActivity(I);     	
				
					
				}
		});
        	BC.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent I=new Intent(MainActivity.this,Contract.class);
		        int   day  = (dp.getDayOfMonth());
		        int   month= dp.getMonth()+1;
		        int   year = dp.getYear();
		        String formattedMonth = "" + month;
		        String formattedDayOfMonth = "" + day;
		        if(month < 10){

		        	formattedMonth = ("0" + formattedMonth);
		        }
		        if(day < 10){

		        	formattedDayOfMonth = "0" + formattedDayOfMonth;
		        }
		        String docdate=((formattedDayOfMonth+"/"+formattedMonth+"/"+year));		        		                      		

		       I.putExtra("sdate", docdate.toString());
startActivity(I);    	
					
							
			}
		});

        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent I=new Intent(MainActivity.this,Next.class);
		        int   day  = (dp.getDayOfMonth());
		        int   month= dp.getMonth()+1;
		        int   year = dp.getYear();
		        String formattedMonth = "" + month;
		        String formattedDayOfMonth = "" + day;
		        if(month < 10){

		        	formattedMonth = ("0" + formattedMonth);
		        }
		        if(day < 10){

		        	formattedDayOfMonth = "0" + formattedDayOfMonth;
		        }
		        String docdate=((formattedDayOfMonth+"/"+formattedMonth+"/"+year));
		        String docmon=((formattedMonth+"/"+year));		        		                      		
		        	
		       I.putExtra("sdate", docdate.toString());
		       I.putExtra("sdate1", docmon.toString());
startActivity(I);     	
				
					
				}
        }
       
					
					
			);
    } 
    
	

	//@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);        
        //return true;
    //}
	
	
	
    
}
