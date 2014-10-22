package net.dxs.myscroll;

import net.dxs.myscroll.utils.AppUtils;
import net.dxs.myscroll.utils.DensityUtil;
import net.dxs.myscroll.view.chart.ChartView;
import net.dxs.myscroll.view.layout.MyScrollView;
import net.dxs.myscroll.view.scroll.HVScrollView;
import net.dxs.myscroll.view.scroll.ScrollViewListener;
import net.dxs.myscroll.view.scroll.SyncHorizontalScrollView;
import net.dxs.myscroll.view.scroll.SyncScrollView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity2 extends Activity implements ScrollViewListener, OnCheckedChangeListener {

	private String[] mArr_periodName_1 = { "期次" };
	private String[] mArr_periodTitle_1 = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };
	private String[] mArr_Num_1 = new String[1000];
	private String[] mArr_period_1 = new String[50];

	private SyncScrollView scroll_left_1;
	private SyncHorizontalScrollView scroll_top_1;
	private HVScrollView scroll_center_1;

	private HVScrollView scroll_main_1;

	private TextView mTxt_main_1;

	private LinearLayout mLl_ChartName_1;
	private LinearLayout mLl_ChartTitle_1;
	private LinearLayout mLl_ChartPeriod_1;
	private LinearLayout mLl_ChartNumber_1;

	private int OffsetX_1;
	private int OffsetY_1;

	private String[] mArr_periodName_2 = { "期次" };
	private String[] mArr_periodTitle_2 = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };
	private String[] mArr_Num_2 = new String[1000];
	private String[] mArr_period_2 = new String[50];

	private SyncScrollView scroll_left_2;
	private SyncHorizontalScrollView scroll_top_2;
	private HVScrollView scroll_center_2;

	private HVScrollView scroll_main_2;

	private TextView mTxt_main_2;

	private LinearLayout mLl_ChartName_2;
	private LinearLayout mLl_ChartTitle_2;
	private LinearLayout mLl_ChartPeriod_2;
	private LinearLayout mLl_ChartNumber_2;

	private int OffsetX_2;
	private int OffsetY_2;

	private RadioGroup mRg_Ball;
	private FrameLayout mFl_1;
	private FrameLayout mFl_2;
	private LinearLayout mLl_main;
	private MyScrollView msv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		initUI();
		initData();
		mLl_main.addView(msv);
		//		ViewGroupLayout mViewGroupLayout = new ViewGroupLayout(this);
		//		mViewGroupLayout.addView(mFl_1);
		//		mViewGroupLayout.addView(mFl_2);
		//		mLl_main.addView(mViewGroupLayout);
	}

	private void initUI() {
		msv = new MyScrollView(this);
		mRg_Ball = (RadioGroup) findViewById(R.id.rg_Ball);
		mRg_Ball.setOnCheckedChangeListener(this);
		mLl_main = (LinearLayout) findViewById(R.id.ll_main);

		initUI1();
		initUI2();

		msv.addView(mFl_1);
		msv.addView(mFl_2);

	}

	private void initUI1() {
		View redLayout = View.inflate(this, R.layout.activity_main_red, null);

		mFl_1 = (FrameLayout) redLayout.findViewById(R.id.fl_1);

		mTxt_main_1 = (TextView) redLayout.findViewById(R.id.scroll_main_txt_1);

		scroll_left_1 = (SyncScrollView) redLayout.findViewById(R.id.scroll_left_1);
		scroll_left_1.ableScroll(false);

		scroll_top_1 = (SyncHorizontalScrollView) redLayout.findViewById(R.id.scroll_top_1);
		scroll_top_1.ableScroll(false);

		scroll_center_1 = (HVScrollView) redLayout.findViewById(R.id.scroll_center_1);
		scroll_center_1.ableScroll(false);

		scroll_main_1 = (HVScrollView) redLayout.findViewById(R.id.scroll_main_1);
		scroll_main_1.setScrollViewListener(this);

		final ViewGroup vg_left = (ViewGroup) scroll_left_1.getChildAt(0);
		ViewTreeObserver vto_left = vg_left.getViewTreeObserver();
		vto_left.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				vg_left.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				OffsetX_1 = scroll_left_1.getWidth();
			}
		});

		final ViewGroup vg_top = (ViewGroup) scroll_top_1.getChildAt(0);
		ViewTreeObserver vto_top = vg_top.getViewTreeObserver();
		vto_top.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				vg_top.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				OffsetY_1 = vg_top.getHeight();
			}
		});

		final ViewGroup vg_center = (ViewGroup) scroll_center_1.getChildAt(0);
		ViewTreeObserver vto_center = vg_center.getViewTreeObserver();
		vto_center.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				vg_center.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				mTxt_main_1.setWidth(vg_center.getWidth() + OffsetX_1);
				mTxt_main_1.setHeight(vg_center.getHeight() + OffsetY_1);
			}
		});

		mLl_ChartName_1 = (LinearLayout) redLayout.findViewById(R.id.ll_ChartName_1);
		mLl_ChartTitle_1 = (LinearLayout) redLayout.findViewById(R.id.ll_ChartTitle_1);
		mLl_ChartPeriod_1 = (LinearLayout) redLayout.findViewById(R.id.ll_ChartPeriod_1);
		mLl_ChartNumber_1 = (LinearLayout) redLayout.findViewById(R.id.ll_ChartNumber_1);
	}

	private void initUI2() {
		View blueLayout = View.inflate(this, R.layout.activity_main_blue, null);

		mFl_2 = (FrameLayout) blueLayout.findViewById(R.id.fl_2);

		mTxt_main_2 = (TextView) blueLayout.findViewById(R.id.scroll_main_txt_2);

		scroll_left_2 = (SyncScrollView) blueLayout.findViewById(R.id.scroll_left_2);
		scroll_left_2.ableScroll(false);

		scroll_top_2 = (SyncHorizontalScrollView) blueLayout.findViewById(R.id.scroll_top_2);
		scroll_top_2.ableScroll(false);

		scroll_center_2 = (HVScrollView) blueLayout.findViewById(R.id.scroll_center_2);
		scroll_center_2.ableScroll(false);

		scroll_main_2 = (HVScrollView) blueLayout.findViewById(R.id.scroll_main_2);
		scroll_main_2.setScrollViewListener(this);

		final ViewGroup vg_left = (ViewGroup) scroll_left_2.getChildAt(0);
		ViewTreeObserver vto_left = vg_left.getViewTreeObserver();
		vto_left.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				vg_left.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				OffsetX_2 = scroll_left_2.getWidth();
			}
		});

		final ViewGroup vg_top = (ViewGroup) scroll_top_2.getChildAt(0);
		ViewTreeObserver vto_top = vg_top.getViewTreeObserver();
		vto_top.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				vg_top.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				OffsetY_2 = vg_top.getHeight();
			}
		});

		final ViewGroup vg_center = (ViewGroup) scroll_center_2.getChildAt(0);
		ViewTreeObserver vto_center = vg_center.getViewTreeObserver();
		vto_center.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				vg_center.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				mTxt_main_2.setWidth(vg_center.getWidth() + OffsetX_2);
				mTxt_main_2.setHeight(vg_center.getHeight() + OffsetY_2);
			}
		});

		mLl_ChartName_2 = (LinearLayout) blueLayout.findViewById(R.id.ll_ChartName_2);
		mLl_ChartTitle_2 = (LinearLayout) blueLayout.findViewById(R.id.ll_ChartTitle_2);
		mLl_ChartPeriod_2 = (LinearLayout) blueLayout.findViewById(R.id.ll_ChartPeriod_2);
		mLl_ChartNumber_2 = (LinearLayout) blueLayout.findViewById(R.id.ll_ChartNumber_2);
	}

	private void initData() {
		deviceInfo();
		initData1();
		initData2();
	}

	private void initData1() {
		for (int i = 0; i < mArr_Num_1.length; i++) {
			mArr_Num_1[i] = String.valueOf(i);
		}
		for (int i = 0; i < mArr_period_1.length; i++) {
			mArr_period_1[i] = String.valueOf(201401 + i);
		}

		ChartView mPeriodName_chartView = new ChartView(this, DensityUtil.dip2px(this, 80), DensityUtil.dip2px(this, 40), 1, mArr_periodName_1);
		ChartView mPeriodTitle_chartView = new ChartView(this, DensityUtil.dip2px(this, 40), DensityUtil.dip2px(this, 40), 20, mArr_periodTitle_1);
		ChartView mPeriod_chartView = new ChartView(this, DensityUtil.dip2px(this, 80), DensityUtil.dip2px(this, 40), 1, mArr_period_1);
		ChartView mNum_chartView = new ChartView(this, DensityUtil.dip2px(this, 40), DensityUtil.dip2px(this, 40), 20, mArr_Num_1);

		mLl_ChartName_1.addView(mPeriodName_chartView);
		mLl_ChartTitle_1.addView(mPeriodTitle_chartView);
		mLl_ChartPeriod_1.addView(mPeriod_chartView);
		mLl_ChartNumber_1.addView(mNum_chartView);
	}

	private void initData2() {
		for (int i = 0; i < mArr_Num_2.length; i++) {
			mArr_Num_2[i] = String.valueOf(i);
		}
		for (int i = 0; i < mArr_period_2.length; i++) {
			mArr_period_2[i] = String.valueOf(201501 + i);
		}

		ChartView mPeriodName_chartView = new ChartView(this, DensityUtil.dip2px(this, 80), DensityUtil.dip2px(this, 40), 1, mArr_periodName_2);
		ChartView mPeriodTitle_chartView = new ChartView(this, DensityUtil.dip2px(this, 40), DensityUtil.dip2px(this, 40), 20, mArr_periodTitle_2);
		ChartView mPeriod_chartView = new ChartView(this, DensityUtil.dip2px(this, 80), DensityUtil.dip2px(this, 40), 1, mArr_period_2);
		ChartView mNum_chartView = new ChartView(this, DensityUtil.dip2px(this, 40), DensityUtil.dip2px(this, 40), 20, mArr_Num_2);

		mLl_ChartName_2.addView(mPeriodName_chartView);
		mLl_ChartTitle_2.addView(mPeriodTitle_chartView);
		mLl_ChartPeriod_2.addView(mPeriod_chartView);
		mLl_ChartNumber_2.addView(mNum_chartView);
	}

	/**
	 * 设备信息
	 */
	private void deviceInfo() {
		Display display = getWindowManager().getDefaultDisplay();
		DisplayMetrics displayMetrics = new DisplayMetrics();
		display.getMetrics(displayMetrics);
		AppUtils.DENSITY = displayMetrics.density;
		AppUtils.WIDTH = displayMetrics.widthPixels;
		AppUtils.HEIGHT = displayMetrics.heightPixels;
	}

	@Override
	public void onScrollChanged(FrameLayout layout, int x, int y, int oldx, int oldy) {
		switch (layout.getId()) {
		case R.id.scroll_main_1:
			System.out.println("fl1--->");
			scroll_left_1.scrollTo((int) scroll_left_1.getX(), y);
			scroll_top_1.scrollTo(x, (int) scroll_top_1.getY());
			scroll_center_1.scrollTo(x, y);
			break;
		case R.id.scroll_main_2:
			System.out.println("fl2--->");
			scroll_left_2.scrollTo((int) scroll_left_2.getX(), y);
			scroll_top_2.scrollTo(x, (int) scroll_top_2.getY());
			scroll_center_2.scrollTo(x, y);
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {

		switch (checkedId) {
		case R.id.rb_RedBall:
			System.out.println("红球");
			msv.moveToDest(0);

			break;
		case R.id.rb_BlueBall:
			System.out.println("蓝球");
			msv.moveToDest(1);

			break;
		}

	}
}
