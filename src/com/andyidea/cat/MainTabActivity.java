package com.andyidea.cat;

import java.util.HashMap;
import java.util.Stack;

import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainTabActivity extends TabActivity implements OnCheckedChangeListener{
	
	private TabHost mTabHost;
	private Intent mAIntent;
	private Intent mBIntent;
	private Intent mCIntent;
	private Intent mDIntent;
	private Intent mEIntent;
	private Stack<Integer> lastpos = new Stack<Integer>();
	private Integer lastp;

		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.maintabs);
        
        this.mAIntent = new Intent(this,HMain.class);
        this.mBIntent = new Intent(this,HSearch.class);
        this.mCIntent = new Intent(this,HList.class);
        this.mDIntent = new Intent(this,HUser.class);
        this.mEIntent = new Intent(this,HMore.class);
        
		((RadioButton) findViewById(R.id.radio_button0))
		.setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button1))
		.setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button2))
		.setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button3))
		.setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radio_button4))
		.setOnCheckedChangeListener(this);
        
        setupIntent();
        lastp = 1;
    }

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if(isChecked){
			switch (buttonView.getId()) {
			case R.id.radio_button0:
				lastpos.push(lastp);
				lastp = 1;
				this.mTabHost.setCurrentTabByTag("A_TAB");
				break;
			case R.id.radio_button1:
				lastpos.push(lastp);
				lastp = 2;
				this.mTabHost.setCurrentTabByTag("B_TAB");
				break;
			case R.id.radio_button2:
				lastpos.push(lastp);
				lastp = 3;
				this.mTabHost.setCurrentTabByTag("C_TAB");
				break;
			case R.id.radio_button3:
				lastpos.push(lastp);
				lastp = 4;
				this.mTabHost.setCurrentTabByTag("D_TAB");
				break;
			case R.id.radio_button4:
				lastpos.push(lastp);
				lastp = 5;
				this.mTabHost.setCurrentTabByTag("MORE_TAB");
				break;
			}
		}
		
	}

	
	private void setupIntent() {
		this.mTabHost = getTabHost();
		TabHost localTabHost = this.mTabHost;

		localTabHost.addTab(buildTabSpec("A_TAB", R.string.main_home,
				R.drawable.icon1, this.mAIntent));

		localTabHost.addTab(buildTabSpec("B_TAB", R.string.main_news,
				R.drawable.icon2, this.mBIntent));

		localTabHost.addTab(buildTabSpec("C_TAB",
				R.string.main_manage_date, R.drawable.icon3,
				this.mCIntent));

		localTabHost.addTab(buildTabSpec("D_TAB", R.string.main_friends,
				R.drawable.icon4, this.mDIntent));

		localTabHost.addTab(buildTabSpec("MORE_TAB", R.string.more,
				R.drawable.icon5, this.mEIntent));

	}
	
	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		return this.mTabHost.newTabSpec(tag).setIndicator(getString(resLabel),
				getResources().getDrawable(resIcon)).setContent(content);
	}
	
	@Override  
	public boolean dispatchKeyEvent(KeyEvent event) {  
	    if (event.getKeyCode() == KeyEvent.KEYCODE_BACK  
	            && event.getAction() == KeyEvent.ACTION_DOWN  
	            && event.getRepeatCount() == 0) {   	
	    	if(lastpos.empty()){
	    		System.exit(0);
	    	}
	    	else	{
	    		switch(lastpos.pop()){
	    		case 1:
	    			((RadioButton) findViewById(R.id.radio_button0)).setChecked(true);
	    			lastpos.pop();
	    			break;
	    		case 2:
	    			((RadioButton) findViewById(R.id.radio_button1)).setChecked(true);
	    			lastpos.pop();
	    			break;
	    		case 3:
	    			((RadioButton) findViewById(R.id.radio_button2)).setChecked(true);
	    			lastpos.pop();
	    			break;
	    		case 4:
	    			((RadioButton) findViewById(R.id.radio_button3)).setChecked(true);
	    			lastpos.pop();
	    			break;
	    		case 5:
	    			((RadioButton) findViewById(R.id.radio_button4)).setChecked(true);
	    			lastpos.pop();
	    			break;	
	    		}    		
	  
	    	}
	    }  
	    return true; 
	}  
	
	
}