package com.andyidea.cat;

import java.util.Timer;
import java.util.TimerTask;

import com.andyidea.cat.ImageAdapter;
import com.andyidea.cat.myGallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;
public class HMain extends Activity{
	private myGallery gallery; 	
	private ImageAdapter adapter;
	private int i = 0;
	private Timer timer = new Timer();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hmain);
		
		initRes();
		gallery.setSelection(500);
		
		timer.schedule(task,6000, 4000);
	}
	
	private void initRes(){
		
		gallery = (myGallery) findViewById(R.id.mygallery);
		adapter = new ImageAdapter(this); 	
		adapter.createReflectedImages();	
		gallery.setAdapter(adapter);		


		gallery.setOnItemClickListener(new OnItemClickListener() {	
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent x = new Intent();
				x.setClass(HMain.this, HAction.class);
				startActivity(x);
				
			}
		});
	}
	

	 private static final int timerAnimation = 1;
	 private final Handler mHandler = new Handler()
	 {
	  public void handleMessage(android.os.Message msg)
	  {
	   switch (msg.what)
	   {
	   case timerAnimation:
	   gallery.onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
	   break;
	   default:
	   break;
	   }
	  };
	 };

	 
	 private TimerTask task = new TimerTask()
	 {
	  public void run()
	  {
	   mHandler.sendEmptyMessage(timerAnimation);
	  }
	 };
	 
	 public void onPause(){
		 timer.cancel();
		 task.cancel();
		 super.onPause();		 
	 }


	 
	 public void onResume(){
		 timer = new Timer();
		 task = new TimerTask(){
			  public void run()
			  {
			   mHandler.sendEmptyMessage(timerAnimation);
			  }
			 };
		 timer.schedule(task, 6000, 4000);
		 super.onResume();
	 }
	 
	 public void onStop(){
		 timer.cancel();
		 task.cancel();
		 super.onStop();
	 }
}
