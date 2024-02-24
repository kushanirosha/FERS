package com.example.fuelexpensesrecordingsystem;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

public class vehical_details_activity extends Activity {
	
	private View _bg__vehical_details;
	private ImageView rectangle_5;
	private View rectangle_6;
	private EditText rectangle_6_ek1;
	private EditText rectangle_14;
	private EditText rectangle_7;
	private EditText rectangle_17;
	private ImageView icons8_sort_down_50_1;
	private View rectangle_13;
	private View rectangle_15;
	private TextView vehicle_number;
	private TextView date_;
	private TextView vehicle_type;
	private TextView vehicle_mileage_meter;
	private TextView next;
	private TextView filling_details;
	private TextView vehicle_details;
	private TextView fuel_type;
	private View line_1;
	private View line_2;
	private TextView pertol;
	private View rectangle_16;
	private TextView desel;
	private TextView fuel_expenses_recording_system;
	private ImageView image_2;
	private Calendar selectedDate;
	private Spinner spinnerOptions;
	private TextView textViewError;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.vehical_details);
		
		_bg__vehical_details = (View) findViewById(R.id._bg__vehical_details);
		rectangle_5 = (ImageView) findViewById(R.id.rectangle_5);
		rectangle_6 = (View) findViewById(R.id.rectangle_6);
		rectangle_6_ek1 = (EditText) findViewById(R.id.rectangle_6_ek1);
		rectangle_14 = (EditText) findViewById(R.id.rectangle_14);
		rectangle_7 = (EditText) findViewById(R.id.rectangle_7);
		rectangle_17 = (EditText) findViewById(R.id.rectangle_17);
		icons8_sort_down_50_1 = (ImageView) findViewById(R.id.icons8_sort_down_50_1);
		rectangle_13 = (View) findViewById(R.id.rectangle_134);
		rectangle_15 = (View) findViewById(R.id.rectangle_15);
		vehicle_number = (TextView) findViewById(R.id.vehicle_number);
		date_ = (TextView) findViewById(R.id.date_);
		vehicle_type = (TextView) findViewById(R.id.vehicle_type);
		vehicle_mileage_meter = (TextView) findViewById(R.id.vehicle_mileage_meter);
		next = (TextView) findViewById(R.id.next);
		filling_details = (TextView) findViewById(R.id.filling_detailss);
		vehicle_details = (TextView) findViewById(R.id.vehicle_details);
		fuel_type = (TextView) findViewById(R.id.fuel_type);
		line_1 = (View) findViewById(R.id.line_1);
		line_2 = (View) findViewById(R.id.line_2);
		pertol = (TextView) findViewById(R.id.pertol);
		rectangle_16 = (View) findViewById(R.id.rectangle_16);
		desel = (TextView) findViewById(R.id.desel);
		fuel_expenses_recording_system = (TextView) findViewById(R.id.fuel_expenses_recording_system);
		image_2 = (ImageView) findViewById(R.id.image_2);
		spinnerOptions = findViewById(R.id.spinnerOptions);
		textViewError = (TextView) findViewById(R.id.textViewError);


		//Go to filling details page
		TextView textView = findViewById(R.id.filling_detailss);
		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(vehical_details_activity.this,filling_details_activity.class);
				startActivity(intent);
			}
		});

		View view = findViewById(R.id.line_2);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(vehical_details_activity.this,filling_details_activity.class);
				startActivity(intent);
			}
		});

		// Get the current date
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
			String currentDate = dateFormat.format(calendar.getTime());

			rectangle_7.setText(currentDate);


		//Date Picker
		image_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				showDatePickerDialog();
			}
		});


		//DropDown Option
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.options_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

		adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);

		spinnerOptions.setAdapter(adapter);

		icons8_sort_down_50_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				spinnerOptions.performClick();
			}
		});
		spinnerOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selectedOption = parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
			}
		});


		// select petrol and diesel
		View view2 = findViewById(R.id.rectangle_15);
		view2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rectangle_15.setBackgroundResource(R.drawable.rectangle_14_shape);
				rectangle_16.setBackgroundResource(R.drawable.rectangle_15_shape);
			}
		});
		View view3 = findViewById(R.id.rectangle_16);
		view3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				rectangle_16.setBackgroundResource(R.drawable.rectangle_14_shape);
				rectangle_15.setBackgroundResource(R.drawable.rectangle_15_shape);
			}
		});

		//data passing
		rectangle_13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String dataa = rectangle_6_ek1.getText().toString();
				String datab = rectangle_14.getText().toString();
				String data = dataa + datab;

				String data1 = rectangle_7.getText().toString();
				String data2 = spinnerOptions.getSelectedItem().toString();
				String data3 = rectangle_17.getText().toString();

				int rectangleBackgroundResource = R.drawable.rectangle_14_shape;
				int currentBackgroundResource = getBackgroundResource(rectangle_15);
				int currentBackgroundResource1 = getBackgroundResource(rectangle_16);

				if (TextUtils.isEmpty(dataa) || TextUtils.isEmpty(datab) || TextUtils.isEmpty(data1) || TextUtils.isEmpty(data2) || TextUtils.isEmpty(data3)) {
					textViewError.setText("Please fill the all fields!");
					textViewError.setVisibility(View.VISIBLE);

				} else {
					if (currentBackgroundResource == rectangleBackgroundResource) {
						String data41 = "pertol";
						Intent intent = new Intent(vehical_details_activity.this, filling_details_activity.class);
						intent.putExtra("data41", data41);
					}

					if (currentBackgroundResource1 == rectangleBackgroundResource) {
						String data42 = "Desel";
						Intent intent = new Intent(vehical_details_activity.this, filling_details_activity.class);
						intent.putExtra("data42", data42);
					}

					Intent intent = new Intent(vehical_details_activity.this, filling_details_activity.class);

					intent.putExtra("data", data);
					intent.putExtra("data1", data1);
					intent.putExtra("data2", data2);
					intent.putExtra("data3", data3);

					startActivity(intent);

					rectangle_6_ek1.setText("");
					rectangle_14.setText("");
					rectangle_7.setText(currentDate);
					spinnerOptions.setAdapter(adapter);
					rectangle_17.setText("");

				}
			}
		});

	}

	//Calender View
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
			rectangle_7.setText(dateFormat1.format(selectedDate.getTime()));
		}
	}

	//get background resource id
	private int getBackgroundResource(View view) {
		int backgroundResource = 0;
		try {
			backgroundResource = ((RippleDrawable) view.getBackground()).getDrawable(0).getConstantState().hashCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return backgroundResource;
	}

}


	
	