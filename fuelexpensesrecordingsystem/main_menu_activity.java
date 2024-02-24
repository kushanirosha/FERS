package com.example.fuelexpensesrecordingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class main_menu_activity extends Activity {
	
	private View _bg__main_menu;
	private ImageView rectangle_5;
	private View rectangle_6;
	private View rectangle_6_ek1;
	private View rectangle_14;
	private View rectangle_13;
	private TextView fuel_filling;
	private TextView view_log;
	private TextView fuel_expenses_recording_system;
	private TextView sign_out;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);

		
		_bg__main_menu = (View) findViewById(R.id._bg__main_menu);
		rectangle_5 = (ImageView) findViewById(R.id.rectangle_5);
		rectangle_6 = (View) findViewById(R.id.rectangle_6);
		rectangle_6_ek1 = (View) findViewById(R.id.rectangle_6_ek1);
		rectangle_14 = (View) findViewById(R.id.rectangle_14);
		rectangle_13 = (View) findViewById(R.id.rectangle_13);
		fuel_filling = (TextView) findViewById(R.id.fuel_filling);
		view_log = (TextView) findViewById(R.id.view_log);
		fuel_expenses_recording_system = (TextView) findViewById(R.id.fuel_expenses_recording_system);
		sign_out = (TextView) findViewById(R.id.sign_out);
	
		View view = findViewById(R.id.rectangle_6_ek1);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(main_menu_activity.this,vehical_details_activity.class);
				startActivity(intent);
			}
		});

		View view2 = findViewById(R.id.rectangle_14);
		view2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(main_menu_activity.this,view_log_activity.class);
				startActivity(intent);
			}
		});

		View view1 = findViewById(R.id.rectangle_13);
		view1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(main_menu_activity.this,main_page_activity.class);
				startActivity(intent);
			}
		});
	
	}
}
	
	