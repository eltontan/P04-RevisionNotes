package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView listlist;
	ArrayAdapter aa;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView

		listlist = (ListView) this.findViewById(R.id.lv);


		DBHelper db = new DBHelper(SecondActivity.this);

		ArrayList<Note> newNote = new ArrayList<>();
		ArrayList<Note> data = db.getAllNotes();

		db.close();

		for (int i = 0; i < data.size(); i++) {
			newNote.add(data.get(i));
		}
		aa = new RevisionNotesArrayAdapter(this, R.layout.row, newNote);
		listlist.setAdapter(aa);
	}
}
