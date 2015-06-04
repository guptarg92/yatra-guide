package com.example.translate;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.content.Intent;

import java.util.Locale;

import com.example.yatraguide.R;



import android.widget.Toast;


public class TransBing extends Activity implements OnClickListener{
	
		//TTS object
	
		//status check code

	public String translateRecText="";
	EditText ed;
		//create the Activity
	public void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.translate);
		ed=(EditText)findViewById(R.id.enter);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		     translateRecText = extras.getString("recText1");
		     ed.setText(translateRecText);
		}
		else{
			
			translateRecText=ed.getText().toString();
		}
		
		
	       
	}
	
		//respond to button clicks
	public void onClick(View v) {
			//change language engine if necessary
		
	    	
	    	
	}
	
	
	
		
		
	


		public void postTrans(View view){
			//called by translate button
			
			
			
	    	String words = ed.getText().toString();
			words = words.replaceAll(" ", "%20");
			Spinner langspin = (Spinner) findViewById(R.id.langspinner);
			String lang = String.valueOf(langspin.getSelectedItem());
			
			if(lang.equals("English")){
				post.get("http://api.microsofttranslator.com/V2/Ajax.svc/Translate?appId=78280AF4DFA1CE1676AFE86340C690023A5AC139&from=en&to=hi&text="+words);
				Toast.makeText(this, "posten", Toast.LENGTH_LONG).show();

			}
			else if(lang.equals("French")){
				post.get("http://api.microsofttranslator.com/V2/Ajax.svc/Translate?appId=78280AF4DFA1CE1676AFE86340C690023A5AC139&from=fr&to=en&text="+words);	
				Toast.makeText(this, "postfr", Toast.LENGTH_LONG).show();

			}
			else if(lang.equals("German")){
				post.get("http://api.microsofttranslator.com/V2/Ajax.svc/Translate?appId=78280AF4DFA1CE1676AFE86340C690023A5AC139&from=de&to=en&text="+words);
				Toast.makeText(this, "postde", Toast.LENGTH_LONG).show();

			}
			else if(lang.equals("Thai")){
				post.get("http://api.microsofttranslator.com/V2/Ajax.svc/Translate?appId=78280AF4DFA1CE1676AFE86340C690023A5AC139&from=th&to=en&text="+words);
				Toast.makeText(this, "post tamil", Toast.LENGTH_LONG).show();
			}
			else if(lang.equals("Japanese")){
				post.get("http://api.microsofttranslator.com/V2/Ajax.svc/Translate?appId=78280AF4DFA1CE1676AFE86340C690023A5AC139&from=ja&to=en&text="+words);
				Toast.makeText(this, "postja", Toast.LENGTH_LONG).show();
			}
			else if(lang.equals("")){
				post.get("http://api.microsofttranslator.com/V2/Ajax.svc/Translate?appId=78280AF4DFA1CE1676AFE86340C690023A5AC139&from=en&to=en&text="+words);
				Toast.makeText(this, "postit", Toast.LENGTH_LONG).show();

			}
			
		}
		
		Handler handler = new Handler() {
			  public void handleMessage(Message message) {
			    switch (message.what) {
			    case HttpConnection.DID_START:
			     // text.setText("Starting connection...");
			      break;
			    case HttpConnection.DID_SUCCEED:
					Toast.makeText(TransBing.this, "succeed", Toast.LENGTH_LONG).show();
			      String response = (String) message.obj;
			      Log.i("rev", response);
			      TextView text= (TextView)findViewById(R.id.textView2);
			      text.setText(response);
			      text.invalidate();
			      break;
			    case HttpConnection.DID_ERROR:
			      Exception e = (Exception) message.obj;
			      e.printStackTrace();
			    break;
			    }
			  }
			};
			HttpConnection post = new HttpConnection(handler);
}


