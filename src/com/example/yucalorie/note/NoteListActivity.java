package com.example.yucalorie.note;

import com.example.yucalorie.R;
import com.example.yucalorie.core.CalorieManager;
import com.example.yucalorie.core.CalorieSQLite;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class NoteListActivity extends Activity{

	ListView mListView;
	NoteAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.setContentView(R.layout.note_list);
		
		mListView=(ListView)this.findViewById(R.id.note_listview);
		mAdapter=new NoteAdapter(this);
		CalorieManager.SQLite.LoadNoteList(mAdapter);
		this.mListView.setAdapter(mAdapter);

		super.onCreate(savedInstanceState);
	}

}
