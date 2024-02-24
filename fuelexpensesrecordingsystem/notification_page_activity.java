package com.example.fuelexpensesrecordingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class notification_page_activity extends Activity {

	
	private View _bg__notification_page;
	private TextView your_filling_details_are_successfully_added_;
	private ImageView rectangle_14;
	private View rectangle_14_ek1;
	private View rectangle_15;
	private TextView go_main_menu;
	private TextView sign_out;
	private TextView fuel_expenses_recording_system;
	private ImageView image_4;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_page);

		
		_bg__notification_page = (View) findViewById(R.id._bg__notification_page);
		your_filling_details_are_successfully_added_ = (TextView) findViewById(R.id.your_filling_details_are_successfully_added_);
		rectangle_14 = (ImageView) findViewById(R.id.rectangle_14);
		rectangle_14_ek1 = (View) findViewById(R.id.rectangle_14_ek1);
		rectangle_15 = (View) findViewById(R.id.rectangle_15);
		go_main_menu = (TextView) findViewById(R.id.go_main_menu);
		sign_out = (TextView) findViewById(R.id.sign_out);
		fuel_expenses_recording_system = (TextView) findViewById(R.id.fuel_expenses_recording_system);
		image_4 = (ImageView) findViewById(R.id.image_4);
	

		View view = findViewById(R.id.rectangle_14_ek1);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(notification_page_activity.this,main_menu_activity.class);
				startActivity(intent);
			}
		});

		View view1 = findViewById(R.id.rectangle_15);
		view1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(notification_page_activity.this,main_page_activity.class);
				startActivity(intent);
			}
		});

	}
}
	
	