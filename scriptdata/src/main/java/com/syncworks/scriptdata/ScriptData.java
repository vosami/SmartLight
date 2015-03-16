package com.syncworks.scriptdata;

/**
 * Created with Android Studio
 * Copyrights (C)SyncWorks All rights reserved by SyncWorks
 * Created by 승현 on 2015-03-15.
 */
public class ScriptData {
	public final static boolean SINGLE_SCRIPT = true;
	public final static boolean DOUBLE_SCRIPT = false;
	private boolean _size;
	private int _val;
	private int _duration;
	private int _data1;
	private int _data2;
	public ScriptData (int val, int duration) {
		_size = SINGLE_SCRIPT;
		_val = val;
		_duration = duration;
		_data1 = 0;
		_data2 = 0;
	}

	public ScriptData (int instruct, int data, int data1, int data2) {
		_size = DOUBLE_SCRIPT;
		_val = instruct;
		_duration = data;
		_data1 = data1;
		_data2 = data2;
	}

	public boolean getSize() {
		return _size;
	}

	public int getVal() {
		return _val;
	}

	public int getDuration() {
		return _duration;
	}

	public int getData1() {
		return _data1;
	}

	public int getData2() {
		return _data2;
	}
}
