package com.example.fuelexpensesrecordingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class filling_details_activity extends Activity {

	private View _bg__filling_details;
	private ImageView rectangle_5;
	private View rectangle_6;
	private EditText rectangle_18;
	private EditText rectangle_19;
	private EditText rectangle_17;
	private View rectangle_13;
	private TextView price_per_leater;
	private TextView quntity;
	private TextView cost_of_filling;
	private TextView upload_bill_image;
	private TextView submit;
	private TextView filling_details;
	private TextView vehicle_details;
	private View line_1;
	private View line_2;
	private TextView fuel_expenses_recording_system;
	private TextView rs_;
	private TextView rs__ek1;
	private TextView leaters_;
	private View rectangle_18_ek1;
	private TextView upload_images;
	private DecimalFormat decimalFormatInput;
	private DecimalFormat decimalFormatResult;
	private static final int REQUEST_CAMERA_PERMISSION = 100;
	private static final int REQUEST_IMAGE_CAPTURE = 101;
	private ImageView imagePreview;
	private TextView textViewError;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.filling_details);

		_bg__filling_details = (View) findViewById(R.id._bg__filling_details);
		rectangle_5 = (ImageView) findViewById(R.id.rectangle_5);
		rectangle_6 = (View) findViewById(R.id.rectangle_6);
		rectangle_18 = (EditText) findViewById(R.id.rectangle_18);
		rectangle_19 = (EditText) findViewById(R.id.rectangle_19);
		rectangle_17 = (EditText) findViewById(R.id.rectangle_17);
		rectangle_13 = (View) findViewById(R.id.rectangle_133);
		price_per_leater = (TextView) findViewById(R.id.price_per_leater);
		quntity = (TextView) findViewById(R.id.quntity);
		cost_of_filling = (TextView) findViewById(R.id.cost_of_filling);
		upload_bill_image = (TextView) findViewById(R.id.upload_bill_image);
		submit = (TextView) findViewById(R.id.submit);
		filling_details = (TextView) findViewById(R.id.filling_detailss);
		vehicle_details = (TextView) findViewById(R.id.vehicle_detailss);
		line_1 = (View) findViewById(R.id.line_1);
		line_2 = (View) findViewById(R.id.line_2);
		fuel_expenses_recording_system = (TextView) findViewById(R.id.fuel_expenses_recording_system);
		rs_ = (TextView) findViewById(R.id.rs_);
		rs__ek1 = (TextView) findViewById(R.id.rs__ek1);
		leaters_ = (TextView) findViewById(R.id.leaters_);
		rectangle_18_ek1 = (View) findViewById(R.id.rectangle_18_ek1);
		upload_images = (TextView) findViewById(R.id.upload_images);
		imagePreview = (ImageView) findViewById(R.id.imagePreview);
		textViewError = (TextView) findViewById(R.id.textViewError);

		//Go to vehical details page
		TextView textView = findViewById(R.id.vehicle_detailss);
		textView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(filling_details_activity.this,vehical_details_activity.class);
				startActivity(intent);
			}
		});
		View view = findViewById(R.id.line_1);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(filling_details_activity.this,vehical_details_activity.class);
				startActivity(intent);
			}
		});


		View view2 =findViewById(R.id.rectangle_133);
		view2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(filling_details_activity.this,notification_page_activity.class);
				startActivity(intent);
			}
		});


		//calculation
		decimalFormatInput = new DecimalFormat("0.00");
		decimalFormatResult = new DecimalFormat("0.000");

		rectangle_17.addTextChangedListener(textWatcher);
		rectangle_18.addTextChangedListener(textWatcher);


		//Camera openning
		rectangle_18_ek1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (checkCameraPermission()) {
					capturePhoto();
				} else {
					requestCameraPermission();
				}
			}
		});


		//Data uploaded and successful page
		rectangle_13.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				// Receive data from the previous activity
				Intent intent = getIntent();
				String data = intent.getStringExtra("data");
				String data1 = intent.getStringExtra("data1");
				String data2 = intent.getStringExtra("data2");
				String data3 = intent.getStringExtra("data3");
				String data41 = intent.getStringExtra("data41");
				String data42 = intent.getStringExtra("data42");
				String data8 = intent.getStringExtra("data8");

				String data5 = rectangle_18.getText().toString();
				String data6 = rectangle_19.getText().toString();
				String data7 = rectangle_17.getText().toString();

				if (TextUtils.isEmpty(data5) || TextUtils.isEmpty(data6) || TextUtils.isEmpty(data7)) {
					textViewError.setText("Please fill the all fields!");
					textViewError.setVisibility(View.VISIBLE);

				} else {
					RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
					String url = "http://192.168.8.121/fuel_expenses_records/upload.php";

					StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
							new Response.Listener<String>() {
								@Override
								public void onResponse(String response) {
									if (response.equals("Successfully added the data")) {
										Toast.makeText(filling_details_activity.this, "Data added", Toast.LENGTH_SHORT).show();
									} else
										Toast.makeText(filling_details_activity.this, response, Toast.LENGTH_LONG).show();
								}
							}, new Response.ErrorListener() {
						@Override
						public void onErrorResponse(VolleyError error) {
							Log.e("Error", error.getLocalizedMessage());
						}
					}) {
						protected Map<String, String> getParams() {
							Map<String, String> paramV = new HashMap<>();
							paramV.put("data", data);
							paramV.put("data1", data1);
							paramV.put("data2", data2);
							paramV.put("data3", data3);
							paramV.put("data41", data41);
							paramV.put("data42", data42);
							paramV.put("data5", data5);
							paramV.put("data6", data6);
							paramV.put("data7", data7);
							paramV.put("data8", data8);

							return paramV;
						}
					};
					queue.add(stringRequest);

					//Go next page
					Intent intent1 = new Intent(filling_details_activity.this, notification_page_activity.class);
					startActivity(intent1);

					rectangle_18.setText("");
					rectangle_19.setText("");
					rectangle_17.setText("");

				}
			}
		});

	}

	//calculation
	private final TextWatcher textWatcher = new TextWatcher() {
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
		}

		@Override
		public void afterTextChanged(Editable s) {
			calculateResult();
		}
	};
	private void calculateResult(){
		String value1Str = rectangle_17.getText().toString();
		String value2Str = rectangle_18.getText().toString();

		if (!value1Str.isEmpty() && !value2Str.isEmpty()) {
			double value1 = Double.parseDouble(value1Str);
			double value2 = Double.parseDouble(value2Str);

			double result = value1 / value2;
			String formattedResult = decimalFormatResult.format(result);

			rectangle_19.setText(formattedResult);
		} else {
			rectangle_19.setText("");
		}
	}

	//camera openning
	private boolean checkCameraPermission() {
		return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
				== PackageManager.PERMISSION_GRANTED;
	}

	private void requestCameraPermission() {
		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
	}

	private void capturePhoto() {
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			Bitmap imageBitmap = (Bitmap) extras.get("data");
			imagePreview.setImageBitmap(imageBitmap);

			// Save the captured photo to storage
			saveImageToStorage(imageBitmap);
		}
	}

	private void saveImageToStorage(Bitmap bitmap) {
		String filename = "captured_image.jpg";
		File file = new File(getExternalFilesDir(null), filename);

		try (FileOutputStream fos = new FileOutputStream(file)) {
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
			Toast.makeText(this, "Image saved to " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			e.printStackTrace();
			Toast.makeText(this, "Failed to save image", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == REQUEST_CAMERA_PERMISSION) {
			if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				capturePhoto();
			} else {
				Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show();
			}
		}
	}

}

	
	