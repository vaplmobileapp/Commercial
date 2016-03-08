package com.example.vaighai;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Itemselect extends Activity {
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itemselect);
			ListView listview = (ListView) findViewById(R.id.listView1);	
			listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> paret, View viewclicked,int position, long id) {
            TextView textview = (TextView) viewclicked;
            String message = textview.getText().toString();
             Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
				}

				
			
			
			  });
				
				 
	}

}
