package com.yahoo.example.week1todoapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class TodoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo);
	}

	public void onAddItem(View v) {
		// TODO Auto-generated method stub
		Toast.makeText(getBaseContext(), "Hello World", Toast.LENGTH_SHORT).show();
	}

}
