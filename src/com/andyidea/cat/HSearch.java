package com.andyidea.cat;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import java.util.ArrayList;     
import java.util.List;       
import android.view.MotionEvent;     
import android.view.View;     
import android.view.View.OnClickListener;
import android.widget.AdapterView;     
import android.widget.ArrayAdapter;     
import android.widget.Button;
import android.widget.Spinner;     
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

public class HSearch extends Activity{
//////搜索栏部分//////////////////////////////////////////////////////////////////////////
	//搜索类别更改
	private List<String> clist = new ArrayList<String>();
	private TextView cTextView;
	private Spinner cSpinner;
	private ArrayAdapter<String> cadapter;
    //排列关键更改
	private List<String> slist = new ArrayList<String>();
	private TextView sTextView;
	private Spinner sSpinner;
	private ArrayAdapter<String> sadapter;
    //活动分类更改
	private List<String> flist = new ArrayList<String>();
	private TextView fTextView;
	private Spinner fSpinner;
	private ArrayAdapter<String> fadapter;
	
/////结果部分/////////////////////////////////////////////////////////////////////////////
	OnClickListener lis11111 = null;
	Button but11111;	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hsearch);
///////搜索栏部分//////////////////////////////////////////////////////////////////////////	
		//搜索类别更改
		clist.add("活 动");
		clist.add("用 户");
		clist.add("主办方");
		clist.add("竞 赛");
		
		cTextView = (TextView)findViewById(R.id.classifytext);
		cSpinner = (Spinner)findViewById(R.id.classifyspinner);
		
		cadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,clist);
		cadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		cSpinner.setAdapter(cadapter);
		cSpinner.setOnItemSelectedListener(
				new OnItemSelectedListener(){
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
					cTextView.setText(cadapter.getItem(position));
					}
					public void onNothingSelected(AdapterView<?> parent) {                        
                    }
				});

		
		//排列关键更改
		slist.add("热门");
		slist.add("最新");
		slist.add("按参与数排序");
		slist.add("按评论数排序");
		slist.add("随便看看");
		sTextView = (TextView)findViewById(R.id.sorttext);
		sSpinner = (Spinner)findViewById(R.id.sortspinner);
		
		sadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,slist);
		sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sSpinner.setAdapter(sadapter);
		sSpinner.setOnItemSelectedListener(
				new OnItemSelectedListener(){
					public void onItemSelected(AdapterView<?> parent, View views, int position, long id){
						sTextView.setText(sadapter.getItem(position));
					}
					public void onNothingSelected(AdapterView<?> parent) {                        
                    }
				});
		
		
		
	    //活动分类更改
		//排列关键更改
		flist.add("全部");
		flist.add("正在进行");
		flist.add("报名中");
		flist.add("即将进行");
		flist.add("已完成");
		fTextView = (TextView)findViewById(R.id.screentext);
		fSpinner = (Spinner)findViewById(R.id.screenspinner);
		
		fadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,flist);
		fadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		fSpinner.setAdapter(fadapter);
		fSpinner.setOnItemSelectedListener(
				new OnItemSelectedListener(){
					public void onItemSelected(AdapterView<?> parent, View views, int position, long id){
						fTextView.setText(fadapter.getItem(position));
					}
					public void onNothingSelected(AdapterView<?> parent) {                        
                    }
				});
		
////////结果部分//////////////////////////////////////////////////////////////////////////////////////////////
		lis11111 = new OnClickListener(){
			public void onClick(View v) {				
				Intent x = new Intent();
				x.setClass(HSearch.this, HAction.class);
				startActivity(x);
			}
		};
		but11111 = (Button)findViewById(R.id.actiononlist);
		but11111.setOnClickListener(lis11111);
		

	}
	
}
