package com.example.testDS;

import android.test.AndroidTestCase;
import android.util.Log;

import com.ytt.datastructure.SingleList;

public class SingleListTest extends AndroidTestCase{
	private String tag="SingleListTest";
	public void main(String[] args) {
		String[] testStrings={"A","B","C","D"};
		SingleList<String> mSingleListlist=new SingleList<String>(testStrings);
		
		if (mSingleListlist.isEmpty()) {
			Log.d(tag, "list is empty");
		}
		
		System.out.println(mSingleListlist);
	}	
}
