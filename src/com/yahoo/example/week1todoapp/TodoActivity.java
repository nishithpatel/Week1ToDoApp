package com.yahoo.example.week1todoapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class TodoActivity extends Activity {
	
	private ArrayList<String> todoItems;
	private ArrayAdapter<String> todoAdapter;
	private ListView lvToDoList;
	private EditText etNewItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo);
		etNewItem = (EditText) findViewById(R.id.etNewItem);
		lvToDoList = (ListView) findViewById(R.id.lvToDoList);
		readItems();
		todoAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, todoItems);
		lvToDoList.setAdapter(todoAdapter);
		setupListViewListener();
	}

	private void setupListViewListener() {
		// TODO Auto-generated method stub
		lvToDoList.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
				todoItems.remove(pos);
				todoAdapter.notifyDataSetChanged();
				writeItems();
				return false;
			}
			
		});
	}
	
	public void addNewItem(View v) {
		// TODO Auto-generated method stub
		String newItemText = etNewItem.getText().toString();
		todoAdapter.add(newItemText);
		etNewItem.setText("");
		writeItems();
	}
	
	private void readItems() {
		
		File fileDir = getFilesDir();
		File todoFile = new File(fileDir, "todo.txt");
		try {
			todoItems = new ArrayList<String>(FileUtils.readLines(todoFile));
		} catch (IOException io) {
			todoItems = new ArrayList<String>();
		}
	}
	
	private void writeItems() {
		
		File fileDir = getFilesDir();
		File todoFile = new File(fileDir, "todo.txt");
		try {
			FileUtils.writeLines(todoFile, todoItems);
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

}
