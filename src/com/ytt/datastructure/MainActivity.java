package com.ytt.datastructure;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.app.Activity;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private String tag="SingleListTest";
	private SingleList<String> mSingleListlist;

	private ListView listView;
	
	private String testGet(int index){		
		return mSingleListlist.get(index);
	}
	private SingleList<String> testCreate(){
		String[] strings={"A","B","C","D"};
		mSingleListlist=new SingleList<String>(strings);
		return mSingleListlist;
	}
	private void testInsert(){
		//mSingleListlist.insert(2,null);
		//mSingleListlist.insert(0, "E");
		//mSingleListlist.insert(4, "F");
		mSingleListlist.insert(5, "G");
		//mSingleListlist.insert(-1, "H");
		//mSingleListlist.insert(9, "I");
		
	}

	void testSearch(){
		String[] strings={"","A","D","F",null};
		for (int i = 0; i < strings.length; i++) {
			int index=mSingleListlist.search(strings[i]);
			if (index==-1) {
				Log.d(tag, "no such string");
			}else {
				Log.d(tag, "index of searched string is "+index);
			}
		}
		
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//setContentView(R.layout.activity_main);
		
		listView=new ListView(this);
		
		Cursor cursor=getContentResolver().query(People.CONTENT_URI,null, null, null, null);
		startManagingCursor(cursor);
		ListAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_2,
				cursor,
                new String[]{People.NAME,People.PRIMARY_PHONE_ID},
                new int[]{android.R.id.text1});
         
        listView.setAdapter(listAdapter);
        setContentView(listView);
		/*Button test=(Button)findViewById(R.id.testButton);
		testCreate();
		test.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				mSingleListlist.reverse3();
				String mString=getString(R.string.testString);
				String nString=getResources().getString(R.string.testString);
				String str=String.format("%s,%s", mString,nString);
				Log.d(tag,str);
				if (!mSingleListlist.isEmpty()) {
					
					Log.d(tag, "list length is "+mSingleListlist.length());
					for (int i = 0; i < mSingleListlist.length(); i++) {
						if (mSingleListlist.get(i)==null) {
							Log.d(tag, "get failed!");
						}else {
							Log.d(tag, mSingleListlist.get(i));				
						}
					}
					
				}
				
			}
		});*/
		

		
		/*List<String> strings=new ArrayList<String>();
		strings.add("line 1");
		strings.add("line 2");
		strings.add("line 3");
		strings.add("line 4");
		
		ListView mListView=(ListView)findViewById(R.id.mlist);
		ListAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings);
		mListView.setAdapter(adapter);*/
		
		}
}