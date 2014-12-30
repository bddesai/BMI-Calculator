package com.source.bmicalculator;

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

public class fragmentBritish extends Fragment{
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	EditText editFeet, editInches;
	EditText editStones, editPounds;
	Button calculate;
	TextView BMIvalue, categoryValue;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_british , container, false);

		// find controls from fragment 
		editFeet = (EditText) view.findViewById(R.id.txtBFeet);
		editInches = (EditText) view.findViewById(R.id.txtBInches);
		editStones = (EditText) view.findViewById(R.id.txtStones);
		editPounds = (EditText) view.findViewById(R.id.txtPounds);
		calculate = (Button) view.findViewById(R.id.btnCalc);
		BMIvalue = (TextView) view.findViewById(R.id.txtBMIvalue);
		categoryValue = (TextView) view.findViewById(R.id.txtCategoryValue);
		
		// Calculate the BMI in British units upon clicking the button
		calculate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String shFeet = editFeet.getText().toString();
				String shInches = editInches.getText().toString();
				String sStones = editStones.getText().toString();
				String sPounds = editPounds.getText().toString();
				if(shFeet.matches("")){
					Toast.makeText(getActivity(), "Enter Feet Value", 
							Toast.LENGTH_SHORT).show();
				}
				if(shInches.matches("")){
					Toast.makeText(getActivity(), "Enter Inches Value \n [0 if N.A.]", 
							Toast.LENGTH_SHORT).show();
				}
				
				if(sStones.matches("")){
					Toast.makeText(getActivity(), "Enter Stones Value", 
							Toast.LENGTH_SHORT).show();
				}
				if(sPounds.matches("")){
					Toast.makeText(getActivity(), "Enter Pounds Value \n [0 if N.A]", 
							Toast.LENGTH_SHORT).show();
				}
				
				try{
					double feet = Double.parseDouble(shFeet);
					double inches = Double.parseDouble(shInches);
					
					// Convert Height in Metres
					double heightinMT = ((feet*12)+inches) * 0.025;
					double height = heightinMT * heightinMT;
					
					// Convert Stones to Pounds and than finally to KG 
					double stones = Double.parseDouble(sStones);
					double pounds = Double.parseDouble(sPounds);
					
					double totalpounds = (stones*14) + pounds;
					double weightinKG = totalpounds * 0.45;
					
					// Calculate BMI 
					double BMI = weightinKG / height;
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
