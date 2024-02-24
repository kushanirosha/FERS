package com.example.fuelexpensesrecordingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class main_page_activity extends Activity {


	private View _bg__main_page;
	private ImageView rectangle_1;
	private TextView fuel_expenses_recording_system;
	private ImageView rectangle_2;
	private TextView login;
	private ImageView image_1;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_page);


		_bg__main_page = (View) findViewById(R.id._bg__main_page);
		rectangle_1 = (ImageView) findViewById(R.id.rectangle_1);
		fuel_expenses_recording_system = (TextView) findViewById(R.id.fuel_expenses_recording_system);
		rectangle_2 = (ImageView) findViewById(R.id.rectangle_2);
		login = (TextView) findViewById(R.id.login);
		image_1 = (ImageView) findViewById(R.id.image_1);

		ImageView imageView = findViewById(R.id.rectangle_2);
		imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(main_page_activity.this,login_page_activity.class);
				startActivity(intent);

			}
		});

	
	}
}
	
	