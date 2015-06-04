package com.example.translate;


import com.example.yatraguide.R;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Trans extends Activity implements OnClickListener{
	Button ok;
	Spinner spin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trans);
		spin=(Spinner)findViewById(R.id.spinner1);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
		        R.array.language, android.R.layout.simple_spinner_item);
		    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spin.setAdapter(adapter);
		    ok=(Button)findViewById(R.id.ok_select);
		 
		    ok.setOnClickListener(this);
		    
		    
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		
			int position = spin.getSelectedItemPosition();
		    Intent intent = null;
		    switch (position) {
		    case 0:
		      intent = new Intent(Trans.this,MainEng.class);
		      startActivity(intent);
		      //Toast.makeText(getApplicationContext(), "English",Toast.LENGTH_LONG);
		      break;
		    case 1:
		    	intent = new Intent(Trans.this,MainJap.class);
		    
		    	 startActivity(intent);
		    	break;
		    case 2:
		    	intent = new Intent(Trans.this,MainTam.class);  
		    	//Toast.makeText(getApplicationContext(), "French",Toast.LENGTH_LONG);
		    	 startActivity(intent);
		    	break;
		    case 3:
		    	intent = new Intent(Trans.this,MainFre.class);
		    	//Toast.makeText(getApplicationContext(), "German",Toast.LENGTH_LONG);
		    	 startActivity(intent);
		    	break;
		    case 4:
		    	intent=new Intent(Trans.this,MainThai.class);
		    	startActivity(intent);
		    	break;
			
			

		default:
			break;
		}
		
	}
}

