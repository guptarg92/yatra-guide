package com.example.yatraguide;

import java.util.Timer;
import java.util.TimerTask;



import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {
	protected boolean active=true;
	public int currentImageIndex=0;
	protected int splashtime=1000;
	MainActivity thisobj;
	Timer timer;
	TimerTask tim;
	ImageView img;
	private int[]img_ids={R.drawable.a1,R.drawable.a11,R.drawable.a2};
		
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Handler hand=new Handler();
		final Runnable mupdatesResults=new Runnable() {
			
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
			animatedSlideshow();	
			}
		};
			int delay=1000;
			int period=8000;
			Timer timer=new Timer();
			timer.scheduleAtFixedRate(new TimerTask(){
				public void run(){
				hand.post(mupdatesResults);
			}
				
			},delay,period);thisobj=this;
			Thread splashThread = new Thread(){
				public void run(){
					try{
						int waited=0;
						while(active && (waited<splashtime))
						{
							sleep(500);
							if (active){
								waited += 100;}}}
					catch(InterruptedException e){}
					finally{ 
						Intent i= new Intent(MainActivity.this,Select.class);
					    startActivity(i);
							}
						}
					};
					splashThread.start();
					
				}	
		
		private void animatedSlideshow() {
				// TODO Auto-generated method stub
			img=(ImageView)findViewById(R.id.imageView1);
			img.setImageResource(img_ids[currentImageIndex%img_ids.length]);
			currentImageIndex ++;
			Animation rotateimg=AnimationUtils.loadAnimation(this, R.anim.fadein);
			img.startAnimation(rotateimg);
				
			}

		
		}
