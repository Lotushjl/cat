package com.andyidea.cat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HList extends Activity{
	
	OnClickListener lis11111 = null;
	Button but11111;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hlist);
		
		
		lis11111 = new OnClickListener(){
			public void onClick(View v) {				
				Intent x = new Intent();
				x.setClass(HList.this, HAction.class);
				startActivity(x);
			}
		};
		but11111 = (Button)findViewById(R.id.actiononlist);
		but11111.setOnClickListener(lis11111);
	}

}
