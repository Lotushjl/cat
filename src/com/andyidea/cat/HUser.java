package com.andyidea.cat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HUser extends Activity{
	boolean logined;
	
	OnClickListener loginlis = null;
	Button loginbut;
	
	OnClickListener registerlis = null;
	Button registerbut;	

	

	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		
		super.onCreate(savedInstanceState);
		
		logined = getResources().getBoolean(R.bool.logined);
		loginlis = new OnClickListener() {
			public void onClick(View v) {				
				setContentView(R.layout.huser);
				logined = true;
			}
		};
		
		registerlis = new OnClickListener() {
			public void onClick(View v) {				
				Intent x = new Intent();
				x.setClass(HUser.this,HRegister.class);
				startActivity(x);
			}
		};
		

		
	
		if(logined){
			setContentView(R.layout.huser);
		}		
		else{setContentView(R.layout.hlogin);}
		
		loginbut = (Button)findViewById(R.id.logining);
		loginbut.setOnClickListener(loginlis);
		
		registerbut = (Button)findViewById(R.id.register);
		registerbut.setOnClickListener(registerlis);
		
		
	}

	
}
