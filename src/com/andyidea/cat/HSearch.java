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
//////����������//////////////////////////////////////////////////////////////////////////
	//����������
	private List<String> clist = new ArrayList<String>();
	private TextView cTextView;
	private Spinner cSpinner;
	private ArrayAdapter<String> cadapter;
    //���йؼ�����
	private List<String> slist = new ArrayList<String>();
	private TextView sTextView;
	private Spinner sSpinner;
	private ArrayAdapter<String> sadapter;
    //��������
	private List<String> flist = new ArrayList<String>();
	private TextView fTextView;
	private Spinner fSpinner;
	private ArrayAdapter<String> fadapter;
	
/////�������/////////////////////////////////////////////////////////////////////////////
	OnClickListener lis11111 = null;
	Button but11111;	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hsearch);
///////����������//////////////////////////////////////////////////////////////////////////	
		//����������
		clist.add("�� ��");
		clist.add("�� ��");
		clist.add("���췽");
		clist.add("�� ��");
		
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

		
		//���йؼ�����
		slist.add("����");
		slist.add("����");
		slist.add("������������");
		slist.add("������������");
		slist.add("��㿴��");
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
		
		
		
	    //��������
		//���йؼ�����
		flist.add("ȫ��");
		flist.add("���ڽ���");
		flist.add("������");
		flist.add("��������");
		flist.add("�����");
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
		
////////�������//////////////////////////////////////////////////////////////////////////////////////////////
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
