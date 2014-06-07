package com.andyidea.cat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HRegister extends Activity{
	boolean logined;
	
	OnClickListener registeringlis = null;
	Button registeringbut;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.hregister);
		
		logined = getResources().getBoolean(R.bool.logined);
		registeringlis = new OnClickListener(){
			public void onClick(View v) {	
				logined = true;
				Intent x = new Intent();
				x.setClass(HRegister.this,MainTabActivity.class);
				startActivity(x);
			}
		};
		registeringbut = (Button)findViewById(R.id.registering);
		registeringbut.setOnClickListener(registeringlis);
		
	}	
}
