package com.example.fuelexpensesrecordingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;

public class login_page_activity extends Activity {

	private View _bg__login_page;
	private ImageView rectangle_5;
	private TextView fogot_password;
	private TextView phoneNumberTextView;
	private View rectangle_3;
	private TextView login;
	private TextView login_ek1;
	private TextView fuel_expenses_recording_system;
	private TextView user_name;
	private TextView password;
	private TextView textViewError;
	private boolean isPasswordVisible = false;

	private static final List<Pair<String, String>> VALID_CREDENTIALS = new ArrayList<Pair<String, String>>() {{
		add(new Pair<>("NA4551", "Em0001"));
		add(new Pair<>("ABC2671", "Em0002"));
		add(new Pair<>("BBC3227", "Em0003"));
	}};


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_page);

		_bg__login_page = (View) findViewById(R.id._bg__login_page);
		rectangle_5 = (ImageView) findViewById(R.id.rectangle_5);
		fogot_password = (TextView) findViewById(R.id.fogot_password__hot_line__011_2345678);
		rectangle_3 = (View) findViewById(R.id.rectangle_3);
		login = (TextView) findViewById(R.id.login);
		login_ek1 = (TextView) findViewById(R.id.login_ek1);
		password = (EditText) findViewById(R.id.rectangle_5_ek1);
		user_name= (EditText) findViewById(R.id.rectangle_6);
		fuel_expenses_recording_system = (TextView) findViewById(R.id.fuel_expenses_recording_system);
		textViewError = (TextView) findViewById(R.id.textViewError);
		phoneNumberTextView = (TextView) findViewById(R.id.phoneNumberTextView);

			View view = findViewById(R.id.rectangle_3);
			view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					String userName = user_name.getText().toString();
					String data8 = password.getText().toString();
					boolean isValid = false;

					for (Pair<String, String> pair : VALID_CREDENTIALS) {
						if (userName.equals(pair.first) && data8.equals(pair.second)) {
							isValid = true;
							break;
						}
					}

					if(isValid) {
						Intent intent = new Intent(login_page_activity.this, main_menu_activity.class);
						startActivity(intent);

						Intent intent2 = new Intent(login_page_activity.this, filling_details_activity.class);
						intent2.putExtra("data8", data8);

						user_name.setText("");
						password.setText("");
						textViewError.setVisibility(View.GONE);

					}else {
						textViewError.setText("Invalid username or password.");
						textViewError.setVisibility(View.VISIBLE);

					}
				}
			});

		//hot line call
		phoneNumberTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:0710836990"));
				startActivity(intent);
			}
		});

	}
}
	
	