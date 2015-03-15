package com.syncworks.smartlight;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.syncworks.define.Define;
import com.syncworks.dragndroplist.DragSortController;
import com.syncworks.dragndroplist.DragSortListView;
import com.syncworks.scriptdata.ScriptData;
import com.syncworks.scriptdata.ScriptDataAdapter;
import com.syncworks.scriptdata.ScriptOperatorDialog;

import java.util.ArrayList;


public class CreateScriptActivity extends ActionBarActivity {
	private final static String TAG = CreateScriptActivity.class.getSimpleName();


	// DragNDrop ListView
	private DragSortListView dragSortListView;
	// DragNDrop 리스트 뷰 컨트롤러
	private DragSortController dragSortController;

	//스크립트 리스트
	private ArrayList<ScriptData> scriptList;
	//View 리스트
	private ScriptDataAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_script);
		dragSortListView = (DragSortListView) findViewById(R.id.script_list);
		dragSortController = buildController(dragSortListView);
		dragSortListView.setFloatViewManager(dragSortController);
		dragSortListView.setOnTouchListener(dragSortController);
		dragSortListView.setDragEnabled(true);
		dragSortListView.setDropListener(onDrop);
		dragSortListView.setRemoveListener(onRemove);

		scriptList = new ArrayList<>();
		scriptList.add(new ScriptData(Define.OP_START,5));
		scriptList.add(new ScriptData(50,0));
		scriptList.add(new ScriptData(100,0));
		scriptList.add(new ScriptData(Define.OP_END,0));
		adapter = new ScriptDataAdapter(this, 0, scriptList);
		dragSortListView.setAdapter(adapter);

		dragSortListView.setOnItemClickListener(onItemClickListener);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_create_script, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * 리스트 뷰에서 아이템 클릭시 호출
	 */
	private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		}
	};

	public DragSortController buildController(DragSortListView dslv) {
		// defaults are
		//   dragStartMode = onDown
		//   removeMode = flingRight
		DragSortController controller = new DragSortController(dslv);
		controller.setDragHandleId(R.id.drag_handle);
		controller.setClickRemoveId(R.id.click_remove);
		controller.setRemoveEnabled(false);
		controller.setSortEnabled(true);
		controller.setDragInitMode(DragSortController.ON_LONG_PRESS);
		controller.setRemoveMode(DragSortController.FLING_REMOVE);
		return controller;
	}

	private DragSortListView.DropListener onDrop = new DragSortListView.DropListener() {

		@Override
		public void drop(int from, int to) {
			if (from != to) {
				/*LedData item = adapter.getItem(from);
				adapter.remove(item);
				adapter.insert(item, to);*/
			}
		}
	};

	private DragSortListView.RemoveListener onRemove = new DragSortListView.RemoveListener() {

		@Override
		public void remove(int which) {
			/*adapter.remove(adapter.getItem(which));*/
		}
	};

	public void scriptClick(View v) {
		switch (v.getId()) {
			case R.id.btn_script_load:
				break;
			case R.id.btn_script_add:
				showOperatorDialog();
				break;
			case R.id.btn_script_save:
				break;
		}
	}

	private void showOperatorDialog() {
		final ScriptOperatorDialog dialog = new ScriptOperatorDialog(this);
		dialog.setOnScriptOperateListener(new ScriptOperatorDialog.ScriptOperateListener() {
			@Override
			public void onSetOperateListener(int position) {
				Log.d(TAG,"Click:"+position );
				dialog.dismiss();
			}
		});
		dialog.show();
	}
}
