package com.source.bmicalculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * @author Bhavin
 * The main activity which invokes all three fragments of 
 * Imperial, Metric and British Units 
 */
@SuppressLint("NewApi")
public class MainActivity extends ActionBarActivity{


	android.support.v4.app.FragmentManager manager;
	Button btnMetric, btnImperial, btnBritish;
		
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// find controls 
		btnMetric = (Button) findViewById(R.id.btnMetric);
		btnImperial = (Button) findViewById(R.id.btnImperial);
		btnBritish = (Button) findViewById(R.id.btnBritish);
		
		
		manager = getSupportFragmentManager();
		
		// set the default fragment 
		fragmentMetric fM = new fragmentMetric();
		android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.fragarea, fM, "Metric");
		transaction.commit();
	}

	/**
	 * @param v
	 * Invokes METRIC fragment and upon toggle, the tab color changes 
	 */
	public void showMetric(View v){
		btnMetric.setBackground(this.getResources().getDrawable(R.drawable.tab_active));
		btnMetric.setTextColor(Color.parseColor("#FFFFFF"));
		btnImperial.setBackground(this.getResources().getDrawable(R.drawable.tab_inactive));
		btnImperial.setTextColor(Color.parseColor("#000000"));
		btnBritish.setBackground(this.getResources().getDrawable(R.drawable.tab_inactive));
		btnBritish.setTextColor(Color.parseColor("#000000"));

		fragmentMetric fM = new fragmentMetric();
		android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.fragarea, fM, "Metric");
		transaction.commit();
		
	}
	
	/**
	 * @param v
	 * Invokes Imperial fragment and upon toggle, the tab color changes 
	 */
	public void showImperial(View v){
		btnImperial.setBackground(this.getResources().getDrawable(R.drawable.tab_active));
		btnImperial.setTextColor(Color.parseColor("#FFFFFF"));
		btnMetric.setBackground(this.getResources().getDrawable(R.drawable.tab_inactive));
		btnMetric.setTextColor(Color.parseColor("#000000"));
		btnBritish.setBackground(this.getResources().getDrawable(R.drawable.tab_inactive));
		btnBritish.setTextColor(Color.parseColor("#000000"));
		
		fragmentImperial fI = new fragmentImperial();
		android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.fragarea, fI, "Imperial");
		transaction.commit();
		
	}
	
	/**
	 * @param v
	 * Invokes British fragment and upon toggle, the tab color changes
	 */
	public void showBritish(View v){
		btnBritish.setBackground(this.getResources().getDrawable(R.drawable.tab_active));
		btnBritish.setTextColor(Color.parseColor("#FFFFFF"));
		btnMetric.setBackground(this.getResources().getDrawable(R.drawable.tab_inactive));
		btnMetric.setTextColor(Color.parseColor("#000000"));
		btnImperial.setBackground(this.getResources().getDrawable(R.drawable.tab_inactive));
		btnImperial.setTextColor(Color.parseColor("#000000"));
		
		fragmentBritish fB = new fragmentBritish();
		android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.fragarea, fB, "British");
		transaction.commit();
	}
}
