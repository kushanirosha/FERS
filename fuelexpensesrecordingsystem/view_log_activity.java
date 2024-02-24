package com.example.fuelexpensesrecordingsystem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import java.util.Calendar;
import java.util.Locale;

public class view_log_activity extends Activity {

	private View _bg__view_log;
	private TextView view_log_t;
	private View rectangle_20;
	private ImageView rectangle_25;
	private ImageView rectangle_27;
	private ImageView rectangle_26;
	private TextView sign_out;
	private TextView go_main_menu;
	private EditText rectangle_20_ek1;
	private EditText rectangle_22;
	private EditText rectangle_21;
	private ImageView rectangle_24;
	private TextView search;
	private TextView vehicle_number;
	private ImageView image_4;
	private ImageView image_3;
	private TextView from_;
	private TextView to_;
	private Calendar selectedDate;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_log);

		_bg__view_log = (View) findViewById(R.id._bg__view_log);
		view_log_t = (TextView) findViewById(R.id.view_log_t);
		rectangle_20 = (View) findViewById(R.id.rectangle_20);
		rectangle_25 = (ImageView) findViewById(R.id.rectangle_25);
		rectangle_27 = (ImageView) findViewById(R.id.rectangle_27);
		rectangle_26 = (ImageView) findViewById(R.id.rectangle_26);
		sign_out = (TextView) findViewById(R.id.sign_out);
		go_main_menu = (TextView) findViewById(R.id.go_main_menu);
		rectangle_20_ek1 = (EditText) findViewById(R.id.rectangle_20_ek1);
		rectangle_22 = (EditText) findViewById(R.id.rectangle_22);
		rectangle_21 = (EditText) findViewById(R.id.rectangle_21);
		rectangle_24 = (ImageView) findViewById(R.id.rectangle_24);
		search = (TextView) findViewById(R.id.search);
		vehicle_number = (TextView) findViewById(R.id.vehicle_number);
		image_4 = (ImageView) findViewById(R.id.image_4);
		image_3 = (ImageView) findViewById(R.id.image_3);
		from_ = (TextView) findViewById(R.id.from_);
		to_ = (TextView) findViewById(R.id.to_);

		View view = findViewById(R.id.rectangle_27);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(view_log_activity.this,main_menu_activity.class);
				startActivity(intent);
			}
		});

		View view1 = findViewById(R.id.rectangle_26);
		view1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(view_log_activity.this,main_page_activity.class);
				startActivity(intent);
			}
		});

		// Get the current date
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
		String currentDate = dateFormat.format(calendar.getTime());

		rectangle_22.setText(currentDate);
		rectangle_21.setText(currentDate);


		//Date Picker
		image_4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				showDatePickerDialog();
			}
		});

		image_3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				showDatePickerDialog1();
			}
		});


	}

	//Calender View 1
	private void showDatePickerDialog(){
		final Calendar currentDate1 = Calendar.getInstance();

		DatePickerDialog datePickerDialog = new DatePickerDialog(
				this,
				new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
						selectedDate = Calendar.getInstance();
						selectedDate.set(Calendar.YEAR, year);
						selectedDate.set(Calendar.MONTH, monthOfYear);
						selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
						updateEditTextDate();
					}
				},
				currentDate1.get(Calendar.YEAR),
				currentDate1.get(Calendar.MONTH),
				currentDate1.get(Calendar.DAY_OF_MONTH));

		datePickerDialog.show();
	}
	private void updateEditTextDate() {
		if (selectedDate != null) {
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
			rectangle_22.setText(dateFormat1.format(selectedDate.getTime()));
		}
	}

	//Calender View 2
	private void showDatePickerDialog1(){
		final Calendar currentDate1 = Calendar.getInstance();

		DatePickerDialog datePickerDialog = new DatePickerDialog(
				this,
				new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
						selectedDate = Calendar.getInstance();
						selectedDate.set(Calendar.YEAR, year);
						selectedDate.set(Calendar.MONTH, monthOfYear);
						selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
						updateEditTextDate1();
					}
				},
				currentDate1.get(Calendar.YEAR),
				currentDate1.get(Calendar.MONTH),
				currentDate1.get(Calendar.DAY_OF_MONTH));

		datePickerDialog.show();
	}
	private void updateEditTextDate1() {
		if (selectedDate != null) {
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
			rectangle_21.setText(dateFormat1.format(selectedDate.getTime()));
		}
	}

}
	
	