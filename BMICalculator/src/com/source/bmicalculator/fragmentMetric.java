package com.source.bmicalculator;

import com.source.bmicalculator.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class fragmentMetric extends Fragment {
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	EditText editHeight;
	EditText editWeight;
	Button calculate;
	TextView BMIvalue, categoryValue;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_metric , container, false);
		
		// find controls from fragment 
		editHeight = (EditText) view.findViewById(R.id.txtHeight);
		editWeight = (EditText) view.findViewById(R.id.txtWeight);
		calculate = (Button) view.findViewById(R.id.btnCalc);
		BMIvalue = (TextView) view.findViewById(R.id.txtBMIvalue);
		categoryValue = (TextView) view.findViewById(R.id.txtCategoryValue);
		
		// Calculate the BMI in metric units upon clicking the button 
		calculate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String sHeight = editHeight.getText().toString();
				String sWeight = editWeight.getText().toString();
				if(sHeight.matches("")){
					Toast.makeText(getActivity(), "Enter Height Value", 
							Toast.LENGTH_SHORT).show();
				}
				if(sWeight.matches("")){
					Toast.makeText(getActivity(), "Enter Weight Value", 
							Toast.LENGTH_SHORT).show();
				}
				
				try{
					double height = Double.parseDouble(sHeight);
					double weight = Double.parseDouble(sWeight);
					
					// convert height in Metres 
					height = height / 100;
					// Square the Height
					double finalHeight = height * height;
					
					double BMI = weight / finalHeight;
					BMI = Math.round(BMI * 100.0) / 100.0;
					BMIvalue.setText(String.valueOf(BMI));
					
					// Changes resultant text color based on range value
					if(BMI > 40){
						categoryValue.setText("Obese Class III");
						categoryValue.setTextColor(Color.RED);
					}
					else if(BMI > 35){
						categoryValue.setText("Obese Class II");
						categoryValue.setTextColor(Color.RED);
					}
					else if(BMI > 30){
						categoryValue.setText("Obese Class I");
						categoryValue.setTextColor(Color.MAGENTA);
					}
					else if(BMI > 25){
						categoryValue.setText("Overweight");
						categoryValue.setTextColor(Color.MAGENTA);
					}
					else if(BMI > 18.5){
						categoryValue.setText("Normal");
						categoryValue.setTextColor(Color.parseColor("#088A08"));
					}
					else if(BMI > 16){
						categoryValue.setText("Underweight");
						categoryValue.setTextColor(Color.MAGENTA);
					}
					else if(BMI > 15){
						categoryValue.setText("Severely Underweight");
						categoryValue.setTextColor(Color.RED);
					}
					else{
						categoryValue.setText("Very Severely Underweight");
						categoryValue.setTextColor(Color.RED);
					}
				}
				catch(NumberFormatException e){
					Log.d("BMI", "Number Format Exception");
				}
			}
		});

		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}
	
	@Override
	public void onStop() {
		super.onStop();
	}
	
	
}
