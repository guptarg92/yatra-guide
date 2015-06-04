package com.example.yatraguide;

import com.example.nearby.Mainmap;
import com.example.textimage.SearchActivity;
import com.example.translate.Trans;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Select extends Activity implements OnClickListener{
	ImageButton translate,iisearch,tisearch,nearby;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);
		translate=(ImageButton)findViewById(R.id.trans);
		iisearch=(ImageButton)findViewById(R.id.imageButton3);
		tisearch=(ImageButton)findViewById(R.id.imageButton1);
		nearby=(ImageButton)findViewById(R.id.imagebutton2);
		translate.setOnClickListener(this);
		iisearch.setOnClickListener(this);
		tisearch.setOnClickListener(this);
		nearby.setOnClickListener(this);
		
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.trans:
			Intent i=new Intent(Select.this,Trans.class);
			startActivity(i);
			
			break;
		case R.id.imageButton1:
			/*text-image search*/
			Intent i1=new Intent(Select.this,SearchActivity.class);
			startActivity(i1);
			break;
		case R.id.imagebutton2:
			Intent i2=new Intent(Select.this,Mainmap.class);
			startActivity(i2);
			break;
		case R.id.imageButton3:
			/*Image image search*/
			break;
			

		default:
			break;
		}
	}

	
}
