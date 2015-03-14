package com.syncworks.libledselectlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import com.syncworks.define.Define;

/**
 * Created with Android Studio
 * Copyrights (C)SyncWorks All rights reserved by SyncWorks
 * Created by 승현 on 2015-03-07.
 * Smart Light 커넥터 선택 레이아웃
 */

// Some Changes
public class LedSelectLayout extends RelativeLayout{
	private final static String TAG = LedSelectLayout.class.getSimpleName();

	private CheckBox[] cbColor;
	private CheckBox[] cbSingle;
	/**
	 * 소스상에서 생성할 때 사용됨
	 * @param context 어플리케이션 정보 데이터
	 */
	public LedSelectLayout(Context context) {
		super(context);
		init(context,null);
	}

	/**
	 * xml 을 통해 생성할 때 사용됨
	 * @param context 어플리케이션 정보 데이터
	 * @param attrs attribute 확인
	 */
	public LedSelectLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context,attrs);
	}

	/**
	 * xml 을 통해 생성하면서 style 도 함께 적용되어 있다면 해당 생성자(Constructor) 가 호출
	 * @param context 어플리케이션 정보 데이터
	 * @param attrs attribute 확인
	 * @param defStyleAttr 스타일 인자(0이면 No style)
	 */
	public LedSelectLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context,attrs);
	}

	/**
	 * 레이아웃에서 사용되는 변수 초기화
	 * @param context
	 * @param attrs
	 */
	private void init(Context context, AttributeSet attrs) {

		// 레이아웃 Inflate
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.led_select_layout,this);

		// Smart Light 배경 색깔 적용
		int lecBackgroundColor = (int) getResources().getColor(R.color.LecBackground);
		this.setBackgroundColor(lecBackgroundColor);

		int[] idsColorLed = getResources().getIntArray(R.array.id_color_led);
		int[] idsSingleLed = getResources().getIntArray(R.array.id_single_led);

		cbColor = new CheckBox[Define.NUMBER_OF_COLOR_LED];
		cbSingle = new CheckBox[Define.NUMBER_OF_SINGLE_LED];

		cbColor[0] = (CheckBox) findViewById(R.id.id_color_led_1);
		cbColor[1] = (CheckBox) findViewById(R.id.id_color_led_2);
		cbColor[2] = (CheckBox) findViewById(R.id.id_color_led_3);

		cbColor[0].setOnClickListener(colorClickListener);
		cbColor[1].setOnClickListener(colorClickListener);
		cbColor[2].setOnClickListener(colorClickListener);

		cbColor[0].setOnLongClickListener(colorLongClickListener);
		cbColor[1].setOnLongClickListener(colorLongClickListener);
		cbColor[2].setOnLongClickListener(colorLongClickListener);

		cbSingle[0] = (CheckBox) findViewById(R.id.id_single_led_1);
		cbSingle[1] = (CheckBox) findViewById(R.id.id_single_led_2);
		cbSingle[2] = (CheckBox) findViewById(R.id.id_single_led_3);
		cbSingle[3] = (CheckBox) findViewById(R.id.id_single_led_4);
		cbSingle[4] = (CheckBox) findViewById(R.id.id_single_led_5);
		cbSingle[5] = (CheckBox) findViewById(R.id.id_single_led_6);
		cbSingle[6] = (CheckBox) findViewById(R.id.id_single_led_7);
		cbSingle[7] = (CheckBox) findViewById(R.id.id_single_led_8);
		cbSingle[8] = (CheckBox) findViewById(R.id.id_single_led_9);

		cbSingle[0].setOnClickListener(singleClickListener);
		cbSingle[1].setOnClickListener(singleClickListener);
		cbSingle[2].setOnClickListener(singleClickListener);
		cbSingle[3].setOnClickListener(singleClickListener);
		cbSingle[4].setOnClickListener(singleClickListener);
		cbSingle[5].setOnClickListener(singleClickListener);
		cbSingle[6].setOnClickListener(singleClickListener);
		cbSingle[7].setOnClickListener(singleClickListener);
		cbSingle[8].setOnClickListener(singleClickListener);

		cbSingle[0].setOnLongClickListener(singleLongClickListener);
		cbSingle[1].setOnLongClickListener(singleLongClickListener);
		cbSingle[2].setOnLongClickListener(singleLongClickListener);
		cbSingle[3].setOnLongClickListener(singleLongClickListener);
		cbSingle[4].setOnLongClickListener(singleLongClickListener);
		cbSingle[5].setOnLongClickListener(singleLongClickListener);
		cbSingle[6].setOnLongClickListener(singleLongClickListener);
		cbSingle[7].setOnLongClickListener(singleLongClickListener);
		cbSingle[8].setOnLongClickListener(singleLongClickListener);
	}

	private OnClickListener colorClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			((CheckBox)v).setChecked(false);
			int i = v.getId();
			setBtnSelected(i);
			if (i == R.id.id_color_led_1) {
				setBtnActivated(Define.SINGLE_LED_123_ACTIVATE, false);
			} else if (i == R.id.id_color_led_2) {
				setBtnActivated(Define.SINGLE_LED_456_ACTIVATE, false);
			} else if (i == R.id.id_color_led_3) {
				setBtnActivated(Define.SINGLE_LED_789_ACTIVATE, false);
			}
		}
	};

	private OnLongClickListener colorLongClickListener = new OnLongClickListener() {
		@Override
		public boolean onLongClick(View v) {
			int id = v.getId();
			if (((CheckBox)v).isChecked()) {
				((CheckBox)v).setChecked(false);
			} else if (!v.isSelected()) {
				setBtnChecked(id);
			}
			return true;
		}
	};

	private OnLongClickListener singleLongClickListener = new OnLongClickListener() {
		@Override
		public boolean onLongClick(View v) {
			return true;
		}
	};

	private OnClickListener singleClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			((CheckBox)v).setChecked(false);
			int i = v.getId();
			setBtnSelected(i);
			if (i==R.id.id_single_led_1) {
				setBtnActivated(Define.SINGLE_LED_123_ACTIVATE, true);
			} else if (i == R.id.id_single_led_2) {
				setBtnActivated(Define.SINGLE_LED_123_ACTIVATE, true);
			} else if (i == R.id.id_single_led_3) {
				setBtnActivated(Define.SINGLE_LED_123_ACTIVATE, true);
			} else if (i == R.id.id_single_led_4) {
				setBtnActivated(Define.SINGLE_LED_456_ACTIVATE, true);
			} else if (i == R.id.id_single_led_5) {
				setBtnActivated(Define.SINGLE_LED_456_ACTIVATE, true);
			} else if (i == R.id.id_single_led_6) {
				setBtnActivated(Define.SINGLE_LED_456_ACTIVATE, true);
			} else if (i == R.id.id_single_led_7) {
				setBtnActivated(Define.SINGLE_LED_789_ACTIVATE, true);
			} else if (i == R.id.id_single_led_8) {
				setBtnActivated(Define.SINGLE_LED_789_ACTIVATE, true);
			} else if (i == R.id.id_single_led_9) {
				setBtnActivated(Define.SINGLE_LED_789_ACTIVATE, true);
			}
		}
	};

	private void setBtnSelected(int id) {
		Log.d(TAG, "selected");
		for (int i=0;i<Define.NUMBER_OF_COLOR_LED;i++) {
			cbColor[i].setChecked(false);
			if (cbColor[i].getId() == id) {
				cbColor[i].setSelected(true);
			} else {
				cbColor[i].setSelected(false);
			}
		}
		for (int i=0;i<Define.NUMBER_OF_SINGLE_LED;i++) {
			cbSingle[i].setChecked(false);
			if (cbSingle[i].getId() == id) {
				cbSingle[i].setSelected(true);
			} else {
				cbSingle[i].setSelected(false);
			}
		}
	}

	private void setBtnChecked(int id) {
		Log.d(TAG,"Checked");
		for (int i=0;i<Define.NUMBER_OF_COLOR_LED;i++) {
			if (cbColor[i].getId() == id) {
				cbColor[i].setChecked(true);
				cbColor[i].setSelected(true);
			}
			if (cbColor[i].isSelected()) {
				cbColor[i].setChecked(true);
				cbColor[i].setSelected(false);
			}
		}
	}

	/**
	 *
	 * @param ledGroup
	 * @param isSingle
	 */
	private void setBtnActivated(int ledGroup, boolean isSingle) {
		switch (ledGroup) {
			case Define.SINGLE_LED_123_ACTIVATE:
				if (isSingle) {
					cbSingle[0].setBackgroundResource(R.drawable.selector_connector);
					cbSingle[1].setBackgroundResource(R.drawable.selector_connector);
					cbSingle[2].setBackgroundResource(R.drawable.selector_connector);
					cbColor[0].setBackgroundResource(R.drawable.selector_connector_disable);
				} else {
					cbSingle[0].setBackgroundResource(R.drawable.selector_connector_disable);
					cbSingle[1].setBackgroundResource(R.drawable.selector_connector_disable);
					cbSingle[2].setBackgroundResource(R.drawable.selector_connector_disable);
					cbColor[0].setBackgroundResource(R.drawable.selector_connector);
				}
				break;
			case Define.SINGLE_LED_456_ACTIVATE:
				if (isSingle) {
					cbSingle[3].setBackgroundResource(R.drawable.selector_connector);
					cbSingle[4].setBackgroundResource(R.drawable.selector_connector);
					cbSingle[5].setBackgroundResource(R.drawable.selector_connector);
					cbColor[1].setBackgroundResource(R.drawable.selector_connector_disable);
				} else {
					cbSingle[3].setBackgroundResource(R.drawable.selector_connector_disable);
					cbSingle[4].setBackgroundResource(R.drawable.selector_connector_disable);
					cbSingle[5].setBackgroundResource(R.drawable.selector_connector_disable);
					cbColor[1].setBackgroundResource(R.drawable.selector_connector);
				}
				break;
			case Define.SINGLE_LED_789_ACTIVATE:
				if (isSingle) {
					cbSingle[6].setBackgroundResource(R.drawable.selector_connector);
					cbSingle[7].setBackgroundResource(R.drawable.selector_connector);
					cbSingle[8].setBackgroundResource(R.drawable.selector_connector);
					cbColor[2].setBackgroundResource(R.drawable.selector_connector_disable);
				} else {
					cbSingle[6].setBackgroundResource(R.drawable.selector_connector_disable);
					cbSingle[7].setBackgroundResource(R.drawable.selector_connector_disable);
					cbSingle[8].setBackgroundResource(R.drawable.selector_connector_disable);
					cbColor[2].setBackgroundResource(R.drawable.selector_connector);
				}
				break;
		}
	}
}
